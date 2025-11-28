package com.maroua.pharmaciegarde.ui.screens.subscription

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse
import com.maroua.pharmaciegarde.data.model.SubscriptionType
import com.maroua.pharmaciegarde.data.model.User
import com.maroua.pharmaciegarde.data.repository.AuthRepository
import com.maroua.pharmaciegarde.data.repository.SubscriptionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * États UI pour l'écran d'abonnement
 */
data class SubscriptionUiState(
    val currentUser: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val paymentResponse: CamPayPaymentResponse? = null,
    val paymentReference: String? = null,
    val isPaymentSuccessful: Boolean = false,
    val showPaymentDialog: Boolean = false,
    val showPhoneDialog: Boolean = false,
    val selectedPlan: SubscriptionType? = null
)

/**
 * ViewModel pour gérer les abonnements
 */
@HiltViewModel
class SubscriptionViewModel @Inject constructor(
    private val subscriptionRepository: SubscriptionRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SubscriptionUiState())
    val uiState: StateFlow<SubscriptionUiState> = _uiState.asStateFlow()

    private var pollingJob: Job? = null

    init {
        loadCurrentUser()
    }

    /**
     * Charger l'utilisateur actuel
     */
    private fun loadCurrentUser() {
        viewModelScope.launch {
            authRepository.getCurrentUser().collect { user ->
                _uiState.update { it.copy(currentUser = user) }
            }
        }
    }

    /**
     * Sélectionner un plan et afficher le dialogue du numéro de téléphone
     */
    fun selectPlan(subscriptionType: SubscriptionType) {
        if (subscriptionType == SubscriptionType.FREE) {
            // Pas besoin de paiement pour le plan gratuit
            return
        }
        _uiState.update { it.copy(selectedPlan = subscriptionType, showPhoneDialog = true) }
    }

    /**
     * Initier le paiement pour un abonnement avec numéro de téléphone
     */
    fun initiatePayment(phoneNumber: String) {
        val subscriptionType = _uiState.value.selectedPlan ?: return

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null, showPhoneDialog = false) }

            val amount = when (subscriptionType) {
                SubscriptionType.MONTHLY -> 500
                SubscriptionType.ANNUAL -> 5000
                else -> 0
            }

            val description = when (subscriptionType) {
                SubscriptionType.MONTHLY -> "Abonnement Mensuel - Pharmacie de Garde"
                SubscriptionType.ANNUAL -> "Abonnement Annuel - Pharmacie de Garde"
                else -> ""
            }

            // Générer une référence unique pour le paiement
            val externalReference = "SUB-${UUID.randomUUID()}"

            subscriptionRepository.initiateCamPayPayment(
                amount = amount,
                description = description,
                externalReference = externalReference,
                phoneNumber = phoneNumber
            ).collect { result ->
                result.onSuccess { response ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            paymentResponse = response,
                            paymentReference = response.reference,
                            showPaymentDialog = true
                        )
                    }
                    // Démarrer le polling automatique du statut du paiement
                    startPaymentStatusPolling()
                }.onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Erreur lors de l'initiation du paiement"
                        )
                    }
                }
            }
        }
    }

    /**
     * Fermer le dialogue du numéro de téléphone
     */
    fun dismissPhoneDialog() {
        _uiState.update { it.copy(showPhoneDialog = false, selectedPlan = null) }
    }

    /**
     * Démarrer le polling automatique du statut du paiement
     */
    private fun startPaymentStatusPolling() {
        // Annuler le polling précédent s'il existe
        pollingJob?.cancel()

        pollingJob = viewModelScope.launch {
            var attempts = 0
            val maxAttempts = 60 // 5 minutes (60 * 5 secondes)

            println("🔄 [POLLING] Démarrage du polling de paiement")

            while (attempts < maxAttempts) {
                delay(5000) // Vérifier toutes les 5 secondes

                val reference = _uiState.value.paymentReference
                if (reference == null) {
                    println("❌ [POLLING] Référence nulle, arrêt du polling")
                    break
                }

                println("🔍 [POLLING] Tentative ${attempts + 1}/$maxAttempts - Vérification référence: $reference")

                // Utiliser la version suspend directe au lieu de Flow
                val result = subscriptionRepository.checkPaymentStatusDirect(reference)

                result.onSuccess { status ->
                    println("✅ [POLLING] Statut reçu: ${status.status}")

                    when (status.status) {
                        "SUCCESSFUL" -> {
                            println("🎉 [POLLING] Paiement réussi! Arrêt du polling")
                            // Paiement réussi, arrêter le polling et recharger l'utilisateur
                            pollingJob?.cancel()
                            refreshUserAfterPayment()
                            return@launch
                        }
                        "FAILED" -> {
                            println("❌ [POLLING] Paiement échoué! Arrêt du polling")
                            // Paiement échoué, arrêter le polling
                            pollingJob?.cancel()
                            _uiState.update {
                                it.copy(
                                    isLoading = false,
                                    error = "Le paiement a échoué. Veuillez réessayer.",
                                    showPaymentDialog = false
                                )
                            }
                            return@launch
                        }
                        else -> {
                            println("⏳ [POLLING] Paiement en attente (${status.status}), continue...")
                            // Paiement en attente, continuer le polling
                            attempts++
                        }
                    }
                }.onFailure { exception ->
                    println("⚠️ [POLLING] Erreur lors de la vérification: ${exception.message}")
                    // Erreur de vérification, continuer le polling
                    attempts++
                }
            }

            // Timeout atteint
            if (attempts >= maxAttempts) {
                println("⏰ [POLLING] Timeout atteint après $maxAttempts tentatives")
                _uiState.update {
                    it.copy(
                        error = "Délai d'attente dépassé. Veuillez vérifier votre historique de paiements."
                    )
                }
            }
        }
    }

    /**
     * Rafraîchir l'utilisateur après paiement réussi
     */
    private fun refreshUserAfterPayment() {
        viewModelScope.launch {
            println("🔄 [REFRESH] Début du rafraîchissement utilisateur")
            _uiState.update { it.copy(isLoading = true) }

            // Attendre un peu pour que le backend ait le temps de traiter
            delay(2000) // Augmenté à 2 secondes pour plus de sécurité

            println("📡 [REFRESH] Appel API getUserInfo()...")

            // Forcer le rechargement de l'utilisateur depuis le backend
            val result = authRepository.refreshUserFromBackend()

            result.onSuccess { user ->
                println("✅ [REFRESH] Utilisateur rafraîchi avec succès")
                println("👤 [REFRESH] is_subscribed: ${user?.isSubscribed}")
                println("📋 [REFRESH] subscription_type: ${user?.subscriptionType}")
                println("📅 [REFRESH] subscription_expires_at: ${user?.subscriptionExpiryDate}")

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isPaymentSuccessful = true,
                        showPaymentDialog = false,
                        currentUser = user
                    )
                }
            }.onFailure { exception ->
                println("❌ [REFRESH] Échec du rafraîchissement: ${exception.message}")
                // Même en cas d'échec du refresh, marquer comme réussi
                // car le paiement a été validé
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isPaymentSuccessful = true,
                        showPaymentDialog = false
                    )
                }
            }
        }
    }

    /**
     * Vérifier le statut du paiement (appelée manuellement)
     */
    fun checkPaymentStatus() {
        val reference = _uiState.value.paymentReference ?: return

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            subscriptionRepository.checkPaymentStatus(reference).collect { result ->
                result.onSuccess { status ->
                    if (status.status == "SUCCESSFUL") {
                        // Paiement réussi, recharger l'utilisateur
                        refreshUserAfterPayment()
                    } else if (status.status == "FAILED") {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = "Le paiement a échoué. Veuillez réessayer.",
                                showPaymentDialog = false
                            )
                        }
                    } else {
                        // Paiement en attente
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = "Le paiement est en cours de traitement..."
                            )
                        }
                    }
                }.onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Erreur lors de la vérification du paiement"
                        )
                    }
                }
            }
        }
    }

    /**
     * Activer l'abonnement après paiement réussi
     */
    private fun activateSubscription(paymentReference: String) {
        val subscriptionType = _uiState.value.selectedPlan ?: return

        viewModelScope.launch {
            subscriptionRepository.activateSubscription(
                subscriptionType = subscriptionType,
                paymentReference = paymentReference
            ).collect { result ->
                result.onSuccess { response ->
                    if (response.success) {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                isPaymentSuccessful = true,
                                showPaymentDialog = false,
                                currentUser = response.user
                            )
                        }
                        // L'utilisateur sera automatiquement rafraîchi via AuthViewModel
                    } else {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = response.message
                            )
                        }
                    }
                }.onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Erreur lors de l'activation de l'abonnement"
                        )
                    }
                }
            }
        }
    }

    /**
     * Fermer le dialogue de paiement
     */
    fun dismissPaymentDialog() {
        pollingJob?.cancel()
        _uiState.update { it.copy(showPaymentDialog = false) }
    }

    /**
     * Arrêter le polling
     */
    fun stopPaymentPolling() {
        pollingJob?.cancel()
    }

    /**
     * Cleanup
     */
    override fun onCleared() {
        super.onCleared()
        pollingJob?.cancel()
    }

    /**
     * Effacer l'erreur
     */
    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }

    /**
     * Réinitialiser le statut de paiement
     */
    fun resetPaymentStatus() {
        _uiState.update {
            it.copy(
                isPaymentSuccessful = false,
                paymentResponse = null,
                paymentReference = null,
                selectedPlan = null
            )
        }
    }

    /**
     * Annuler l'abonnement
     */
    fun cancelSubscription() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            subscriptionRepository.cancelSubscription().collect { result ->
                result.onSuccess { response ->
                    if (response.success) {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                currentUser = response.user
                            )
                        }
                        // L'utilisateur sera automatiquement rafraîchi via AuthViewModel
                    } else {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = response.message
                            )
                        }
                    }
                }.onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Erreur lors de l'annulation de l'abonnement"
                        )
                    }
                }
            }
        }
    }
}
