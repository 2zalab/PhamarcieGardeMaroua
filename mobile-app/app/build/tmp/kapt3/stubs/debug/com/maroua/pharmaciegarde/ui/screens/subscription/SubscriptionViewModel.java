package com.maroua.pharmaciegarde.ui.screens.subscription;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse;
import com.maroua.pharmaciegarde.data.model.SubscriptionType;
import com.maroua.pharmaciegarde.data.model.User;
import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.SubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.util.UUID;
import javax.inject.Inject;

/**
 * ViewModel pour gérer les abonnements
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0006\u0010\u001a\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/subscription/SubscriptionViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/maroua/pharmaciegarde/data/repository/SubscriptionRepository;", "authRepository", "Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/SubscriptionRepository;Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/maroua/pharmaciegarde/ui/screens/subscription/SubscriptionUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "activateSubscription", "", "paymentReference", "", "cancelSubscription", "checkPaymentStatus", "clearError", "dismissPaymentDialog", "initiatePayment", "subscriptionType", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "loadCurrentUser", "resetPaymentStatus", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SubscriptionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.ui.screens.subscription.SubscriptionUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.screens.subscription.SubscriptionUiState> uiState = null;
    
    @javax.inject.Inject
    public SubscriptionViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.SubscriptionRepository subscriptionRepository, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.screens.subscription.SubscriptionUiState> getUiState() {
        return null;
    }
    
    /**
     * Charger l'utilisateur actuel
     */
    private final void loadCurrentUser() {
    }
    
    /**
     * Initier le paiement pour un abonnement
     */
    public final void initiatePayment(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.SubscriptionType subscriptionType) {
    }
    
    /**
     * Vérifier le statut du paiement
     */
    public final void checkPaymentStatus() {
    }
    
    /**
     * Activer l'abonnement après paiement réussi
     */
    private final void activateSubscription(java.lang.String paymentReference) {
    }
    
    /**
     * Fermer le dialogue de paiement
     */
    public final void dismissPaymentDialog() {
    }
    
    /**
     * Effacer l'erreur
     */
    public final void clearError() {
    }
    
    /**
     * Réinitialiser le statut de paiement
     */
    public final void resetPaymentStatus() {
    }
    
    /**
     * Annuler l'abonnement
     */
    public final void cancelSubscription() {
    }
}