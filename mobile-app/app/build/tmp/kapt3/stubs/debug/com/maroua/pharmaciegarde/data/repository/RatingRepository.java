package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.model.RatingRequest;
import com.maroua.pharmaciegarde.data.model.RatingSubmitResponse;
import com.maroua.pharmaciegarde.data.model.RatingsResponse;
import com.maroua.pharmaciegarde.data.remote.RatingApiService;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Repository pour gérer les notations des pharmacies
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ@\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/maroua/pharmaciegarde/data/repository/RatingRepository;", "", "ratingApiService", "Lcom/maroua/pharmaciegarde/data/remote/RatingApiService;", "(Lcom/maroua/pharmaciegarde/data/remote/RatingApiService;)V", "getPharmacyRatings", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/maroua/pharmaciegarde/data/model/RatingsResponse;", "pharmacyId", "", "limit", "offset", "submitRating", "Lcom/maroua/pharmaciegarde/data/model/RatingSubmitResponse;", "rating", "comment", "", "userName", "deviceId", "app_debug"})
public final class RatingRepository {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.remote.RatingApiService ratingApiService = null;
    
    @javax.inject.Inject
    public RatingRepository(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.RatingApiService ratingApiService) {
        super();
    }
    
    /**
     * Récupérer les notations d'une pharmacie avec pagination
     * @param pharmacyId ID de la pharmacie
     * @param limit Nombre d'avis à récupérer (par défaut 10)
     * @param offset Nombre d'avis à ignorer (pour la pagination)
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.RatingsResponse>> getPharmacyRatings(int pharmacyId, int limit, int offset) {
        return null;
    }
    
    /**
     * Soumettre une notation pour une pharmacie
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.maroua.pharmaciegarde.data.model.RatingSubmitResponse>> submitRating(int pharmacyId, int rating, @org.jetbrains.annotations.Nullable
    java.lang.String comment, @org.jetbrains.annotations.Nullable
    java.lang.String userName, @org.jetbrains.annotations.Nullable
    java.lang.String deviceId) {
        return null;
    }
}