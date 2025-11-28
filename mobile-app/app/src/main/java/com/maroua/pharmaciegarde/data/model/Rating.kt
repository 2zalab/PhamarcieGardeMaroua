package com.maroua.pharmaciegarde.data.model

import com.google.gson.annotations.SerializedName

/**
 * Modèle pour une notation de pharmacie
 */
data class Rating(
    @SerializedName("id")
    val id: Int,
    @SerializedName("pharmacy_id")
    val pharmacyId: Int,
    @SerializedName("rating")
    val rating: Int, // 1-5 étoiles
    @SerializedName("comment")
    val comment: String?,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("user_email")
    val userEmail: String?,
    @SerializedName("device_id")
    val deviceId: String?,
    @SerializedName("created_at")
    val createdAt: String
)

/**
 * Requête pour soumettre une notation
 */
data class RatingRequest(
    @SerializedName("rating")
    val rating: Int, // 1-5 étoiles
    @SerializedName("comment")
    val comment: String? = null,
    @SerializedName("user_name")
    val userName: String? = null,
    @SerializedName("device_id")
    val deviceId: String? = null
)

/**
 * Réponse de la liste des notations
 */
data class RatingsResponse(
    @SerializedName("ratings")
    val ratings: List<Rating>,
    @SerializedName("average_rating")
    val averageRating: Double,
    @SerializedName("total_ratings")
    val totalRatings: Int
)

/**
 * Réponse après soumission d'une notation
 */
data class RatingSubmitResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("rating")
    val rating: Rating?
)
