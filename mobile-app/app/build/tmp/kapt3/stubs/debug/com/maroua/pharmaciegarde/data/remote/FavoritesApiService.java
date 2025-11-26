package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.model.Pharmacy;
import retrofit2.Response;
import retrofit2.http.*;

/**
 * API Service pour les favoris avec Laravel
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/FavoritesApiService;", "", "addFavorite", "Lretrofit2/Response;", "Lcom/maroua/pharmaciegarde/data/remote/BasicResponse;", "request", "Lcom/maroua/pharmaciegarde/data/remote/AddFavoriteRequest;", "(Lcom/maroua/pharmaciegarde/data/remote/AddFavoriteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkFavorite", "Lcom/maroua/pharmaciegarde/data/remote/CheckFavoriteResponse;", "pharmacyId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "Lcom/maroua/pharmaciegarde/data/remote/FavoritesResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFavorite", "app_debug"})
public abstract interface FavoritesApiService {
    
    @retrofit2.http.GET(value = "favorites")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFavorites(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.FavoritesResponse>> $completion);
    
    @retrofit2.http.POST(value = "favorites")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addFavorite(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.AddFavoriteRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.BasicResponse>> $completion);
    
    @retrofit2.http.DELETE(value = "favorites/{pharmacyId}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object removeFavorite(@retrofit2.http.Path(value = "pharmacyId")
    int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.BasicResponse>> $completion);
    
    @retrofit2.http.GET(value = "favorites/{pharmacyId}/check")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object checkFavorite(@retrofit2.http.Path(value = "pharmacyId")
    int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.CheckFavoriteResponse>> $completion);
}