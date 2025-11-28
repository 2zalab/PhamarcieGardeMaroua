package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.model.RatingRequest
import com.maroua.pharmaciegarde.data.model.RatingSubmitResponse
import com.maroua.pharmaciegarde.data.model.RatingsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Service API pour gérer les notations des pharmacies
 */
interface RatingApiService {

    /**
     * Récupérer toutes les notations d'une pharmacie
     */
    @GET("pharmacies/{id}/ratings")
    suspend fun getPharmacyRatings(
        @Path("id") pharmacyId: Int
    ): RatingsResponse

    /**
     * Soumettre une notation pour une pharmacie
     */
    @POST("pharmacies/{id}/ratings")
    suspend fun submitRating(
        @Path("id") pharmacyId: Int,
        @Body request: RatingRequest
    ): RatingSubmitResponse
}
