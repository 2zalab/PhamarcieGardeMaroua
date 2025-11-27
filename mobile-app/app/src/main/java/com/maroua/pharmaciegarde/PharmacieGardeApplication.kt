package com.maroua.pharmaciegarde

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PharmacieGardeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize AppCompat for locale management
        // This ensures AppCompatDelegate.setApplicationLocales() works correctly
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
