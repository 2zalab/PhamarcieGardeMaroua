package com.maroua.pharmaciegarde.ui.screens.details;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import com.maroua.pharmaciegarde.R;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;
import android.provider.Settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0007\u001aB\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007\u001a(\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0007\u001aR\u0010$\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u000f28\u0010&\u001a4\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\'H\u0007\u001a0\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00172\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020#\u0018\u0001002\u0006\u00101\u001a\u00020\u000fH\u0007\u00a8\u00062"}, d2 = {"ContactCard", "", "pharmacy", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onCallClick", "Lkotlin/Function0;", "onDirectionsClick", "DescriptionCard", "description", "", "FeatureItem", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "text", "isAvailable", "", "FeaturesCard", "HeaderCard", "InfoRow", "label", "value", "PharmacyDetailsScreen", "pharmacyId", "", "onBackClick", "onNavigateToSubscription", "viewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyViewModel;", "detailsViewModel", "Lcom/maroua/pharmaciegarde/ui/screens/details/PharmacyDetailsViewModel;", "PremiumLockedCard", "featureName", "onUpgradeClick", "RatingItem", "rating", "Lcom/maroua/pharmaciegarde/data/model/Rating;", "RatingSubmitCard", "isSubmitting", "onSubmit", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "RatingsDisplayCard", "averageRating", "", "totalRatings", "ratings", "", "isLoading", "app_debug"})
public final class PharmacyDetailsScreenKt {
    
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void PharmacyDetailsScreen(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSubscription, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.screens.details.PharmacyDetailsViewModel detailsViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void HeaderCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Pharmacy pharmacy) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ContactCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Pharmacy pharmacy, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCallClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDirectionsClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void FeaturesCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Pharmacy pharmacy) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DescriptionCard(@org.jetbrains.annotations.NotNull
    java.lang.String description) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void InfoRow(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void FeatureItem(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull
    java.lang.String text, boolean isAvailable) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PremiumLockedCard(@org.jetbrains.annotations.NotNull
    java.lang.String featureName, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpgradeClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RatingSubmitCard(int pharmacyId, boolean isSubmitting, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onSubmit) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RatingsDisplayCard(double averageRating, int totalRatings, @org.jetbrains.annotations.Nullable
    java.util.List<com.maroua.pharmaciegarde.data.model.Rating> ratings, boolean isLoading) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RatingItem(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Rating rating) {
    }
}