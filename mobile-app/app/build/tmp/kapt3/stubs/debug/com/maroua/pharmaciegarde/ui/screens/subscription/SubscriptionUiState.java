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
 * États UI pour l'écran d'abonnement
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Jc\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\'H\u00d6\u0001J\t\u0010(\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014\u00a8\u0006)"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/subscription/SubscriptionUiState;", "", "currentUser", "Lcom/maroua/pharmaciegarde/data/model/User;", "isLoading", "", "error", "", "paymentResponse", "Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentResponse;", "paymentReference", "isPaymentSuccessful", "showPaymentDialog", "selectedPlan", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "(Lcom/maroua/pharmaciegarde/data/model/User;ZLjava/lang/String;Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentResponse;Ljava/lang/String;ZZLcom/maroua/pharmaciegarde/data/model/SubscriptionType;)V", "getCurrentUser", "()Lcom/maroua/pharmaciegarde/data/model/User;", "getError", "()Ljava/lang/String;", "()Z", "getPaymentReference", "getPaymentResponse", "()Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentResponse;", "getSelectedPlan", "()Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "getShowPaymentDialog", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SubscriptionUiState {
    @org.jetbrains.annotations.Nullable
    private final com.maroua.pharmaciegarde.data.model.User currentUser = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable
    private final com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse paymentResponse = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String paymentReference = null;
    private final boolean isPaymentSuccessful = false;
    private final boolean showPaymentDialog = false;
    @org.jetbrains.annotations.Nullable
    private final com.maroua.pharmaciegarde.data.model.SubscriptionType selectedPlan = null;
    
    public SubscriptionUiState(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User currentUser, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse paymentResponse, @org.jetbrains.annotations.Nullable
    java.lang.String paymentReference, boolean isPaymentSuccessful, boolean showPaymentDialog, @org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.SubscriptionType selectedPlan) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.User getCurrentUser() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse getPaymentResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPaymentReference() {
        return null;
    }
    
    public final boolean isPaymentSuccessful() {
        return false;
    }
    
    public final boolean getShowPaymentDialog() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.SubscriptionType getSelectedPlan() {
        return null;
    }
    
    public SubscriptionUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.User component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.SubscriptionType component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.ui.screens.subscription.SubscriptionUiState copy(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User currentUser, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse paymentResponse, @org.jetbrains.annotations.Nullable
    java.lang.String paymentReference, boolean isPaymentSuccessful, boolean showPaymentDialog, @org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.SubscriptionType selectedPlan) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}