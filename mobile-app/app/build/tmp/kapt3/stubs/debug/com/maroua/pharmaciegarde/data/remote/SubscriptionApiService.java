package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionRequest;
import com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse;
import com.maroua.pharmaciegarde.data.model.CamPayPaymentRequest;
import com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse;
import com.maroua.pharmaciegarde.data.model.PaymentStatusResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * API Service pour gérer les abonnements et paiements
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/SubscriptionApiService;", "", "activateSubscription", "Lretrofit2/Response;", "Lcom/maroua/pharmaciegarde/data/model/ActivateSubscriptionResponse;", "request", "Lcom/maroua/pharmaciegarde/data/model/ActivateSubscriptionRequest;", "(Lcom/maroua/pharmaciegarde/data/model/ActivateSubscriptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPaymentStatus", "Lcom/maroua/pharmaciegarde/data/model/PaymentStatusResponse;", "reference", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkSubscriptionStatus", "initiateCamPayPayment", "Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentResponse;", "Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentRequest;", "(Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SubscriptionApiService {
    
    /**
     * Initier un paiement via CamPay
     */
    @retrofit2.http.POST(value = "payments/campay/initiate")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object initiateCamPayPayment(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.CamPayPaymentRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse>> $completion);
    
    /**
     * Vérifier le statut d'un paiement
     */
    @retrofit2.http.GET(value = "payments/{reference}/status")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object checkPaymentStatus(@retrofit2.http.Path(value = "reference")
    @org.jetbrains.annotations.NotNull
    java.lang.String reference, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.model.PaymentStatusResponse>> $completion);
    
    /**
     * Activer l'abonnement après paiement réussi
     */
    @retrofit2.http.POST(value = "subscriptions/activate")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object activateSubscription(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.ActivateSubscriptionRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse>> $completion);
    
    /**
     * Vérifier le statut d'abonnement actuel de l'utilisateur
     */
    @retrofit2.http.GET(value = "subscriptions/status")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object checkSubscriptionStatus(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse>> $completion);
    
    /**
     * Annuler l'abonnement
     */
    @retrofit2.http.POST(value = "subscriptions/cancel")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object cancelSubscription(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.model.ActivateSubscriptionResponse>> $completion);
}