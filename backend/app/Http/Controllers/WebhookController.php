<?php

namespace App\Http\Controllers;

use App\Services\CamPayService;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;

class WebhookController extends Controller
{
    private CamPayService $camPayService;

    public function __construct(CamPayService $camPayService)
    {
        $this->camPayService = $camPayService;
    }

    /**
     * Gérer les notifications webhook de CamPay
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function handleCamPayWebhook(Request $request): JsonResponse
    {
        // Logger tous les webhooks reçus pour le débogage
        Log::info('CamPay webhook received', [
            'headers' => $request->headers->all(),
            'body' => $request->all(),
        ]);

        // Vérifier que le webhook contient les données nécessaires
        $webhookData = $request->all();

        if (empty($webhookData)) {
            Log::warning('CamPay webhook with empty data');

            return response()->json([
                'success' => false,
                'message' => 'Données webhook vides',
            ], 400);
        }

        // Traiter le webhook
        $processed = $this->camPayService->processWebhook($webhookData);

        if ($processed) {
            return response()->json([
                'success' => true,
                'message' => 'Webhook traité avec succès',
            ]);
        }

        return response()->json([
            'success' => false,
            'message' => 'Échec du traitement du webhook',
        ], 500);
    }
}
