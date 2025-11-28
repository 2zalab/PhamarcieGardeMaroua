package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.model.RatingRequest
import com.maroua.pharmaciegarde.data.model.RatingSubmitResponse
import com.maroua.pharmaciegarde.data.model.RatingsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Service API pour gérer les notations des pharmacies
 */
interface RatingApiService {

    /**
     * Récupérer les notations d'une pharmacie avec pagination
     * @param pharmacyId ID de la pharmacie
     * @param limit Nombre d'avis à récupérer (par défaut 10, max 50)
     * @param offset Nombre d'avis à ignorer (pour la pagination)
     */
    @GET("pharmacies/{id}/ratings")
    suspend fun getPharmacyRatings(
        @Path("id") pharmacyId: Int,
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
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
