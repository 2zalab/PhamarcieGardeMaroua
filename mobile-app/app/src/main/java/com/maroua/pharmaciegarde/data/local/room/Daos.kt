package com.maroua.pharmaciegarde.data.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PharmacyDao {
    @Query("SELECT * FROM pharmacies WHERE isActive = 1")
    fun getAllPharmacies(): Flow<List<PharmacyEntity>>

    @Query("SELECT * FROM pharmacies WHERE id = :pharmacyId")
    suspend fun getPharmacyById(pharmacyId: Int): PharmacyEntity?

    @Query("SELECT * FROM pharmacies WHERE name LIKE '%' || :query || '%' OR address LIKE '%' || :query || '%' OR district LIKE '%' || :query || '%'")
    fun searchPharmacies(query: String): Flow<List<PharmacyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPharmacies(pharmacies: List<PharmacyEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPharmacy(pharmacy: PharmacyEntity)

    @Delete
    suspend fun deletePharmacy(pharmacy: PharmacyEntity)

    @Query("DELETE FROM pharmacies")
    suspend fun deleteAllPharmacies()

    @Query("SELECT * FROM pharmacies WHERE id IN (:ids)")
    fun getFavoritePharmacies(ids: List<Int>): Flow<List<PharmacyEntity>>
}

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM schedules WHERE pharmacyId = :pharmacyId")
    suspend fun getSchedulesForPharmacy(pharmacyId: Int): List<ScheduleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedules(schedules: List<ScheduleEntity>)

    @Query("DELETE FROM schedules WHERE pharmacyId = :pharmacyId")
    suspend fun deleteSchedulesForPharmacy(pharmacyId: Int)
}
