package com.maroua.pharmaciegarde.data.remote

import com.maroua.pharmaciegarde.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * API Service pour l'authentification avec Laravel
 */
interface AuthApiService {

    @POST("auth/google")
    suspend fun googleAuth(@Body request: GoogleAuthRequest): Response<GoogleAuthResponse>

    @GET("auth/me")
    suspend fun getUserInfo(): Response<UserInfoResponse>

    @POST("auth/logout")
    suspend fun logout(): Response<LogoutResponse>
}

// Request Models
data class GoogleAuthRequest(
    val id_token: String
)

// Response Models
data class GoogleAuthResponse(
    val success: Boolean,
    val message: String?,
    val data: AuthData?,
    val error: String?
)

data class AuthData(
    val user: UserDto,
    val token: String
)

data class UserDto(
    val id: Int,
    val name: String,
    val email: String,
    val avatar: String?,
    val is_subscribed: Boolean,
    val subscription_type: String,
    val subscription_expires_at: String?
)

data class UserInfoResponse(
    val success: Boolean,
    val data: UserDto?
)

data class LogoutResponse(
    val success: Boolean,
    val message: String?
)

// Extension function to convert UserDto to User
fun UserDto.toUser(): User {
    return User(
        uid = id.toString(),
        email = email,
        displayName = name,
        photoUrl = avatar,
        isSubscribed = is_subscribed,
        subscriptionType = when (subscription_type) {
            "monthly" -> com.maroua.pharmaciegarde.data.model.SubscriptionType.MONTHLY
            "annual" -> com.maroua.pharmaciegarde.data.model.SubscriptionType.ANNUAL
            else -> com.maroua.pharmaciegarde.data.model.SubscriptionType.FREE
        },
        subscriptionExpiryDate = subscription_expires_at?.let {
            // Convert to timestamp if needed
            System.currentTimeMillis()
        }
    )
}
