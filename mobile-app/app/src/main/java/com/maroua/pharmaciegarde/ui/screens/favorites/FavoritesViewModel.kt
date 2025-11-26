package com.maroua.pharmaciegarde.ui.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.data.repository.AuthRepository
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository
import com.maroua.pharmaciegarde.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FavoritesUiState(
    val favoritePharmacies: List<Pharmacy> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isAuthenticated: Boolean = false
)

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val pharmacyRepository: PharmacyRepository,
    private val favoritesRepository: FavoritesRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            // Observe auth state
            authRepository.getCurrentUser().collect { user ->
                val isAuthenticated = user != null
                _uiState.value = _uiState.value.copy(isAuthenticated = isAuthenticated)

                // Observe favorites
                favoritesRepository.getFavorites().collect { favoriteIds ->
                    if (favoriteIds.isEmpty()) {
                        _uiState.value = _uiState.value.copy(
                            favoritePharmacies = emptyList(),
                            isLoading = false
                        )
                    } else {
                        when (val result = pharmacyRepository.getAllPharmacies()) {
                            is Result.Success -> {
                                val favorites = result.data.filter { it.id in favoriteIds }
                                _uiState.value = _uiState.value.copy(
                                    favoritePharmacies = favorites,
                                    isLoading = false
                                )
                            }
                            is Result.Error -> {
                                _uiState.value = _uiState.value.copy(
                                    error = result.message,
                                    isLoading = false
                                )
                            }
                            is Result.Loading -> { /* nothing */ }
                        }
                    }
                }
            }
        }
    }

    suspend fun addFavorite(pharmacyId: Int) {
        favoritesRepository.addFavorite(pharmacyId)
    }

    suspend fun removeFavorite(pharmacyId: Int) {
        favoritesRepository.removeFavorite(pharmacyId)
    }
}

