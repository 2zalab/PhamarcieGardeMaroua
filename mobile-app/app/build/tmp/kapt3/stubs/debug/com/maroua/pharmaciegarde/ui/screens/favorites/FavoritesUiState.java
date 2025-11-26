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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J9\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/favorites/FavoritesUiState;", "", "favoritePharmacies", "", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "isLoading", "", "error", "", "isAuthenticated", "(Ljava/util/List;ZLjava/lang/String;Z)V", "getError", "()Ljava/lang/String;", "getFavoritePharmacies", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class FavoritesUiState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> favoritePharmacies = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    private final boolean isAuthenticated = false;
    
    public FavoritesUiState(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> favoritePharmacies, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, boolean isAuthenticated) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> getFavoritePharmacies() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean isAuthenticated() {
        return false;
    }
    
    public FavoritesUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.ui.screens.favorites.FavoritesUiState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> favoritePharmacies, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, boolean isAuthenticated) {
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