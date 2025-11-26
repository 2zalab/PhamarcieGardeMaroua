package com.maroua.pharmaciegarde.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository
import com.maroua.pharmaciegarde.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PharmacyUiState(
    val pharmacies: List<Pharmacy> = emptyList(),
    val onDutyPharmacies: List<Pharmacy> = emptyList(),
    val nearbyPharmacies: List<Pharmacy> = emptyList(),
    val selectedPharmacy: Pharmacy? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = ""
)

@HiltViewModel
class PharmacyViewModel @Inject constructor(
    private val repository: PharmacyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PharmacyUiState())
    val uiState: StateFlow<PharmacyUiState> = _uiState.asStateFlow()

    init {
        loadAllPharmacies()
        loadOnDutyPharmacies()
    }

    fun loadAllPharmacies(search: String? = null, district: String? = null) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = repository.getAllPharmacies(search, district)) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        pharmacies = result.data,
                        isLoading = false
                    )
                }
                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
                is Result.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
            }
        }
    }

    fun loadOnDutyPharmacies() {
        viewModelScope.launch {
            when (val result = repository.getOnDutyPharmacies()) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        onDutyPharmacies = result.data
                    )
                }
                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        error = result.message
                    )
                }
                is Result.Loading -> {}
            }
        }
    }

    fun loadNearbyPharmacies(latitude: Double, longitude: Double, radius: Double = 10.0) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = repository.getNearbyPharmacies(latitude, longitude, radius)) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        nearbyPharmacies = result.data,
                        isLoading = false
                    )
                }
                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
                is Result.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
            }
        }
    }

    fun selectPharmacy(pharmacy: Pharmacy) {
        _uiState.value = _uiState.value.copy(selectedPharmacy = pharmacy)
    }

    fun updateSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        if (query.length >= 2) {
            loadAllPharmacies(search = query)
        } else if (query.isEmpty()) {
            loadAllPharmacies()
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    fun retry() {
        loadAllPharmacies()
        loadOnDutyPharmacies()
    }

    fun refreshPharmacies() {
        loadAllPharmacies()
        loadOnDutyPharmacies()
    }
}
