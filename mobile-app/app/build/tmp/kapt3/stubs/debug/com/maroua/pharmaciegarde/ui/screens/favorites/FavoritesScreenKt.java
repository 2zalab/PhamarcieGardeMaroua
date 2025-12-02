package com.maroua.pharmaciegarde.ui.screens.favorites;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.maroua.pharmaciegarde.R;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a>\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a$\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0012\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\b\u0010\u0013\u001a\u00020\u0001H\u0007\u001a.\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u00a8\u0006\u0017"}, d2 = {"EmptyFavoritesState", "", "modifier", "Landroidx/compose/ui/Modifier;", "FavoritesScreen", "onPharmacyClick", "Lkotlin/Function1;", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onBackClick", "Lkotlin/Function0;", "viewModel", "Lcom/maroua/pharmaciegarde/ui/screens/favorites/FavoritesViewModel;", "authViewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "FavoritesSortSelector", "currentSort", "", "onSortChange", "LoadingState", "NoResultsState", "SearchBar", "query", "onQueryChange", "app_debug"})
public final class FavoritesScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable
    public static final void FavoritesScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.screens.favorites.FavoritesViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SearchBar(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onQueryChange, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void FavoritesSortSelector(@org.jetbrains.annotations.NotNull
    java.lang.String currentSort, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSortChange) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NoResultsState() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LoadingState(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void EmptyFavoritesState(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
}