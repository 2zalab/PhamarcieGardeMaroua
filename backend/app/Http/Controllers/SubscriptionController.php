<?php

namespace App\Http\Controllers;

use App\Models\Payment;
use App\Models\Subscription;
use App\Models\User;
use Carbon\Carbon;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Validator;

class SubscriptionController extends Controller
{
    /**
     * Activer un abonnement après paiement réussi
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function activateSubscription(Request $request): JsonResponse
    {
        $validator = Validator::make($request->all(), [
            'subscription_type' => 'required|in:MONTHLY,ANNUAL',
            'payment_reference' => 'required|string',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'success' => false,
                'message' => 'Données invalides',
                'errors' => $validator->errors(),
            ], 422);
        }

        $user = $request->user();
        $subscriptionType = $request->input('subscription_type');
        $paymentReference = $request->input('payment_reference');

        // Vérifier que le paiement existe et est réussi
        $payment = Payment::where('user_id', $user->id)
            ->where(function ($query) use ($paymentReference) {
                $query->where('external_reference', $paymentReference)
                    ->orWhere('campay_reference', $paymentReference);
            })
            ->first();

        if (!$payment) {
            return response()->json([
                'success' => false,
                'message' => 'Paiement introuvable',
            ], 404);
        }

        if (!$payment->isSuccessful()) {
            return response()->json([
                'success' => false,
                'message' => 'Le paiement n\'est pas encore confirmé',
            ], 400);
        }

        // Vérifier que le paiement n'est pas déjà utilisé
        if (Subscription::where('payment_id', $payment->id)->exists()) {
            return response()->json([
                'success' => false,
                'message' => 'Ce paiement a déjà été utilisé pour un abonnement',
            ], 400);
        }

        // Vérifier que le montant correspond au type d'abonnement
        $expectedAmount = $subscriptionType === 'MONTHLY' ? 500 : 5000;
        if ($payment->amount != $expectedAmount) {
            return response()->json([
                'success' => false,
                'message' => 'Le montant du paiement ne correspond pas au type d\'abonnement',
            ], 400);
        }

        try {
            return DB::transaction(function () use ($user, $subscriptionType, $payment) {
                // Annuler l'abonnement actif s'il existe
                $activeSubscription = Subscription::where('user_id', $user->id)
                    ->where('status', 'ACTIVE')
                    ->first();

                if ($activeSubscription) {
                    $activeSubscription->cancel('Mise à niveau vers nouvel abonnement');
                }

                // Créer le nouvel abonnement
                $startsAt = now();
                $expiresAt = $subscriptionType === 'MONTHLY'
                    ? $startsAt->copy()->addMonth()
                    : $startsAt->copy()->addYear();

                $subscription = Subscription::create([
                    'user_id' => $user->id,
                    'payment_id' => $payment->id,
                    'subscription_type' => $subscriptionType,
                    'status' => 'ACTIVE',
                    'starts_at' => $startsAt,
                    'expires_at' => $expiresAt,
                ]);

                // Mettre à jour l'utilisateur
                $user->update([
                    'is_subscribed' => true,
                    'subscription_type' => $subscriptionType,
                    'subscription_expires_at' => $expiresAt,
                ]);

                return response()->json([
                    'success' => true,
                    'message' => 'Abonnement activé avec succès',
                    'data' => [
                        'subscription_id' => $subscription->id,
                        'subscription_type' => $subscriptionType,
                        'status' => 'ACTIVE',
                        'starts_at' => $startsAt->toISOString(),
                        'expires_at' => $expiresAt->toISOString(),
                        'user' => [
                            'id' => $user->id,
                            'name' => $user->name,
                            'email' => $user->email,
                            'is_subscribed' => true,
                            'subscription_type' => $subscriptionType,
                            'subscription_expires_at' => $expiresAt->toISOString(),
                        ],
                    ],
                ]);
            });
        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de l\'activation de l\'abonnement: ' . $e->getMessage(),
            ], 500);
        }
    }

    /**
     * Vérifier le statut d'abonnement actuel
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function checkSubscriptionStatus(Request $request): JsonResponse
    {
        $user = $request->user();

        // Vérifier si l'abonnement a expiré et mettre à jour si nécessaire
        if ($user->is_subscribed && $user->subscription_expires_at && $user->subscription_expires_at->isPast()) {
            $user->update([
                'is_subscribed' => false,
                'subscription_type' => 'FREE',
            ]);

            // Marquer l'abonnement comme expiré
            $activeSubscription = Subscription::where('user_id', $user->id)
                ->where('status', 'ACTIVE')
                ->first();

            if ($activeSubscription) {
                $activeSubscription->markAsExpired();
            }
        }

        return response()->json([
            'success' => true,
            'data' => [
                'subscription_id' => null,
                'subscription_type' => $user->subscription_type ?? 'FREE',
                'status' => $user->is_subscribed ? 'ACTIVE' : 'EXPIRED',
                'starts_at' => null,
                'expires_at' => $user->subscription_expires_at?->toISOString(),
                'user' => [
                    'id' => $user->id,
                    'name' => $user->name,
                    'email' => $user->email,
                    'is_subscribed' => $user->is_subscribed ?? false,
                    'subscription_type' => $user->subscription_type ?? 'FREE',
                    'subscription_expires_at' => $user->subscription_expires_at?->toISOString(),
                ],
            ],
        ]);
    }

    /**
     * Annuler l'abonnement
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function cancelSubscription(Request $request): JsonResponse
    {
        $user = $request->user();

        if (!$user->is_subscribed) {
            return response()->json([
                'success' => false,
                'message' => 'Aucun abonnement actif à annuler',
            ], 400);
        }

        try {
            return DB::transaction(function () use ($user) {
                // Trouver l'abonnement actif
                $activeSubscription = Subscription::where('user_id', $user->id)
                    ->where('status', 'ACTIVE')
                    ->first();

                if ($activeSubscription) {
                    $activeSubscription->cancel('Annulation par l\'utilisateur');
                }

                // Mettre à jour l'utilisateur
                $user->update([
                    'is_subscribed' => false,
                    'subscription_type' => 'FREE',
                    'subscription_expires_at' => null,
                ]);

                return response()->json([
                    'success' => true,
                    'message' => 'Abonnement annulé avec succès',
                    'data' => [
                        'subscription_id' => null,
                        'subscription_type' => 'FREE',
                        'status' => 'CANCELLED',
                        'starts_at' => null,
                        'expires_at' => null,
                        'user' => [
                            'id' => $user->id,
                            'name' => $user->name,
                            'email' => $user->email,
                            'is_subscribed' => false,
                            'subscription_type' => 'FREE',
                            'subscription_expires_at' => null,
                        ],
                    ],
                ]);
            });
        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de l\'annulation: ' . $e->getMessage(),
            ], 500);
        }
    }

    /**
     * Obtenir l'historique des abonnements
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function getSubscriptionHistory(Request $request): JsonResponse
    {
        $user = $request->user();

        $subscriptions = Subscription::where('user_id', $user->id)
            ->with('payment')
            ->orderBy('created_at', 'desc')
            ->get()
            ->map(function ($subscription) {
                return [
                    'id' => $subscription->id,
                    'subscription_type' => $subscription->subscription_type,
                    'status' => $subscription->status,
                    'starts_at' => $subscription->starts_at->toISOString(),
                    'expires_at' => $subscription->expires_at?->toISOString(),
                    'cancelled_at' => $subscription->cancelled_at?->toISOString(),
                    'cancellation_reason' => $subscription->cancellation_reason,
                    'payment' => $subscription->payment ? [
                        'id' => $subscription->payment->id,
                        'amount' => $subscription->payment->amount,
                        'currency' => $subscription->payment->currency,
                        'status' => $subscription->payment->status,
                    ] : null,
                ];
            });

        return response()->json([
            'success' => true,
            'data' => $subscriptions,
        ]);
    }
}
