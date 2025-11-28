package com.maroua.pharmaciegarde.data.repository

import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionRequest
import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse
import com.maroua.pharmaciegarde.data.model.CamPayPaymentRequest
import com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse
import com.maroua.pharmaciegarde.data.model.PaymentStatusResponse
import com.maroua.pharmaciegarde.data.model.SubscriptionType
import com.maroua.pharmaciegarde.data.remote.SubscriptionApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository pour gérer les abonnements et paiements
 */
@Singleton
class SubscriptionRepository @Inject constructor(
    private val subscriptionApi: SubscriptionApiService
) {

    /**
     * Initier un paiement CamPay
     */
    fun initiateCamPayPayment(
        amount: Int,
        description: String,
        externalReference: String
    ): Flow<Result<CamPayPaymentResponse>> = flow {
        try {
            val request = CamPayPaymentRequest(
                amount = amount,
                description = description,
                externalReference = externalReference
            )
            val response = subscriptionApi.initiateCamPayPayment(request)

            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Exception("Échec de l'initiation du paiement: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    /**
     * Vérifier le statut d'un paiement
     */
    fun checkPaymentStatus(reference: String): Flow<Result<PaymentStatusResponse>> = flow {
        try {
            val response = subscriptionApi.checkPaymentStatus(reference)

            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Exception("Échec de la vérification du paiement: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    /**
     * Activer l'abonnement après paiement réussi
     */
    fun activateSubscription(
        subscriptionType: SubscriptionType,
        paymentReference: String
    ): Flow<Result<ActivateSubscriptionResponse>> = flow {
        try {
            val request = ActivateSubscriptionRequest(
                subscriptionType = subscriptionType.name,
                paymentReference = paymentReference
            )
            val response = subscriptionApi.activateSubscription(request)

            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Exception("Échec de l'activation de l'abonnement: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    /**
     * Vérifier le statut d'abonnement actuel
     */
    fun checkSubscriptionStatus(): Flow<Result<ActivateSubscriptionResponse>> = flow {
        try {
            val response = subscriptionApi.checkSubscriptionStatus()

            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Exception("Échec de la vérification de l'abonnement: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    /**
     * Annuler l'abonnement
     */
    fun cancelSubscription(): Flow<Result<ActivateSubscriptionResponse>> = flow {
        try {
            val response = subscriptionApi.cancelSubscription()

            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Exception("Échec de l'annulation de l'abonnement: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
