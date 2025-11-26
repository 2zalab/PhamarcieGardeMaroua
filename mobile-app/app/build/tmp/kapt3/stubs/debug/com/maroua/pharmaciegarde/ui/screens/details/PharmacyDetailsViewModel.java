package com.maroua.pharmaciegarde.ui.screens.details;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/details/PharmacyDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "favoritesRepository", "Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;", "authRepository", "Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;)V", "_isFavorite", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isFavorite", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "checkIfFavorite", "", "pharmacyId", "", "toggleFavorite", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PharmacyDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.FavoritesRepository favoritesRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFavorite = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite = null;
    
    @javax.inject.Inject
    public PharmacyDetailsViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.FavoritesRepository favoritesRepository, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    public final void checkIfFavorite(int pharmacyId) {
    }
    
    public final void toggleFavorite(int pharmacyId) {
    }
}