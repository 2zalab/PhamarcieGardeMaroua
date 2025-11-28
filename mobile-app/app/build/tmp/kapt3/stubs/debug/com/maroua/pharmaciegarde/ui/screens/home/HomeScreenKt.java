package com.maroua.pharmaciegarde.ui.screens.home;

import androidx.compose.animation.*;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import com.maroua.pharmaciegarde.R;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007\u001ah\u0010\t\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\b\u0010\u0015\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0016\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001a$\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u00a8\u0006 "}, d2 = {"EmptyOnDutyState", "", "ErrorScreen", "message", "", "onRetry", "Lkotlin/Function0;", "HeroSection", "userName", "HomeScreen", "onPharmacyClick", "Lkotlin/Function1;", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onMapClick", "onSearchClick", "onNavigateToSubscription", "currentUserName", "viewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyViewModel;", "authViewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "LoadingScreen", "OnDutyPremiumLockedCard", "onUpgradeClick", "SectionHeader", "title", "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SortSelector", "currentSort", "onSortChange", "app_debug"})
public final class HomeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onMapClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSubscription, @org.jetbrains.annotations.Nullable
    java.lang.String currentUserName, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void HeroSection(@org.jetbrains.annotations.Nullable
    java.lang.String userName) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SortSelector(@org.jetbrains.annotations.NotNull
    java.lang.String currentSort, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSortChange) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SectionHeader(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String subtitle, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LoadingScreen() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ErrorScreen(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void EmptyOnDutyState() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OnDutyPremiumLockedCard(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpgradeClick) {
    }
}