package com.maroua.pharmaciegarde.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.tokenDataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_token")

@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object PreferencesKeys {
        val AUTH_TOKEN = stringPreferencesKey("auth_token")
    }

    /**
     * Sauvegarder le token
     */
    suspend fun saveToken(token: String) {
        context.tokenDataStore.edit { preferences ->
            preferences[PreferencesKeys.AUTH_TOKEN] = token
        }
    }

    /**
     * Récupérer le token
     */
    suspend fun getToken(): String? {
        return context.tokenDataStore.data.map { preferences ->
            preferences[PreferencesKeys.AUTH_TOKEN]
        }.first()
    }

    /**
     * Observer le token
     */
    fun getTokenFlow(): Flow<String?> = context.tokenDataStore.data.map { preferences ->
        preferences[PreferencesKeys.AUTH_TOKEN]
    }

    /**
     * Supprimer le token (logout)
     */
    suspend fun clearToken() {
        context.tokenDataStore.edit { preferences ->
            preferences.remove(PreferencesKeys.AUTH_TOKEN)
        }
    }

    /**
     * Vérifier si un token existe
     */
    suspend fun hasToken(): Boolean {
        return getToken() != null
    }
}
