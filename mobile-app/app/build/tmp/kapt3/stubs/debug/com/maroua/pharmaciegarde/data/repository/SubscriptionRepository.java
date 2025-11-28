package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionRequest;
import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse;
import com.maroua.pharmaciegarde.data.model.CamPayPaymentRequest;
import com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse;
import com.maroua.pharmaciegarde.data.model.PaymentStatusResponse;
import com.maroua.pharmaciegarde.data.model.SubscriptionType;
import com.maroua.pharmaciegarde.data.remote.SubscriptionApiService;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Repository pour gérer les abonnements et paiements
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\u0006\u0010\u0010\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J2\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/maroua/pharmaciegarde/data/repository/SubscriptionRepository;", "", "subscriptionApi", "Lcom/maroua/pharmaciegarde/data/remote/SubscriptionApiService;", "(Lcom/maroua/pharmaciegarde/data/remote/SubscriptionApiService;)V", "activateSubscription", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/maroua/pharmaciegarde/data/model/ActivateSubscriptionResponse;", "subscriptionType", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "paymentReference", "", "cancelSubscription", "checkPaymentStatus", "Lcom/maroua/pharmaciegarde/data/model/PaymentStatusResponse;", "reference", "checkSubscriptionStatus", "initiateCamPayPayment", "Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentResponse;", "amount", "", "description", "externalReference", "phoneNumber", "app_debug"})
public final class SubscriptionRepository {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.remote.SubscriptionApiService subscriptionApi = null;
    
    @javax.inject.Inject
    public SubscriptionRepository(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.SubscriptionApiService subscriptionApi) {
        super();
    }
    
    /**
     * Initier un paiement CamPay
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse>> initiateCamPayPayment(int amount, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String externalReference, @org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber) {
        return null;
    }
    
    /**
     * Vérifier le statut d'un paiement
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.PaymentStatusResponse>> checkPaymentStatus(@org.jetbrains.annotations.NotNull
    java.lang.String reference) {
        return null;
    }
    
    /**
     * Activer l'abonnement après paiement réussi
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse>> activateSubscription(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.SubscriptionType subscriptionType, @org.jetbrains.annotations.NotNull
    java.lang.String paymentReference) {
        return null;
    }
    
    /**
     * Vérifier le statut d'abonnement actuel
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse>> checkSubscriptionStatus() {
        return null;
    }
    
    /**
     * Annuler l'abonnement
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse>> cancelSubscription() {
        return null;
    }
}