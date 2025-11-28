package com.maroua.pharmaciegarde.data.model

import com.google.gson.annotations.SerializedName

/**
 * Plan d'abonnement
 */
data class SubscriptionPlan(
    val type: SubscriptionType,
    val name: String,
    val price: Int, // Prix en FCFA
    val duration: String, // "month" ou "year"
    val features: List<String>
)

/**
 * Requête de paiement CamPay
 */
data class CamPayPaymentRequest(
    @SerializedName("amount")
    val amount: Int, // Montant en FCFA

    @SerializedName("currency")
    val currency: String = "XAF", // Franc CFA

    @SerializedName("description")
    val description: String,

    @SerializedName("external_reference")
    val externalReference: String, // ID de transaction unique

    @SerializedName("phone_number")
    val phoneNumber: String, // Numéro de téléphone (ex: 237670000000)

    @SerializedName("redirect_url")
    val redirectUrl: String? = null,

    @SerializedName("webhook_url")
    val webhookUrl: String? = null
)

/**
 * Réponse de paiement CamPay (données)
 */
data class CamPayPaymentData(
    @SerializedName("payment_id")
    val paymentId: Int?,

    @SerializedName("reference")
    val reference: String,

    @SerializedName("external_reference")
    val externalReference: String,

    @SerializedName("ussd_code")
    val ussdCode: String?,

    @SerializedName("operator")
    val operator: String?,

    @SerializedName("amount")
    val amount: Int,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("message")
    val message: String?
)

/**
 * Réponse complète de paiement CamPay
 */
data class CamPayPaymentResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: CamPayPaymentData
) {
    // Propriétés de commodité pour compatibilité
    val reference: String get() = data.reference
    val ussdCode: String? get() = data.ussdCode
    val operator: String? get() = data.operator
    val status: String get() = data.status
    val paymentUrl: String? get() = null // Pas utilisé pour CamPay
}

/**
 * Vérification du statut de paiement
 */
data class PaymentStatusResponse(
    @SerializedName("status")
    val status: String, // "SUCCESSFUL", "PENDING", "FAILED"

    @SerializedName("reference")
    val reference: String,

    @SerializedName("amount")
    val amount: Int,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("external_reference")
    val externalReference: String
)

/**
 * Requête pour activer l'abonnement après paiement
 */
data class ActivateSubscriptionRequest(
    @SerializedName("subscription_type")
    val subscriptionType: String, // "MONTHLY" ou "ANNUAL"

    @SerializedName("payment_reference")
    val paymentReference: String,

    @SerializedName("payment_provider")
    val paymentProvider: String = "campay"
)

/**
 * Réponse d'activation d'abonnement
 */
data class ActivateSubscriptionResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("user")
    val user: User
)

/**
 * Plans d'abonnement disponibles
 */
object SubscriptionPlans {
    val FREE = SubscriptionPlan(
        type = SubscriptionType.FREE,
        name = "Gratuit",
        price = 0,
        duration = "",
        features = listOf(
            "Consulter les pharmacies de garde",
            "Recherche limitée (5 recherches/jour)",
            "Vue liste uniquement"
        )
    )

    val MONTHLY = SubscriptionPlan(
        type = SubscriptionType.MONTHLY,
        name = "Mensuel",
        price = 500,
        duration = "mois",
        features = listOf(
            "Toutes les fonctionnalités gratuites",
            "Recherche illimitée",
            "Ajout aux favoris illimité",
            "Carte interactive des pharmacies",
            "Informations de contact complètes",
            "Localisation GPS précise",
            "Support prioritaire"
        )
    )

    val ANNUAL = SubscriptionPlan(
        type = SubscriptionType.ANNUAL,
        name = "Annuel",
        price = 5000,
        duration = "an",
        features = listOf(
            "Toutes les fonctionnalités mensuelles",
            "Économisez 17% (500F x 12 = 6000F)",
            "Recherche illimitée",
            "Favoris illimités",
            "Carte interactive",
            "Contacts complets",
            "Localisation GPS",
            "Support prioritaire 24/7",
            "Badge Premium exclusif"
        )
    )

    fun getAll() = listOf(FREE, MONTHLY, ANNUAL)

    fun getByType(type: SubscriptionType) = when (type) {
        SubscriptionType.FREE -> FREE
        SubscriptionType.MONTHLY -> MONTHLY
        SubscriptionType.ANNUAL -> ANNUAL
    }
}
