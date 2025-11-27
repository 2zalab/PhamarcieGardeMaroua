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

    suspend fun applyLanguage(language: AppLanguage, activity: Activity? = null) {
        val localeCode = when (language) {
            AppLanguage.FRENCH -> "fr"
            AppLanguage.ENGLISH -> "en"
        }

        // Save preference first
        userPreferencesManager.updateLanguage(language)

        // Update using AppCompat's locale API (works on all Android versions)
        val appLocale = LocaleListCompat.forLanguageTags(localeCode)
        AppCompatDelegate.setApplicationLocales(appLocale)

        // Restart activity to apply the language change immediately
        activity?.let {
            val intent = it.intent
            it.finish()
            it.startActivity(intent)
        }
    }

    fun updateConfiguration(context: Context): Context {
        // Cette méthode applique la locale sauvegardée au contexte
        val locale = when (getCurrentStoredLanguage()) {
            AppLanguage.FRENCH -> Locale("fr")
            AppLanguage.ENGLISH -> Locale("en")
        }

        Locale.setDefault(locale)
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }

    private fun getCurrentStoredLanguage(): AppLanguage {
        // Cette méthode sera appelée de manière synchrone, donc on ne peut pas utiliser Flow
        // On doit lire directement depuis les SharedPreferences ou utiliser une valeur par défaut
        return AppLanguage.FRENCH // Par défaut, on utilise le français
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
