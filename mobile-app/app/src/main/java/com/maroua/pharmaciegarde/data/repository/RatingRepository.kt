package com.maroua.pharmaciegarde.data.repository

import com.maroua.pharmaciegarde.data.model.RatingRequest
import com.maroua.pharmaciegarde.data.model.RatingSubmitResponse
import com.maroua.pharmaciegarde.data.model.RatingsResponse
import com.maroua.pharmaciegarde.data.remote.RatingApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository pour gérer les notations des pharmacies
 */
@Singleton
class RatingRepository @Inject constructor(
    private val ratingApiService: RatingApiService
) {
    /**
     * Récupérer les notations d'une pharmacie avec pagination
     * @param pharmacyId ID de la pharmacie
     * @param limit Nombre d'avis à récupérer (par défaut 10)
     * @param offset Nombre d'avis à ignorer (pour la pagination)
     */
    fun getPharmacyRatings(
        pharmacyId: Int,
        limit: Int = 10,
        offset: Int = 0
    ): Flow<kotlin.Result<RatingsResponse>> = flow {
        try {
            val response = ratingApiService.getPharmacyRatings(pharmacyId, limit, offset)
            emit(kotlin.Result.success(response))
        } catch (e: Exception) {
            emit(kotlin.Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Soumettre une notation pour une pharmacie
     */
    fun submitRating(
        pharmacyId: Int,
        rating: Int,
        comment: String?,
        userName: String?,
        deviceId: String?
    ): Flow<kotlin.Result<RatingSubmitResponse>> = flow {
        try {
            val request = RatingRequest(
                rating = rating,
                comment = comment,
                userName = userName,
                deviceId = deviceId
            )
            val response = ratingApiService.submitRating(pharmacyId, request)
            emit(kotlin.Result.success(response))
        } catch (e: Exception) {
            emit(kotlin.Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)
}
