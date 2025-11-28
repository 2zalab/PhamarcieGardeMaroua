<?php

namespace App\Http\Controllers;

use App\Models\Payment;
use App\Models\Subscription;
use App\Services\CamPayService;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Validator;

class PaymentController extends Controller
{
    private CamPayService $camPayService;

    public function __construct(CamPayService $camPayService)
    {
        $this->camPayService = $camPayService;
    }

    /**
     * Initier un paiement CamPay
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function initiateCamPayPayment(Request $request): JsonResponse
    {
        $validator = Validator::make($request->all(), [
            'amount' => 'required|integer|min:100',
            'description' => 'required|string|max:255',
            'phone_number' => 'required|string|regex:/^[0-9]+$/|min:9',
            'external_reference' => 'nullable|string|unique:payments,external_reference',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'success' => false,
                'message' => 'Données de paiement invalides',
                'errors' => $validator->errors(),
            ], 422);
        }

        $user = $request->user();
        $amount = $request->input('amount');
        $description = $request->input('description');
        $phoneNumber = $request->input('phone_number');
        $externalReference = $request->input('external_reference')
            ?? CamPayService::generateExternalReference();

        // Créer l'enregistrement de paiement
        $payment = Payment::create([
            'user_id' => $user->id,
            'external_reference' => $externalReference,
            'amount' => $amount,
            'currency' => 'XAF',
            'description' => $description,
            'status' => 'PENDING',
            'payment_provider' => 'CAMPAY',
        ]);

        // Initier le paiement avec CamPay
        $result = $this->camPayService->initiatePayment($amount, $description, $externalReference, $phoneNumber);

        if ($result['success']) {
            // Mettre à jour le paiement avec les données CamPay
            $payment->update([
                'campay_reference' => $result['data']['reference'] ?? null,
                'ussd_code' => $result['data']['ussd_code'] ?? null,
                'payment_method' => $result['data']['operator'] ?? null,
                'campay_response' => $result['data'] ?? [],
            ]);

            return response()->json([
                'success' => true,
                'message' => 'Paiement initié avec succès',
                'data' => [
                    'payment_id' => $payment->id,
                    'reference' => $result['data']['reference'] ?? null,
                    'external_reference' => $externalReference,
                    'ussd_code' => $result['data']['ussd_code'] ?? null,
                    'amount' => $amount,
                    'currency' => 'XAF',
                    'description' => $description,
                    'status' => 'PENDING',
                ],
            ]);
        }

        // En cas d'échec, marquer le paiement comme échoué
        $payment->markAsFailed($result['message'] ?? 'Erreur CamPay');

        return response()->json([
            'success' => false,
            'message' => $result['message'] ?? 'Échec de l\'initiation du paiement',
        ], 500);
    }

    /**
     * Vérifier le statut d'un paiement
     *
     * @param string $reference
     * @return JsonResponse
     */
    public function checkPaymentStatus(string $reference): JsonResponse
    {
        $user = auth()->user();

        Log::info('🔍 [CHECK_STATUS] Vérification du statut de paiement', [
            'reference' => $reference,
            'user_id' => $user->id,
        ]);

        // Trouver le paiement par référence externe ou CamPay
        $payment = Payment::where('user_id', $user->id)
            ->where(function ($query) use ($reference) {
                $query->where('external_reference', $reference)
                    ->orWhere('campay_reference', $reference);
            })
            ->first();

        if (!$payment) {
            Log::warning('❌ [CHECK_STATUS] Paiement introuvable', [
                'reference' => $reference,
                'user_id' => $user->id,
            ]);

            return response()->json([
                'success' => false,
                'message' => 'Paiement introuvable',
            ], 404);
        }

        Log::info('📋 [CHECK_STATUS] Paiement trouvé', [
            'payment_id' => $payment->id,
            'current_status' => $payment->status,
        ]);

        // Si le paiement est déjà réussi, retourner directement le statut
        if ($payment->isSuccessful()) {
            Log::info('✅ [CHECK_STATUS] Paiement déjà marqué comme SUCCESSFUL', [
                'payment_id' => $payment->id,
            ]);

            return response()->json([
                'success' => true,
                'status' => 'SUCCESSFUL',
                'data' => [
                    'payment_id' => $payment->id,
                    'reference' => $payment->campay_reference,
                    'external_reference' => $payment->external_reference,
                    'amount' => $payment->amount,
                    'currency' => $payment->currency,
                    'status' => 'SUCCESSFUL',
                    'paid_at' => $payment->paid_at?->toISOString(),
                ],
            ]);
        }

        // Vérifier le statut auprès de CamPay
        $campayReference = $payment->campay_reference ?? $reference;
        Log::info('📡 [CHECK_STATUS] Interrogation CamPay', [
            'campay_reference' => $campayReference,
        ]);

        $result = $this->camPayService->checkPaymentStatus($campayReference);

        if ($result['success']) {
            $status = $result['status'];
            Log::info('📥 [CHECK_STATUS] Réponse CamPay reçue', [
                'status' => $status,
            ]);

            // Mettre à jour le paiement selon le statut
            if ($status === 'SUCCESSFUL' && !$payment->isSuccessful()) {
                Log::info('🎉 [CHECK_STATUS] Paiement SUCCESSFUL détecté, activation...', [
                    'payment_id' => $payment->id,
                ]);

                $payment->markAsSuccessful();
                Log::info('✅ [CHECK_STATUS] Paiement marqué comme SUCCESSFUL');

                // Activer automatiquement l'abonnement
                Log::info('🚀 [CHECK_STATUS] Déclenchement de autoActivateSubscription');
                $this->autoActivateSubscription($payment);
            } elseif ($status === 'FAILED' && !$payment->isFailed()) {
                Log::warning('❌ [CHECK_STATUS] Paiement FAILED détecté');
                $payment->markAsFailed($result['data']['code'] ?? 'Paiement échoué');
            }

            return response()->json([
                'success' => true,
                'status' => $status,
                'data' => [
                    'payment_id' => $payment->id,
                    'reference' => $payment->campay_reference,
                    'external_reference' => $payment->external_reference,
                    'amount' => $payment->amount,
                    'currency' => $payment->currency,
                    'status' => $status,
                    'paid_at' => $payment->paid_at?->toISOString(),
                ],
            ]);
        }

        return response()->json([
            'success' => false,
            'message' => $result['message'] ?? 'Impossible de vérifier le statut',
            'status' => 'UNKNOWN',
        ], 500);
    }

    /**
     * Obtenir l'historique des paiements de l'utilisateur
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function getPaymentHistory(Request $request): JsonResponse
    {
        $user = $request->user();

        $payments = Payment::where('user_id', $user->id)
            ->orderBy('created_at', 'desc')
            ->get()
            ->map(function ($payment) {
                return [
                    'id' => $payment->id,
                    'reference' => $payment->external_reference,
                    'amount' => $payment->amount,
                    'currency' => $payment->currency,
                    'description' => $payment->description,
                    'status' => $payment->status,
                    'payment_method' => $payment->payment_method,
                    'created_at' => $payment->created_at->toISOString(),
                    'paid_at' => $payment->paid_at?->toISOString(),
                ];
            });

        return response()->json([
            'success' => true,
            'data' => $payments,
        ]);
    }

    /**
     * Activer automatiquement l'abonnement après paiement réussi
     *
     * @param Payment $payment
     * @return void
     */
    private function autoActivateSubscription(Payment $payment): void
    {
        try {
            // Vérifier si un abonnement n'existe pas déjà pour ce paiement
            if (Subscription::where('payment_id', $payment->id)->exists()) {
                Log::info('Subscription already exists for payment', [
                    'payment_id' => $payment->id,
                ]);
                return;
            }

            DB::transaction(function () use ($payment) {
                // Déterminer le type d'abonnement basé sur le montant
                $subscriptionType = $payment->amount == 500 ? 'MONTHLY' : 'ANNUAL';

                Log::info('Auto-activating subscription from payment check', [
                    'payment_id' => $payment->id,
                    'amount' => $payment->amount,
                    'subscription_type' => $subscriptionType,
                ]);

                // Annuler l'abonnement actif s'il existe
                $activeSubscription = Subscription::where('user_id', $payment->user_id)
                    ->where('status', 'ACTIVE')
                    ->first();

                if ($activeSubscription) {
                    $activeSubscription->cancel('Mise à niveau vers nouvel abonnement');
                    Log::info('Previous subscription cancelled', [
                        'subscription_id' => $activeSubscription->id,
                        'user_id' => $payment->user_id,
                    ]);
                }

                // Créer le nouvel abonnement
                $startsAt = now();
                $expiresAt = $subscriptionType === 'MONTHLY'
                    ? $startsAt->copy()->addMonth()
                    : $startsAt->copy()->addYear();

                $subscription = Subscription::create([
                    'user_id' => $payment->user_id,
                    'payment_id' => $payment->id,
                    'subscription_type' => $subscriptionType,
                    'status' => 'ACTIVE',
                    'starts_at' => $startsAt,
                    'expires_at' => $expiresAt,
                ]);

                // Mettre à jour l'utilisateur
                $user = $payment->user;
                $user->update([
                    'is_subscribed' => true,
                    'subscription_type' => $subscriptionType,
                    'subscription_expires_at' => $expiresAt,
                ]);

                Log::info('Subscription auto-activated successfully from payment check', [
                    'subscription_id' => $subscription->id,
                    'user_id' => $user->id,
                    'subscription_type' => $subscriptionType,
                    'expires_at' => $expiresAt->toISOString(),
                ]);
            });
        } catch (\Exception $e) {
            Log::error('Auto-activation subscription error from payment check', [
                'payment_id' => $payment->id,
                'user_id' => $payment->user_id ?? null,
                'error' => $e->getMessage(),
                'trace' => $e->getTraceAsString(),
            ]);
        }
    }
}
