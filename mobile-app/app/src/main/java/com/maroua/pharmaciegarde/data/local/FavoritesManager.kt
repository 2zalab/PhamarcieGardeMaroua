package com.maroua.pharmaciegarde.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.favoritesDataStore: DataStore<Preferences> by preferencesDataStore(name = "favorites")

@Singleton
class FavoritesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object PreferencesKeys {
        val FAVORITE_IDS = stringSetPreferencesKey("favorite_pharmacy_ids")
    }

    val favoritesFlow: Flow<Set<Int>> = context.favoritesDataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.FAVORITE_IDS]?.map { it.toInt() }?.toSet() ?: emptySet()
        }

    suspend fun addFavorite(pharmacyId: Int) {
        context.favoritesDataStore.edit { preferences ->
            val currentFavorites = preferences[PreferencesKeys.FAVORITE_IDS]?.toMutableSet() ?: mutableSetOf()
            currentFavorites.add(pharmacyId.toString())
            preferences[PreferencesKeys.FAVORITE_IDS] = currentFavorites
        }
    }

    suspend fun removeFavorite(pharmacyId: Int) {
        context.favoritesDataStore.edit { preferences ->
            val currentFavorites = preferences[PreferencesKeys.FAVORITE_IDS]?.toMutableSet() ?: mutableSetOf()
            currentFavorites.remove(pharmacyId.toString())
            preferences[PreferencesKeys.FAVORITE_IDS] = currentFavorites
        }
    }

    suspend fun toggleFavorite(pharmacyId: Int) {
        context.favoritesDataStore.edit { preferences ->
            val currentFavorites = preferences[PreferencesKeys.FAVORITE_IDS]?.toMutableSet() ?: mutableSetOf()
            val idString = pharmacyId.toString()
            if (currentFavorites.contains(idString)) {
                currentFavorites.remove(idString)
            } else {
                currentFavorites.add(idString)
            }
            preferences[PreferencesKeys.FAVORITE_IDS] = currentFavorites
        }
    }

    suspend fun isFavorite(pharmacyId: Int): Boolean {
        var result = false
        context.favoritesDataStore.data.map { preferences ->
            result = preferences[PreferencesKeys.FAVORITE_IDS]?.contains(pharmacyId.toString()) ?: false
        }
        return result
    }

    /**
     * Remplacer tous les favoris par un nouvel ensemble (pour synchronisation serveur)
     */
    suspend fun setFavorites(pharmacyIds: Set<Int>) {
        context.favoritesDataStore.edit { preferences ->
            preferences[PreferencesKeys.FAVORITE_IDS] = pharmacyIds.map { it.toString() }.toSet()
        }
    }

    /**
     * Vider tous les favoris
     */
    suspend fun clearFavorites() {
        context.favoritesDataStore.edit { preferences ->
            preferences[PreferencesKeys.FAVORITE_IDS] = emptySet()
        }
    }
}
