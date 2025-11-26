package com.maroua.pharmaciegarde.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository;
import com.maroua.pharmaciegarde.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "loadAllPharmacies", "search", "", "district", "loadNearbyPharmacies", "latitude", "", "longitude", "radius", "loadOnDutyPharmacies", "refreshPharmacies", "retry", "selectPharmacy", "pharmacy", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "updateSearchQuery", "query", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PharmacyViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.PharmacyRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.ui.viewmodel.PharmacyUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.viewmodel.PharmacyUiState> uiState = null;
    
    @javax.inject.Inject
    public PharmacyViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.PharmacyRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.viewmodel.PharmacyUiState> getUiState() {
        return null;
    }
    
    public final void loadAllPharmacies(@org.jetbrains.annotations.Nullable
    java.lang.String search, @org.jetbrains.annotations.Nullable
    java.lang.String district) {
    }
    
    public final void loadOnDutyPharmacies() {
    }
    
    public final void loadNearbyPharmacies(double latitude, double longitude, double radius) {
    }
    
    public final void selectPharmacy(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Pharmacy pharmacy) {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void clearError() {
    }
    
    public final void retry() {
    }
    
    public final void refreshPharmacies() {
    }
}