package com.maroua.pharmaciegarde.ui.screens.favorites;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository;
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository;
import com.maroua.pharmaciegarde.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\u0011J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/favorites/FavoritesViewModel;", "Landroidx/lifecycle/ViewModel;", "pharmacyRepository", "Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;", "favoritesRepository", "Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;", "authRepository", "Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/maroua/pharmaciegarde/ui/screens/favorites/FavoritesUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addFavorite", "", "pharmacyId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFavorites", "refresh", "removeFavorite", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FavoritesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.PharmacyRepository pharmacyRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.FavoritesRepository favoritesRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.ui.screens.favorites.FavoritesUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.screens.favorites.FavoritesUiState> uiState = null;
    
    @javax.inject.Inject
    public FavoritesViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.PharmacyRepository pharmacyRepository, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.FavoritesRepository favoritesRepository, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.screens.favorites.FavoritesUiState> getUiState() {
        return null;
    }
    
    private final void loadFavorites() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFavorite(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object removeFavorite(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void refresh() {
    }
}