package com.maroua.pharmaciegarde.util;

import com.maroua.pharmaciegarde.data.model.SubscriptionType;
import com.maroua.pharmaciegarde.data.model.User;

/**
 * Utilitaire pour vérifier les permissions basées sur l'abonnement
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/maroua/pharmaciegarde/util/SubscriptionChecker;", "", "()V", "canAccessMap", "", "user", "Lcom/maroua/pharmaciegarde/data/model/User;", "canAddFavorites", "canSearchUnlimited", "canViewContactInfo", "getBadgeText", "", "getMaxSearchesPerDay", "", "getSubscriptionTypeText", "subscriptionType", "Lcom/maroua/pharmaciegarde/data/model/SubscriptionType;", "getUpgradeMessage", "feature", "isPremium", "isSubscriptionExpired", "app_debug"})
public final class SubscriptionChecker {
    @org.jetbrains.annotations.NotNull
    public static final com.maroua.pharmaciegarde.util.SubscriptionChecker INSTANCE = null;
    
    private SubscriptionChecker() {
        super();
    }
    
    /**
     * Vérifie si l'utilisateur a un abonnement premium actif
     */
    public final boolean isPremium(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return false;
    }
    
    /**
     * Vérifie si l'utilisateur peut ajouter des favoris
     */
    public final boolean canAddFavorites(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return false;
    }
    
    /**
     * Vérifie si l'utilisateur peut voir les informations de contact
     */
    public final boolean canViewContactInfo(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return false;
    }
    
    /**
     * Vérifie si l'utilisateur peut accéder à la carte
     */
    public final boolean canAccessMap(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return false;
    }
    
    /**
     * Vérifie si l'utilisateur peut effectuer une recherche illimitée
     */
    public final boolean canSearchUnlimited(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return false;
    }
    
    /**
     * Obtient le nombre maximum de recherches par jour pour un utilisateur gratuit
     */
    public final int getMaxSearchesPerDay() {
        return 0;
    }
    
    /**
     * Obtient le message à afficher quand une fonctionnalité est verrouillée
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUpgradeMessage(@org.jetbrains.annotations.NotNull
    java.lang.String feature) {
        return null;
    }
    
    /**
     * Vérifie si l'abonnement a expiré
     */
    public final boolean isSubscriptionExpired(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return false;
    }
    
    /**
     * Obtient le type d'abonnement sous forme de texte
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSubscriptionTypeText(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.SubscriptionType subscriptionType) {
        return null;
    }
    
    /**
     * Obtient le badge à afficher pour l'utilisateur
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBadgeText(@org.jetbrains.annotations.Nullable
    com.maroua.pharmaciegarde.data.model.User user) {
        return null;
    }
}