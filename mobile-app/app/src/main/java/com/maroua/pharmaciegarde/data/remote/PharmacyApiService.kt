package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.model.ApiResponse
import com.maroua.pharmaciegarde.data.model.Pharmacy
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PharmacyApiService {

    @GET("pharmacies")
    suspend fun getAllPharmacies(
        @Query("search") search: String? = null,
        @Query("district") district: String? = null
    ): ApiResponse<List<Pharmacy>>

    @GET("pharmacies/on-duty")
    suspend fun getOnDutyPharmacies(): ApiResponse<List<Pharmacy>>

    @GET("pharmacies/nearby")
    suspend fun getNearbyPharmacies(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("radius") radius: Double = 10.0
    ): ApiResponse<List<Pharmacy>>

    @GET("pharmacies/{id}")
    suspend fun getPharmacyById(@Path("id") id: Int): ApiResponse<Pharmacy>
}
