package com.maroua.pharmaciegarde.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import android.provider.Settings
import com.maroua.pharmaciegarde.data.model.Rating
import com.maroua.pharmaciegarde.data.model.User
import com.maroua.pharmaciegarde.data.repository.AuthRepository
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository
import com.maroua.pharmaciegarde.data.repository.RatingRepository
import com.maroua.pharmaciegarde.util.SubscriptionChecker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PharmacyDetailsViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository,
    private val authRepository: AuthRepository,
    private val ratingRepository: RatingRepository
) : ViewModel() {

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _ratings = MutableStateFlow<List<Rating>>(emptyList())
    val ratings: StateFlow<List<Rating>> = _ratings.asStateFlow()

    private val _averageRating = MutableStateFlow(0.0)
    val averageRating: StateFlow<Double> = _averageRating.asStateFlow()

    private val _totalRatings = MutableStateFlow(0)
    val totalRatings: StateFlow<Int> = _totalRatings.asStateFlow()

    private val _isLoadingRatings = MutableStateFlow(false)
    val isLoadingRatings: StateFlow<Boolean> = _isLoadingRatings.asStateFlow()

    private val _isSubmittingRating = MutableStateFlow(false)
    val isSubmittingRating: StateFlow<Boolean> = _isSubmittingRating.asStateFlow()

    private val _ratingSuccess = MutableStateFlow(false)
    val ratingSuccess: StateFlow<Boolean> = _ratingSuccess.asStateFlow()

    init {
        // Observer l'utilisateur actuel
        viewModelScope.launch {
            authRepository.getCurrentUser().collect { user ->
                _currentUser.value = user
            }
        }
    }

    /*
    fun checkIfFavorite(pharmacyId: Int) {
        viewModelScope.launch {
            authRepository.getCurrentUser().collect { user ->
                val favoritesFlow = if (user != null) {
                    favoritesRepository.getUserFavorites(user.uid)
                } else {
                    favoritesRepository.getLocalFavorites()
                }

                favoritesFlow.collect { favoriteIds ->
                    _isFavorite.value = pharmacyId in favoriteIds
                }
            }
        }
    }

    */

    fun checkIfFavorite(pharmacyId: Int) {
        viewModelScope.launch {
            favoritesRepository.getFavorites().collect { favoriteIds ->
                _isFavorite.value = pharmacyId in favoriteIds
            }
        }
    }


    fun toggleFavorite(pharmacyId: Int) {
        viewModelScope.launch {
            val currentFavoriteState = _isFavorite.value

            // Si on essaie d'ajouter un favori, vérifier si l'utilisateur est premium
            if (!currentFavoriteState) {
                if (!SubscriptionChecker.canAddFavorites(_currentUser.value)) {
                    _error.value = SubscriptionChecker.getUpgradeMessage("Favoris")
                    return@launch
                }
            }

            // Mise à jour optimiste de l'état pour un feedback immédiat
            val newFavoriteState = !currentFavoriteState
            _isFavorite.value = newFavoriteState

            try {
                if (!newFavoriteState) {
                    // L'état vient de passer à false, donc on retire le favori
                    favoritesRepository.removeFavorite(pharmacyId)
                } else {
                    // L'état vient de passer à true, donc on ajoute le favori
                    favoritesRepository.addFavorite(pharmacyId)
                }
            } catch (e: Exception) {
                // En cas d'erreur, revenir à l'état précédent
                _isFavorite.value = !newFavoriteState
                _error.value = "Erreur lors de la modification du favori"
                e.printStackTrace()
            }
        }
    }

    /**
     * Effacer l'erreur
     */
    fun clearError() {
        _error.value = null
    }

    /**
     * Charger les notations d'une pharmacie
     */
    fun loadRatings(pharmacyId: Int) {
        viewModelScope.launch {
            _isLoadingRatings.value = true
            ratingRepository.getPharmacyRatings(pharmacyId).collect { result ->
                result.onSuccess { response ->
                    _ratings.value = response.ratings
                    _averageRating.value = response.averageRating
                    _totalRatings.value = response.totalRatings
                    _isLoadingRatings.value = false
                }.onFailure { exception ->
                    _error.value = exception.message ?: "Erreur lors du chargement des notations"
                    _isLoadingRatings.value = false
                }
            }
        }
    }

    /**
     * Soumettre une notation
     */
    fun submitRating(
        pharmacyId: Int,
        rating: Int,
        comment: String?,
        deviceId: String?
    ) {
        viewModelScope.launch {
            _isSubmittingRating.value = true
            _ratingSuccess.value = false

            val userName = _currentUser.value?.name ?: "Anonyme"

            ratingRepository.submitRating(
                pharmacyId = pharmacyId,
                rating = rating,
                comment = comment,
                userName = userName,
                deviceId = deviceId
            ).collect { result ->
                result.onSuccess { response ->
                    if (response.success) {
                        _ratingSuccess.value = true
                        // Recharger les notations pour obtenir les données mises à jour
                        loadRatings(pharmacyId)
                    } else {
                        _error.value = response.message
                    }
                    _isSubmittingRating.value = false
                }.onFailure { exception ->
                    _error.value = exception.message ?: "Erreur lors de l'envoi de la notation"
                    _isSubmittingRating.value = false
                }
            }
        }
    }

    /**
     * Réinitialiser le statut de succès de notation
     */
    fun resetRatingSuccess() {
        _ratingSuccess.value = false
    }

    /*
    fun toggleFavorite(pharmacyId: Int) {
        viewModelScope.launch {
            authRepository.getCurrentUser().collect { user ->
                if (_isFavorite.value) {
                    if (user != null) {
                        favoritesRepository.removeUserFavorite(user.uid, pharmacyId)
                    } else {
                        favoritesRepository.removeLocalFavorite(pharmacyId)
                    }
                } else {
                    if (user != null) {
                        favoritesRepository.addUserFavorite(user.uid, pharmacyId)
                    } else {
                        favoritesRepository.addLocalFavorite(pharmacyId)
                    }
                }
            }
        }
    }
    */
}
