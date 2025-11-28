package com.maroua.pharmaciegarde.ui.screens.subscription;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.maroua.pharmaciegarde.data.model.SubscriptionPlan;
import com.maroua.pharmaciegarde.data.model.SubscriptionPlans;
import com.maroua.pharmaciegarde.data.model.SubscriptionType;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a.\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a4\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0013H\u0007\u001a&\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a*\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007\u001a\u0016\u0010 \u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u00a8\u0006!"}, d2 = {"CurrentSubscriptionCard", "", "currentType", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "expiryDate", "", "(Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;Ljava/lang/Long;)V", "FeatureItem", "feature", "", "PaymentDialog", "paymentResponse", "Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentResponse;", "onDismiss", "Lkotlin/Function0;", "onCheckStatus", "PhoneNumberDialog", "selectedPlan", "onConfirm", "Lkotlin/Function1;", "SubscriptionPlanCard", "plan", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionPlan;", "isCurrentPlan", "", "onSelectPlan", "SubscriptionScreen", "onNavigateBack", "authViewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "subscriptionViewModel", "Lcom/maroua/pharmaciegarde/ui/screens/subscription/SubscriptionViewModel;", "SuccessDialog", "app_debug"})
public final class SubscriptionScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SubscriptionScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel authViewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.screens.subscription.SubscriptionViewModel subscriptionViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CurrentSubscriptionCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.SubscriptionType currentType, @org.jetbrains.annotations.Nullable
    java.lang.Long expiryDate) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SubscriptionPlanCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.SubscriptionPlan plan, boolean isCurrentPlan, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSelectPlan) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void FeatureItem(@org.jetbrains.annotations.NotNull
    java.lang.String feature) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PaymentDialog(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse paymentResponse, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCheckStatus) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PhoneNumberDialog(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.SubscriptionType selectedPlan, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirm) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SuccessDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
}