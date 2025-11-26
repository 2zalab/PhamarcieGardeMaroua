package com.maroua.pharmaciegarde.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.local.AppLanguage
import com.maroua.pharmaciegarde.data.local.AppLocaleManager
import com.maroua.pharmaciegarde.data.local.ThemeMode
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferencesManager: UserPreferencesManager,
    private val appLocaleManager: AppLocaleManager
) : ViewModel() {

    val uiState: StateFlow<SettingsUiState> = userPreferencesManager.userPreferencesFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = SettingsUiState()
        )

    fun updateThemeMode(themeMode: ThemeMode) {
        viewModelScope.launch {
            userPreferencesManager.updateThemeMode(themeMode)
        }
    }

    fun updateLanguage(language: AppLanguage) {
        viewModelScope.launch {
            appLocaleManager.applyLanguage(language)
        }
    }

    fun updateNotificationsEnabled(enabled: Boolean) {
        viewModelScope.launch {
            userPreferencesManager.updateNotificationsEnabled(enabled)
        }
    }

    fun updateOnDutyNotifications(enabled: Boolean) {
        viewModelScope.launch {
            userPreferencesManager.updateOnDutyNotifications(enabled)
        }
    }
}

typealias SettingsUiState = com.maroua.pharmaciegarde.data.local.UserPreferences
