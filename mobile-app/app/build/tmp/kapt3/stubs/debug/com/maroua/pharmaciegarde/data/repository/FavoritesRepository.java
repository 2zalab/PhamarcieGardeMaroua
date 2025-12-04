package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.local.FavoritesManager;
import com.maroua.pharmaciegarde.data.local.TokenManager;
import com.maroua.pharmaciegarde.data.remote.AddFavoriteRequest;
import com.maroua.pharmaciegarde.data.remote.FavoritesApiService;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u0018\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;", "", "favoritesApiService", "Lcom/maroua/pharmaciegarde/data/remote/FavoritesApiService;", "localFavoritesManager", "Lcom/maroua/pharmaciegarde/data/local/FavoritesManager;", "tokenManager", "Lcom/maroua/pharmaciegarde/data/local/TokenManager;", "(Lcom/maroua/pharmaciegarde/data/remote/FavoritesApiService;Lcom/maroua/pharmaciegarde/data/local/FavoritesManager;Lcom/maroua/pharmaciegarde/data/local/TokenManager;)V", "addFavorite", "", "pharmacyId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "isFavorite", "", "loadFavoritesFromServer", "Lcom/maroua/pharmaciegarde/data/repository/Result;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFavorite", "syncLocalToServer", "app_debug"})
public final class FavoritesRepository {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.remote.FavoritesApiService favoritesApiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.FavoritesManager localFavoritesManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.TokenManager tokenManager = null;
    
    @javax.inject.Inject
    public FavoritesRepository(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.FavoritesApiService favoritesApiService, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.FavoritesManager localFavoritesManager, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.TokenManager tokenManager) {
        super();
    }
    
    /**
     * Charger les favoris depuis le serveur et mettre à jour le cache local
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loadFavoritesFromServer(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.repository.Result<? extends java.util.List<java.lang.Integer>>> $completion) {
        return null;
    }
    
    /**
     * Récupérer les favoris (observe le Flow local pour des mises à jour en temps réel)
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.Set<java.lang.Integer>> getFavorites() {
        return null;
    }
    
    /**
     * Ajouter un favori
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFavorite(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Retirer un favori
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object removeFavorite(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Vérifier si une pharmacie est favorite
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object isFavorite(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Migrer les favoris locaux vers Laravel après connexion
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object syncLocalToServer(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}