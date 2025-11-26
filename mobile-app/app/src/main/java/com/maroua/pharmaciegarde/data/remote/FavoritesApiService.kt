package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.model.Pharmacy
import retrofit2.Response
import retrofit2.http.*

/**
 * API Service pour les favoris avec Laravel
 */
interface FavoritesApiService {

    @GET("favorites")
    suspend fun getFavorites(): Response<FavoritesResponse>

    @POST("favorites")
    suspend fun addFavorite(@Body request: AddFavoriteRequest): Response<BasicResponse>

    @DELETE("favorites/{pharmacyId}")
    suspend fun removeFavorite(@Path("pharmacyId") pharmacyId: Int): Response<BasicResponse>

    @GET("favorites/{pharmacyId}/check")
    suspend fun checkFavorite(@Path("pharmacyId") pharmacyId: Int): Response<CheckFavoriteResponse>
}

// Request Models
data class AddFavoriteRequest(
    val pharmacy_id: Int
)

// Response Models
data class FavoritesResponse(
    val success: Boolean,
    val data: FavoritesData?
)

data class FavoritesData(
    val favorite_ids: List<Int>,
    val pharmacies: List<Pharmacy>
)

data class BasicResponse(
    val success: Boolean,
    val message: String?
)

data class CheckFavoriteResponse(
    val success: Boolean,
    val data: CheckFavoriteData?
)

data class CheckFavoriteData(
    val is_favorite: Boolean
)
