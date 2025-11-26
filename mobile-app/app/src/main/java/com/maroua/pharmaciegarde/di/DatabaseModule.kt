package com.maroua.pharmaciegarde.di

import android.content.Context
import androidx.room.Room
import com.maroua.pharmaciegarde.data.local.room.PharmacyDao
import com.maroua.pharmaciegarde.data.local.room.PharmacyDatabase
import com.maroua.pharmaciegarde.data.local.room.ScheduleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePharmacyDatabase(@ApplicationContext context: Context): PharmacyDatabase {
        return Room.databaseBuilder(
            context,
            PharmacyDatabase::class.java,
            "pharmacy_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePharmacyDao(database: PharmacyDatabase): PharmacyDao {
        return database.pharmacyDao()
    }

    @Provides
    @Singleton
    fun provideScheduleDao(database: PharmacyDatabase): ScheduleDao {
        return database.scheduleDao()
    }
}
