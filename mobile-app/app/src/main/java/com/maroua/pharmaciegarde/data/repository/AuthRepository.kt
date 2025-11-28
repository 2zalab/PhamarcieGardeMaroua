package com.maroua.pharmaciegarde.data.repository

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.maroua.pharmaciegarde.R
import com.maroua.pharmaciegarde.data.local.TokenManager
import com.maroua.pharmaciegarde.data.model.User
import com.maroua.pharmaciegarde.data.remote.AuthApiService
import com.maroua.pharmaciegarde.data.remote.GoogleAuthRequest
import com.maroua.pharmaciegarde.data.remote.toUser
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result


@Singleton
class AuthRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val authApiService: AuthApiService,
    private val tokenManager: TokenManager
) {

    fun getGoogleSignInClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context, gso)
    }

    /**
     * Authentification avec Google via Laravel
     */
    suspend fun signInWithGoogle(account: GoogleSignInAccount): Result<User> {
        return try {
            val idToken = account.idToken
                ?: return Result.failure(Exception("Google ID token is null"))

            // Envoyer le token à Laravel
            val response = authApiService.googleAuth(GoogleAuthRequest(idToken))

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null && body.success && body.data != null) {
                    // Sauvegarder le token JWT
                    tokenManager.saveToken(body.data.token)

                    // Convertir UserDto en User
                    val user = body.data.user.toUser()

                    Result.success(user)
                } else {
                    Result.failure(Exception(body?.error ?: "Authentication failed"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.failure(Exception("Server error: ${response.code()} - $errorBody"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Déconnexion
     */
    suspend fun signOut() {
        try {
            // Appeler l'API de déconnexion Laravel (si token existe)
            if (tokenManager.hasToken()) {
                authApiService.logout()
            }
        } catch (e: Exception) {
            // Ignorer les erreurs réseau lors de la déconnexion
            e.printStackTrace()
        } finally {
            // Toujours nettoyer localement
            tokenManager.clearToken()
            getGoogleSignInClient().signOut().await()
        }
    }

    /**
     * Récupérer l'utilisateur courant depuis Laravel
     */
    fun getCurrentUser(): Flow<User?> = tokenManager.getTokenFlow().map { token ->
        if (token != null) {
            try {
                val response = authApiService.getUserInfo()
                if (response.isSuccessful && response.body()?.success == true) {
                    response.body()?.data?.toUser()
                } else {
                    // Token invalide, nettoyer
                    tokenManager.clearToken()
                    null
                }
            } catch (e: Exception) {
                null
            }
        } else {
            null
        }
    }

    /**
     * Vérifier si l'utilisateur est connecté
     */
    suspend fun isUserSignedIn(): Boolean = tokenManager.hasToken()

    /**
     * Observer l'état de connexion de l'utilisateur
     */
    fun isUserSignedInFlow(): Flow<Boolean> = tokenManager.getTokenFlow().map { token ->
        token != null
    }

    /**
     * Rafraîchir les informations de l'utilisateur depuis le backend
     * Force un nouvel appel API pour obtenir les dernières données
     */
    suspend fun refreshUserFromBackend(): Result<User?> {
        return try {
            if (!tokenManager.hasToken()) {
                return Result.success(null)
            }

            val response = authApiService.getUserInfo()
            if (response.isSuccessful && response.body()?.success == true) {
                val user = response.body()?.data?.toUser()
                Result.success(user)
            } else {
                Result.failure(Exception("Échec du rafraîchissement de l'utilisateur"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Propriété pour exposer currentUser comme StateFlow dans AuthViewModel
     */
  //  val currentUser: Flow<User?> = getCurrentUser()
}
