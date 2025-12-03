package com.maroua.pharmaciegarde

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.maroua.pharmaciegarde.data.local.ThemeMode
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager
import com.maroua.pharmaciegarde.ui.navigation.AppNavigation
import com.maroua.pharmaciegarde.ui.theme.PharmacieDeGardeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userPreferencesManager: UserPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userPreferences by userPreferencesManager.userPreferencesFlow.collectAsState(
                initial = com.maroua.pharmaciegarde.data.local.UserPreferences()
            )

            val darkTheme = when (userPreferences.themeMode) {
                ThemeMode.LIGHT -> false
                ThemeMode.DARK -> true
                ThemeMode.SYSTEM -> isSystemInDarkTheme()
            }

            PharmacieDeGardeTheme(darkTheme = darkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(userPreferencesManager = userPreferencesManager)
                }
            }
        }
    }
}
