package com.maroua.pharmaciegarde.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val uid: String = "",
    val email: String = "",
    val displayName: String = "",
    val photoUrl: String? = null,
    val isSubscribed: Boolean = false,
    val subscriptionType: SubscriptionType = SubscriptionType.FREE,
    val subscriptionExpiryDate: Long? = null
) : Parcelable

enum class SubscriptionType {
    FREE,
    MONTHLY,
    ANNUAL
}
