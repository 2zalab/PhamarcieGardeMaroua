package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.local.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Intercepteur pour ajouter automatiquement le token Bearer aux requêtes
 */
class AuthInterceptor(private val tokenManager: TokenManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // Récupérer le token de manière synchrone
        val token = runBlocking { tokenManager.getToken() }

        // Si un token existe, l'ajouter aux headers
        val newRequest = if (token != null) {
            request.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .addHeader("Accept", "application/json")
                .build()
        } else {
            request.newBuilder()
                .addHeader("Accept", "application/json")
                .build()
        }

        return chain.proceed(newRequest)
    }
}
