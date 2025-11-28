<?php

namespace App\Http\Controllers;

use App\Models\Payment;
use App\Services\CamPayService;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
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
        $result = $this->camPayService->initiatePayment($amount, $description, $externalReference);

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

        // Trouver le paiement par référence externe ou CamPay
        $payment = Payment::where('user_id', $user->id)
            ->where(function ($query) use ($reference) {
                $query->where('external_reference', $reference)
                    ->orWhere('campay_reference', $reference);
            })
            ->first();

        if (!$payment) {
            return response()->json([
                'success' => false,
                'message' => 'Paiement introuvable',
            ], 404);
        }

        // Si le paiement est déjà réussi, retourner directement le statut
        if ($payment->isSuccessful()) {
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
        $result = $this->camPayService->checkPaymentStatus($campayReference);

        if ($result['success']) {
            $status = $result['status'];

            // Mettre à jour le paiement selon le statut
            if ($status === 'SUCCESSFUL' && !$payment->isSuccessful()) {
                $payment->markAsSuccessful();
            } elseif ($status === 'FAILED' && !$payment->isFailed()) {
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
}
