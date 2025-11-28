package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionRequest
import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse
import com.maroua.pharmaciegarde.data.model.CamPayPaymentRequest
import com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse
import com.maroua.pharmaciegarde.data.model.PaymentStatusResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * API Service pour gérer les abonnements et paiements
 */
interface SubscriptionApiService {

    /**
     * Initier un paiement via CamPay
     */
    @POST("payments/campay/initiate")
    suspend fun initiateCamPayPayment(
        @Body request: CamPayPaymentRequest
    ): Response<CamPayPaymentResponse>

    /**
     * Vérifier le statut d'un paiement
     */
    @GET("payments/{reference}/status")
    suspend fun checkPaymentStatus(
        @Path("reference") reference: String
    ): Response<PaymentStatusResponse>

    /**
     * Activer l'abonnement après paiement réussi
     */
    @POST("subscriptions/activate")
    suspend fun activateSubscription(
        @Body request: ActivateSubscriptionRequest
    ): Response<ActivateSubscriptionResponse>

    /**
     * Vérifier le statut d'abonnement actuel de l'utilisateur
     */
    @GET("subscriptions/status")
    suspend fun checkSubscriptionStatus(): Response<ActivateSubscriptionResponse>

    /**
     * Annuler l'abonnement
     */
    @POST("subscriptions/cancel")
    suspend fun cancelSubscription(): Response<ActivateSubscriptionResponse>
}
