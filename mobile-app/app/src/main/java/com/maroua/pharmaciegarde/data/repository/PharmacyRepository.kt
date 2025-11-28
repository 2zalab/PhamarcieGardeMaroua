package com.maroua.pharmaciegarde.data.repository

import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.data.model.PharmacySchedule
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
                    // S'assurer que toutes les pharmacies retournées sont marquées comme de garde
                    val pharmaciesWithOnDutyFlag = response.data.map { pharmacy ->
                        pharmacy.copy(isOnDutyToday = true)
                    }
                    Result.Success(pharmaciesWithOnDutyFlag)
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

    // Schedule/Calendar methods
    suspend fun getScheduleByDay(date: String): Result<PharmacySchedule> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getScheduleByDay(date)
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

    suspend fun getScheduleByWeek(date: String): Result<List<PharmacySchedule>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getScheduleByWeek(date)
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

    suspend fun getScheduleByMonth(year: Int, month: Int): Result<List<PharmacySchedule>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getScheduleByMonth(year, month)
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
