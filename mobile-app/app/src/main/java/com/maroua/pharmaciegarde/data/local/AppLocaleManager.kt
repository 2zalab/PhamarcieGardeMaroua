package com.maroua.pharmaciegarde.data.local

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppLocaleManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferencesManager: UserPreferencesManager
) {

    suspend fun applyLanguage(language: AppLanguage) {
        val localeCode = when (language) {
            AppLanguage.FRENCH -> "fr"
            AppLanguage.ENGLISH -> "en"
        }

        // Save preference first
        userPreferencesManager.updateLanguage(language)

        // Update using AppCompat's locale API (works on all Android versions)
        val appLocale = LocaleListCompat.forLanguageTags(localeCode)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

    fun applyPersistedLocale() {
        // Cette méthode sera appelée au démarrage de l'app pour appliquer la locale sauvegardée
        // AppCompatDelegate.setApplicationLocales() la gérera automatiquement
    }

    fun getCurrentLanguage(): String {
        val currentLocale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.resources.configuration.locales[0]
        } else {
            @Suppress("DEPRECATION")
            context.resources.configuration.locale
        }
        return currentLocale.language
    }
}
