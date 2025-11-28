package com.maroua.pharmaciegarde.ui.screens.map;

import android.Manifest;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.google.accompanist.permissions.ExperimentalPermissionsApi;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.compose.*;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aN\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0016\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0016\u0010\u000e\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"MapScreen", "", "onPharmacyClick", "Lkotlin/Function1;", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onBackClick", "Lkotlin/Function0;", "onUpgradeClick", "viewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyViewModel;", "authViewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "PermissionRequestCard", "onRequestPermission", "PremiumLockedMapScreen", "app_debug"})
public final class MapScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    @androidx.compose.runtime.Composable
    public static final void MapScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpgradeClick, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PremiumLockedMapScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpgradeClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PermissionRequestCard(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRequestPermission) {
    }
}