package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.model.RatingRequest;
import com.maroua.pharmaciegarde.data.model.RatingSubmitResponse;
import com.maroua.pharmaciegarde.data.model.RatingsResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Service API pour gérer les notations des pharmacies
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/RatingApiService;", "", "getPharmacyRatings", "Lcom/maroua/pharmaciegarde/data/model/RatingsResponse;", "pharmacyId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitRating", "Lcom/maroua/pharmaciegarde/data/model/RatingSubmitResponse;", "request", "Lcom/maroua/pharmaciegarde/data/model/RatingRequest;", "(ILcom/maroua/pharmaciegarde/data/model/RatingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RatingApiService {
    
    /**
     * Récupérer toutes les notations d'une pharmacie
     */
    @retrofit2.http.GET(value = "pharmacies/{id}/ratings")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPharmacyRatings(@retrofit2.http.Path(value = "id")
    int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.model.RatingsResponse> $completion);
    
    /**
     * Soumettre une notation pour une pharmacie
     */
    @retrofit2.http.POST(value = "pharmacies/{id}/ratings")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object submitRating(@retrofit2.http.Path(value = "id")
    int pharmacyId, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.RatingRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.model.RatingSubmitResponse> $completion);
}