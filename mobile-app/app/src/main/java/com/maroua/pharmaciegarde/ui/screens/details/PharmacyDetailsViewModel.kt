package com.maroua.pharmaciegarde.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.model.User
import com.maroua.pharmaciegarde.data.repository.AuthRepository
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository
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
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

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
