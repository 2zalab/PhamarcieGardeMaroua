<?php

namespace App\Services;

use App\Models\Payment;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Str;

class CamPayService
{
    private string $baseUrl;
    private string $appUsername;
    private string $appPassword;
    private string $apiKey;

    public function __construct()
    {
        $this->baseUrl = config('services.campay.base_url', 'https://demo.campay.net/api');
        $this->appUsername = config('services.campay.app_username');
        $this->appPassword = config('services.campay.app_password');
        $this->apiKey = config('services.campay.api_key');
    }

    /**
     * Obtenir le token d'authentification CamPay
     */
    private function getToken(): ?string
    {
        try {
            $response = Http::post("{$this->baseUrl}/token/", [
                'username' => $this->appUsername,
                'password' => $this->appPassword,
            ]);

            if ($response->successful()) {
                return $response->json('token');
            }

            Log::error('CamPay authentication failed', [
                'status' => $response->status(),
                'body' => $response->body(),
            ]);

            return null;
        } catch (\Exception $e) {
            Log::error('CamPay authentication exception', [
                'message' => $e->getMessage(),
            ]);

            return null;
        }
    }

    /**
     * Initier un paiement CamPay
     *
     * @param int $amount Montant en FCFA
     * @param string $description Description du paiement
     * @param string $externalReference Référence externe unique
     * @param string $phoneNumber Numéro de téléphone du client (ex: 237670000000)
     * @return array
     */
    public function initiatePayment(int $amount, string $description, string $externalReference, string $phoneNumber): array
    {
        $token = $this->getToken();

        if (!$token) {
            return [
                'success' => false,
                'message' => 'Échec de l\'authentification CamPay',
            ];
        }

        // Valider le format du numéro de téléphone
        if (!preg_match('/^[0-9]+$/', $phoneNumber)) {
            return [
                'success' => false,
                'message' => 'Invalid phone number. Must be digits only',
            ];
        }

        try {
            $response = Http::withHeaders([
                'Authorization' => "Token {$token}",
                'Content-Type' => 'application/json',
            ])->post("{$this->baseUrl}/collect/", [
                'amount' => $amount,
                'currency' => 'XAF',
                'from' => $phoneNumber,
                'description' => $description,
                'external_reference' => $externalReference,
            ]);

            $responseData = $response->json();

            if ($response->successful() && isset($responseData['reference'])) {
                return [
                    'success' => true,
                    'message' => 'Paiement initié avec succès',
                    'data' => [
                        'reference' => $responseData['reference'],
                        'ussd_code' => $responseData['ussd_code'] ?? null,
                        'operator' => $responseData['operator'] ?? null,
                        'amount' => $amount,
                        'currency' => 'XAF',
                        'description' => $description,
                        'external_reference' => $externalReference,
                        'status' => $responseData['status'] ?? 'PENDING',
                    ],
                ];
            }

            Log::error('CamPay payment initiation failed', [
                'status' => $response->status(),
                'response' => $responseData,
            ]);

            return [
                'success' => false,
                'message' => $responseData['message'] ?? 'Échec de l\'initiation du paiement',
            ];
        } catch (\Exception $e) {
            Log::error('CamPay payment initiation exception', [
                'message' => $e->getMessage(),
                'trace' => $e->getTraceAsString(),
            ]);

            return [
                'success' => false,
                'message' => 'Erreur lors de l\'initiation du paiement: ' . $e->getMessage(),
            ];
        }
    }

    /**
     * Vérifier le statut d'un paiement
     *
     * @param string $reference Référence CamPay ou référence externe
     * @return array
     */
    public function checkPaymentStatus(string $reference): array
    {
        $token = $this->getToken();

        if (!$token) {
            return [
                'success' => false,
                'message' => 'Échec de l\'authentification CamPay',
            ];
        }

        try {
            $response = Http::withHeaders([
                'Authorization' => "Token {$token}",
                'Content-Type' => 'application/json',
            ])->get("{$this->baseUrl}/transaction/{$reference}/");

            $responseData = $response->json();

            if ($response->successful()) {
                return [
                    'success' => true,
                    'status' => $responseData['status'] ?? 'PENDING',
                    'data' => [
                        'reference' => $responseData['reference'] ?? $reference,
                        'external_reference' => $responseData['external_reference'] ?? null,
                        'amount' => $responseData['amount'] ?? 0,
                        'currency' => $responseData['currency'] ?? 'XAF',
                        'operator' => $responseData['operator'] ?? null,
                        'code' => $responseData['code'] ?? null,
                        'operator_reference' => $responseData['operator_reference'] ?? null,
                        'status' => $responseData['status'] ?? 'PENDING',
                        'description' => $responseData['description'] ?? null,
                    ],
                ];
            }

            Log::error('CamPay status check failed', [
                'status' => $response->status(),
                'response' => $responseData,
            ]);

            return [
                'success' => false,
                'message' => 'Échec de la vérification du statut',
                'status' => 'UNKNOWN',
            ];
        } catch (\Exception $e) {
            Log::error('CamPay status check exception', [
                'message' => $e->getMessage(),
            ]);

            return [
                'success' => false,
                'message' => 'Erreur lors de la vérification: ' . $e->getMessage(),
                'status' => 'UNKNOWN',
            ];
        }
    }

    /**
     * Traiter le webhook CamPay
     *
     * @param array $webhookData Données du webhook
     * @return bool
     */
    public function processWebhook(array $webhookData): bool
    {
        try {
            $reference = $webhookData['reference'] ?? null;
            $externalReference = $webhookData['external_reference'] ?? null;
            $status = $webhookData['status'] ?? null;

            if (!$reference || !$externalReference || !$status) {
                Log::warning('CamPay webhook missing required fields', $webhookData);
                return false;
            }

            // Trouver le paiement par référence externe
            $payment = Payment::where('external_reference', $externalReference)->first();

            if (!$payment) {
                Log::warning('CamPay webhook for unknown payment', [
                    'external_reference' => $externalReference,
                ]);
                return false;
            }

            // Mettre à jour la référence CamPay si pas encore définie
            if (!$payment->campay_reference) {
                $payment->campay_reference = $reference;
            }

            // Mettre à jour le statut du paiement
            if ($status === 'SUCCESSFUL') {
                $payment->markAsSuccessful();
                Log::info('Payment marked as successful via webhook', [
                    'payment_id' => $payment->id,
                    'reference' => $reference,
                ]);
            } elseif ($status === 'FAILED') {
                $errorMessage = $webhookData['reason'] ?? 'Paiement échoué';
                $payment->markAsFailed($errorMessage);
                Log::info('Payment marked as failed via webhook', [
                    'payment_id' => $payment->id,
                    'reference' => $reference,
                    'reason' => $errorMessage,
                ]);
            }

            // Sauvegarder la réponse complète du webhook
            $payment->campay_response = $webhookData;
            $payment->save();

            return true;
        } catch (\Exception $e) {
            Log::error('CamPay webhook processing exception', [
                'message' => $e->getMessage(),
                'data' => $webhookData,
            ]);

            return false;
        }
    }

    /**
     * Générer une référence externe unique
     */
    public static function generateExternalReference(): string
    {
        return 'PG-' . strtoupper(Str::random(10)) . '-' . time();
    }
}
