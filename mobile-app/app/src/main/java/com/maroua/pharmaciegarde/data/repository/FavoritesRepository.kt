package com.maroua.pharmaciegarde.data.repository

import com.maroua.pharmaciegarde.data.local.FavoritesManager
import com.maroua.pharmaciegarde.data.local.TokenManager
import com.maroua.pharmaciegarde.data.remote.AddFavoriteRequest
import com.maroua.pharmaciegarde.data.remote.FavoritesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritesRepository @Inject constructor(
    private val favoritesApiService: FavoritesApiService,
    private val localFavoritesManager: FavoritesManager,
    private val tokenManager: TokenManager
) {

    /**
     * Récupérer les favoris (Laravel si authentifié, sinon local)
     */
    fun getFavorites(): Flow<Set<Int>> = flow {
        if (tokenManager.hasToken()) {
            // Utilisateur authentifié - récupérer depuis Laravel
            try {
                val response = favoritesApiService.getFavorites()
                if (response.isSuccessful && response.body()?.success == true) {
                    val favoriteIds = response.body()?.data?.favorite_ids?.toSet() ?: emptySet()
                    emit(favoriteIds)
                } else {
                    // En cas d'erreur, fallback sur local
                    emit(localFavoritesManager.favoritesFlow.first())
                }
            } catch (e: Exception) {
                // En cas d'erreur réseau, fallback sur local
                emit(localFavoritesManager.favoritesFlow.first())
            }
        } else {
            // Utilisateur non authentifié - utiliser local
            localFavoritesManager.favoritesFlow.collect { emit(it) }
        }
    }

    /**
     * Ajouter un favori
     */
    suspend fun addFavorite(pharmacyId: Int) {
        if (tokenManager.hasToken()) {
            // Utilisateur authentifié - ajouter via Laravel
            try {
                val response = favoritesApiService.addFavorite(
                    AddFavoriteRequest(pharmacyId)
                )
                if (response.isSuccessful) {
                    // Aussi mettre à jour local pour offline
                    localFavoritesManager.addFavorite(pharmacyId)
                }
            } catch (e: Exception) {
                // En cas d'erreur, au moins sauvegarder localement
                localFavoritesManager.addFavorite(pharmacyId)
                throw e
            }
        } else {
            // Utilisateur non authentifié - sauvegarder localement
            localFavoritesManager.addFavorite(pharmacyId)
        }
    }

    /**
     * Retirer un favori
     */
    suspend fun removeFavorite(pharmacyId: Int) {
        if (tokenManager.hasToken()) {
            // Utilisateur authentifié - retirer via Laravel
            try {
                val response = favoritesApiService.removeFavorite(pharmacyId)
                if (response.isSuccessful) {
                    // Aussi mettre à jour local
                    localFavoritesManager.removeFavorite(pharmacyId)
                }
            } catch (e: Exception) {
                // En cas d'erreur, au moins retirer localement
                localFavoritesManager.removeFavorite(pharmacyId)
                throw e
            }
        } else {
            // Utilisateur non authentifié - retirer localement
            localFavoritesManager.removeFavorite(pharmacyId)
        }
    }

    /**
     * Vérifier si une pharmacie est favorite
     */
    suspend fun isFavorite(pharmacyId: Int): Boolean {
        return if (tokenManager.hasToken()) {
            // Utilisateur authentifié - vérifier via Laravel
            try {
                val response = favoritesApiService.checkFavorite(pharmacyId)
                if (response.isSuccessful && response.body()?.success == true) {
                    response.body()?.data?.is_favorite ?: false
                } else {
                    // Fallback sur local
                    localFavoritesManager.favoritesFlow.first().contains(pharmacyId)
                }
            } catch (e: Exception) {
                // Fallback sur local
                localFavoritesManager.favoritesFlow.first().contains(pharmacyId)
            }
        } else {
            // Utilisateur non authentifié - vérifier localement
            localFavoritesManager.favoritesFlow.first().contains(pharmacyId)
        }
    }

    /**
     * Migrer les favoris locaux vers Laravel après connexion
     */
    suspend fun syncLocalToServer() {
        if (tokenManager.hasToken()) {
            try {
                val localFavorites = localFavoritesManager.favoritesFlow.first()
                for (pharmacyId in localFavorites) {
                    try {
                        favoritesApiService.addFavorite(AddFavoriteRequest(pharmacyId))
                    } catch (e: Exception) {
                        // Continuer même en cas d'erreur sur un favori
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
