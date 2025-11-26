package com.maroua.pharmaciegarde.data.repository

import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.data.remote.PharmacyApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

@Singleton
class PharmacyRepository @Inject constructor(
    private val apiService: PharmacyApiService
) {
    suspend fun getAllPharmacies(search: String? = null, district: String? = null): Result<List<Pharmacy>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getAllPharmacies(search, district)
                if (response.success) {
                    Result.Success(response.data)
                } else {
                    Result.Error(response.message ?: "Erreur inconnue")
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: "Erreur de connexion")
            }
        }
    }

    suspend fun getOnDutyPharmacies(): Result<List<Pharmacy>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getOnDutyPharmacies()
                if (response.success) {
                    Result.Success(response.data)
                } else {
                    Result.Error(response.message ?: "Erreur inconnue")
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: "Erreur de connexion")
            }
        }
    }

    suspend fun getNearbyPharmacies(latitude: Double, longitude: Double, radius: Double = 10.0): Result<List<Pharmacy>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getNearbyPharmacies(latitude, longitude, radius)
                if (response.success) {
                    Result.Success(response.data)
                } else {
                    Result.Error(response.message ?: "Erreur inconnue")
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: "Erreur de connexion")
            }
        }
    }

    suspend fun getPharmacyById(id: Int): Result<Pharmacy> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getPharmacyById(id)
                if (response.success) {
                    Result.Success(response.data)
                } else {
                    Result.Error(response.message ?: "Erreur inconnue")
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: "Erreur de connexion")
            }
        }
    }
}
