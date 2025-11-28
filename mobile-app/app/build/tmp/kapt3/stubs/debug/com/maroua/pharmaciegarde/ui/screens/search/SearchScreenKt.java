package com.maroua.pharmaciegarde.ui.screens.search;

import androidx.compose.animation.*;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import com.maroua.pharmaciegarde.R;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a<\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a>\u0010\f\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a$\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a8\u0006\u0017"}, d2 = {"LoadingState", "", "NoResultsState", "query", "", "SearchBar", "onQueryChange", "Lkotlin/Function1;", "onSearch", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "SearchScreen", "onPharmacyClick", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onBackClick", "viewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyViewModel;", "authViewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "SearchSortSelector", "currentSort", "onSortChange", "app_debug"})
public final class SearchScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.ui.ExperimentalComposeUiApi.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable
    public static final void SearchScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SearchBar(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onQueryChange, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearch, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SearchSortSelector(@org.jetbrains.annotations.NotNull
    java.lang.String currentSort, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSortChange) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LoadingState() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NoResultsState(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
}