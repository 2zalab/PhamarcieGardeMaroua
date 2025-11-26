package com.maroua.pharmaciegarde.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pharmacies")
data class PharmacyEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val address: String,
    val phone: String,
    val phoneSecondary: String?,
    val latitude: Double,
    val longitude: Double,
    val imageUrl: String?,
    val description: String?,
    val city: String,
    val district: String?,
    val hasParking: Boolean,
    val hasWheelchairAccess: Boolean,
    val is24Hours: Boolean,
    val isActive: Boolean,
    val lastUpdated: Long = System.currentTimeMillis()
)

@Entity(tableName = "schedules")
data class ScheduleEntity(
    @PrimaryKey
    val id: Int,
    val pharmacyId: Int,
    val startDate: String,
    val endDate: String,
    val startTime: String?,
    val endTime: String?,
    val isOnDuty: Boolean,
    val notes: String?
)
