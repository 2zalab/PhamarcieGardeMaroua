package com.maroua.pharmaciegarde.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pharmacy(
    val id: Int,
    val name: String,
    val address: String,
    val phone: String,
    @SerializedName("phone_secondary")
    val phoneSecondary: String?,
    val latitude: Double,
    val longitude: Double,
    @SerializedName("image_url")
    val imageUrl: String?,
    val description: String?,
    val city: String,
    val district: String?,
    @SerializedName("has_parking")
    val hasParking: Boolean,
    @SerializedName("has_wheelchair_access")
    val hasWheelchairAccess: Boolean,
    @SerializedName("is_24_hours")
    val is24Hours: Boolean,
    @SerializedName("is_on_duty_today")
    val isOnDutyToday: Boolean,
    @SerializedName("current_schedule")
    val currentSchedule: Schedule?,
    val distance: Double? = null
) : Parcelable

@Parcelize
data class Schedule(
    val id: Int,
    @SerializedName("pharmacy_id")
    val pharmacyId: Int,
    @SerializedName("start_date")
    val startDate: String,
    @SerializedName("end_date")
    val endDate: String,
    @SerializedName("start_time")
    val startTime: String?,
    @SerializedName("end_time")
    val endTime: String?,
    @SerializedName("is_on_duty")
    val isOnDuty: Boolean,
    val notes: String?
) : Parcelable

data class ApiResponse<T>(
    val success: Boolean,
    val data: T,
    val message: String? = null
)
