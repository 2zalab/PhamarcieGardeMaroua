package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.data.remote.PharmacyApiService;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0086@\u00a2\u0006\u0002\u0010\fJ4\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;", "", "apiService", "Lcom/maroua/pharmaciegarde/data/remote/PharmacyApiService;", "(Lcom/maroua/pharmaciegarde/data/remote/PharmacyApiService;)V", "getAllPharmacies", "Lcom/maroua/pharmaciegarde/data/repository/Result;", "", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "search", "", "district", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNearbyPharmacies", "latitude", "", "longitude", "radius", "(DDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnDutyPharmacies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPharmacyById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PharmacyRepository {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.remote.PharmacyApiService apiService = null;
    
    @javax.inject.Inject
    public PharmacyRepository(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.PharmacyApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllPharmacies(@org.jetbrains.annotations.Nullable
    java.lang.String search, @org.jetbrains.annotations.Nullable
    java.lang.String district, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.repository.Result<? extends java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOnDutyPharmacies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.repository.Result<? extends java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getNearbyPharmacies(double latitude, double longitude, double radius, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.repository.Result<? extends java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPharmacyById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.repository.Result<com.maroua.pharmaciegarde.data.model.Pharmacy>> $completion) {
        return null;
    }
}