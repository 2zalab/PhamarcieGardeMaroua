package com.maroua.pharmaciegarde.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository;
import com.maroua.pharmaciegarde.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003Je\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u000bH\u00d6\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/viewmodel/PharmacyUiState;", "", "pharmacies", "", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onDutyPharmacies", "nearbyPharmacies", "selectedPharmacy", "isLoading", "", "error", "", "searchQuery", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/maroua/pharmaciegarde/data/model/Pharmacy;ZLjava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getNearbyPharmacies", "()Ljava/util/List;", "getOnDutyPharmacies", "getPharmacies", "getSearchQuery", "getSelectedPharmacy", "()Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class PharmacyUiState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> pharmacies = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> onDutyPharmacies = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> nearbyPharmacies = null;
    @org.jetbrains.annotations.Nullable
    private final com.maroua.pharmaciegarde.data.model.Pharmacy selectedPharmacy = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String searchQuery = null;
    
    public PharmacyUiState(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> pharmacies, @org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> onDutyPharmacies, @org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> nearbyPharmacies, @org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.Pharmacy selectedPharmacy, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String searchQuery) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> getPharmacies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> getOnDutyPharmacies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> getNearbyPharmacies() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.Pharmacy getSelectedPharmacy() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSearchQuery() {
        return null;
    }
    
    public PharmacyUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.maroua.pharmaciegarde.data.model.Pharmacy component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.ui.viewmodel.PharmacyUiState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> pharmacies, @org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> onDutyPharmacies, @org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy> nearbyPharmacies, @org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.Pharmacy selectedPharmacy, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String searchQuery) {
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