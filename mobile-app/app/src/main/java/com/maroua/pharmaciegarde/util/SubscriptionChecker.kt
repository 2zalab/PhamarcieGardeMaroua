package com.maroua.pharmaciegarde.util

import com.maroua.pharmaciegarde.data.model.SubscriptionType
import com.maroua.pharmaciegarde.data.model.User

/**
 * Utilitaire pour vérifier les permissions basées sur l'abonnement
 */
object SubscriptionChecker {

    /**
     * Vérifie si l'utilisateur a un abonnement premium actif
     */
    fun isPremium(user: User?): Boolean {
        if (user == null) return false

        return when {
            user.subscriptionType == SubscriptionType.FREE -> false
            user.subscriptionExpiryDate == null -> false
            user.subscriptionExpiryDate < System.currentTimeMillis() -> false
            else -> true
        }
    }

    /**
     * Vérifie si l'utilisateur peut ajouter des favoris
     */
    fun canAddFavorites(user: User?): Boolean {
        return isPremium(user)
    }

    /**
     * Vérifie si l'utilisateur peut voir les informations de contact
     */
    fun canViewContactInfo(user: User?): Boolean {
        return isPremium(user)
    }

    /**
     * Vérifie si l'utilisateur peut accéder à la carte
     */
    fun canAccessMap(user: User?): Boolean {
        return isPremium(user)
    }

    /**
     * Vérifie si l'utilisateur peut effectuer une recherche illimitée
     */
    fun canSearchUnlimited(user: User?): Boolean {
        return isPremium(user)
    }

    /**
     * Obtient le nombre maximum de recherches par jour pour un utilisateur gratuit
     */
    fun getMaxSearchesPerDay(): Int {
        return 5
    }

    /**
     * Obtient le message à afficher quand une fonctionnalité est verrouillée
     */
    fun getUpgradeMessage(feature: String): String {
        return "Cette fonctionnalité ($feature) nécessite un abonnement Premium. " +
                "Passez à Premium pour débloquer toutes les fonctionnalités !"
    }

    /**
     * Vérifie si l'abonnement a expiré
     */
    fun isSubscriptionExpired(user: User?): Boolean {
        if (user == null) return false
        if (user.subscriptionType == SubscriptionType.FREE) return false

        val expiryDate = user.subscriptionExpiryDate ?: return true
        return expiryDate < System.currentTimeMillis()
    }

    /**
     * Obtient le type d'abonnement sous forme de texte
     */
    fun getSubscriptionTypeText(subscriptionType: SubscriptionType): String {
        return when (subscriptionType) {
            SubscriptionType.FREE -> "Gratuit"
            SubscriptionType.MONTHLY -> "Premium Mensuel"
            SubscriptionType.ANNUAL -> "Premium Annuel"
        }
    }

    /**
     * Obtient le badge à afficher pour l'utilisateur
     */
    fun getBadgeText(user: User?): String? {
        return when {
            user == null -> null
            user.subscriptionType == SubscriptionType.FREE -> null
            isSubscriptionExpired(user) -> "Expiré"
            user.subscriptionType == SubscriptionType.ANNUAL -> "Premium ⭐"
            user.subscriptionType == SubscriptionType.MONTHLY -> "Premium"
            else -> null
        }
    }
}
