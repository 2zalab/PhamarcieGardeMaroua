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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000bJ\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0013H\u0002J\u0006\u0010$\u001a\u00020\u0013R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/subscription/SubscriptionViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/maroua/pharmaciegarde/data/repository/SubscriptionRepository;", "authRepository", "Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/SubscriptionRepository;Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/maroua/pharmaciegarde/ui/screens/subscription/SubscriptionUiState;", "currentPaymentReference", "", "pollingJob", "Lkotlinx/coroutines/Job;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "activateSubscription", "", "paymentReference", "cancelSubscription", "checkPaymentStatus", "clearError", "dismissPaymentDialog", "dismissPhoneDialog", "initiatePayment", "phoneNumber", "loadCurrentUser", "onCleared", "refreshUserAfterPayment", "resetPaymentStatus", "selectPlan", "subscriptionType", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "startPaymentStatusPolling", "stopPaymentPolling", "app_debug"})
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
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job pollingJob;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currentPaymentReference;
    
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
     * Sélectionner un plan et afficher le dialogue du numéro de téléphone
     */
    public final void selectPlan(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.SubscriptionType subscriptionType) {
    }
    
    /**
     * Initier le paiement pour un abonnement avec numéro de téléphone
     */
    public final void initiatePayment(@org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber) {
    }
    
    /**
     * Fermer le dialogue du numéro de téléphone
     */
    public final void dismissPhoneDialog() {
    }
    
    /**
     * Démarrer le polling automatique du statut du paiement
     */
    private final void startPaymentStatusPolling() {
    }
    
    /**
     * Rafraîchir l'utilisateur après paiement réussi
     */
    private final void refreshUserAfterPayment() {
    }
    
    /**
     * Vérifier le statut du paiement (appelée manuellement)
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
     * Arrêter le polling
     */
    public final void stopPaymentPolling() {
    }
    
    /**
     * Cleanup
     */
    @java.lang.Override
    protected void onCleared() {
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