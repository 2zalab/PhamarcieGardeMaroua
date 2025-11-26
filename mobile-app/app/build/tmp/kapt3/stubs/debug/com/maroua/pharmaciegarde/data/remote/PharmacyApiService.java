package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.model.ApiResponse;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ8\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/PharmacyApiService;", "", "getAllPharmacies", "Lcom/maroua/pharmaciegarde/data/model/ApiResponse;", "", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "search", "", "district", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNearbyPharmacies", "latitude", "", "longitude", "radius", "(DDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnDutyPharmacies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPharmacyById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PharmacyApiService {
    
    @retrofit2.http.GET(value = "pharmacies")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllPharmacies(@retrofit2.http.Query(value = "search")
    @org.jetbrains.annotations.Nullable
    java.lang.String search, @retrofit2.http.Query(value = "district")
    @org.jetbrains.annotations.Nullable
    java.lang.String district, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.model.ApiResponse<java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy>>> $completion);
    
    @retrofit2.http.GET(value = "pharmacies/on-duty")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOnDutyPharmacies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.model.ApiResponse<java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy>>> $completion);
    
    @retrofit2.http.GET(value = "pharmacies/nearby")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getNearbyPharmacies(@retrofit2.http.Query(value = "latitude")
    double latitude, @retrofit2.http.Query(value = "longitude")
    double longitude, @retrofit2.http.Query(value = "radius")
    double radius, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.model.ApiResponse<java.util.List<com.maroua.pharmaciegarde.data.model.Pharmacy>>> $completion);
    
    @retrofit2.http.GET(value = "pharmacies/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPharmacyById(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.model.ApiResponse<com.maroua.pharmaciegarde.data.model.Pharmacy>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}