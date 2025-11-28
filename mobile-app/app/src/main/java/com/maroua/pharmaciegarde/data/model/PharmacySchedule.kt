package com.maroua.pharmaciegarde.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Représente les pharmacies de garde pour une date donnée
 */
@Parcelize
data class PharmacySchedule(
    val date: String, // Format: "2025-11-28"
    @SerializedName("pharmacies")
    val pharmacies: List<Pharmacy>,
    @SerializedName("day_of_week")
    val dayOfWeek: String? = null // "Lundi", "Mardi", etc.
) : Parcelable

/**
 * Réponse API pour le calendrier
 */
data class CalendarResponse(
    val success: Boolean,
    val data: List<PharmacySchedule>,
    val message: String? = null
)

/**
 * Représente une semaine dans le calendrier
 */
data class WeekSchedule(
    val weekNumber: Int,
    val startDate: String,
    val endDate: String,
    val days: List<PharmacySchedule>
)

/**
 * Enum pour les modes d'affichage du calendrier
 */
enum class CalendarViewMode {
    DAY,     // Vue par jour
    WEEK,    // Vue par semaine
    MONTH    // Vue par mois
}
