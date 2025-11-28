package com.maroua.pharmaciegarde.ui.screens.details;

import androidx.lifecycle.ViewModel;
import android.provider.Settings;
import com.maroua.pharmaciegarde.data.model.Rating;
import com.maroua.pharmaciegarde.data.model.User;
import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository;
import com.maroua.pharmaciegarde.data.repository.RatingRepository;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020,J\u000e\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0019J\u0006\u00100\u001a\u00020,J*\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00192\b\u00103\u001a\u0004\u0018\u00010\u000f2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u000e\u00105\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0019R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001d\u00a8\u00066"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/details/PharmacyDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "favoritesRepository", "Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;", "authRepository", "Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "ratingRepository", "Lcom/maroua/pharmaciegarde/data/repository/RatingRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/FavoritesRepository;Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;Lcom/maroua/pharmaciegarde/data/repository/RatingRepository;)V", "_averageRating", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_currentUser", "Lcom/maroua/pharmaciegarde/data/model/User;", "_error", "", "_isFavorite", "", "_isLoadingRatings", "_isSubmittingRating", "_ratingSuccess", "_ratings", "", "Lcom/maroua/pharmaciegarde/data/model/Rating;", "_totalRatings", "", "averageRating", "Lkotlinx/coroutines/flow/StateFlow;", "getAverageRating", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUser", "getCurrentUser", "error", "getError", "isFavorite", "isLoadingRatings", "isSubmittingRating", "ratingSuccess", "getRatingSuccess", "ratings", "getRatings", "totalRatings", "getTotalRatings", "checkIfFavorite", "", "pharmacyId", "clearError", "loadRatings", "resetRatingSuccess", "submitRating", "rating", "comment", "deviceId", "toggleFavorite", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PharmacyDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.FavoritesRepository favoritesRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.RatingRepository ratingRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFavorite = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.data.model.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.data.model.User> currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.maroua.pharmaciegarde.data.model.Rating>> _ratings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.maroua.pharmaciegarde.data.model.Rating>> ratings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Double> _averageRating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Double> averageRating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _totalRatings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> totalRatings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoadingRatings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoadingRatings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSubmittingRating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSubmittingRating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _ratingSuccess = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> ratingSuccess = null;
    
    @javax.inject.Inject
    public PharmacyDetailsViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.FavoritesRepository favoritesRepository, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.RatingRepository ratingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.data.model.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.maroua.pharmaciegarde.data.model.Rating>> getRatings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Double> getAverageRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getTotalRatings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoadingRatings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSubmittingRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getRatingSuccess() {
        return null;
    }
    
    public final void checkIfFavorite(int pharmacyId) {
    }
    
    public final void toggleFavorite(int pharmacyId) {
    }
    
    /**
     * Effacer l'erreur
     */
    public final void clearError() {
    }
    
    /**
     * Charger les notations d'une pharmacie
     */
    public final void loadRatings(int pharmacyId) {
    }
    
    /**
     * Soumettre une notation
     */
    public final void submitRating(int pharmacyId, int rating, @org.jetbrains.annotations.Nullable
    java.lang.String comment, @org.jetbrains.annotations.Nullable
    java.lang.String deviceId) {
    }
    
    /**
     * Réinitialiser le statut de succès de notation
     */
    public final void resetRatingSuccess() {
    }
}