package com.maroua.pharmaciegarde.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.maroua.pharmaciegarde.data.model.User
import com.maroua.pharmaciegarde.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    init {
        // Observe current user
        viewModelScope.launch {
            authRepository.getCurrentUser().collect { user ->
                _currentUser.value = user
            }
        }

        // Rafraîchir automatiquement l'utilisateur au démarrage
        refreshUser()
    }

    fun isUserSignedInFlow() = authRepository.isUserSignedInFlow()

    fun signInWithGoogle(account: GoogleSignInAccount) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = authRepository.signInWithGoogle(account)
            _authState.value = if (result.isSuccess) {
                AuthState.Success(result.getOrNull()!!)
            } else {
                AuthState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            try {
                authRepository.signOut()
                _authState.value = AuthState.SignedOut
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Sign out failed")
            }
        }
    }

    fun resetAuthState() {
        _authState.value = AuthState.Initial
    }

    fun setError(message: String) {
        _authState.value = AuthState.Error(message)
    }

    fun getGoogleSignInClient() = authRepository.getGoogleSignInClient()

    suspend fun isUserSignedIn() = authRepository.isUserSignedIn()

    /**
     * Rafraîchir les informations de l'utilisateur depuis le backend
     * Force un nouvel appel API pour obtenir les dernières données
     */
    fun refreshUser() {
        viewModelScope.launch {
            val result = authRepository.refreshUserFromBackend()
            result.onSuccess { user ->
                _currentUser.value = user
            }
        }
    }
}

sealed class AuthState {
    object Initial : AuthState()
    object Loading : AuthState()
    data class Success(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
    object SignedOut : AuthState()
}
