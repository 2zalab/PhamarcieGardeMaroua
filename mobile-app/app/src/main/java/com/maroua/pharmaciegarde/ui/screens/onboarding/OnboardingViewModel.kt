package com.maroua.pharmaciegarde.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val userPreferencesManager: UserPreferencesManager
) : ViewModel() {

    fun setOnboardingCompleted() {
        viewModelScope.launch {
            userPreferencesManager.setOnboardingCompleted()
        }
    }
}
