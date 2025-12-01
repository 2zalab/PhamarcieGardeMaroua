<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Relations\HasMany;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;

class User extends Authenticatable
{
    use HasApiTokens, HasFactory, Notifiable;

    protected $fillable = [
        'name',
        'email',
        'password',
        'google_id',
        'avatar',
        'is_subscribed',
        'subscription_type',
        'subscription_expires_at',
        'is_admin',
    ];

    protected $hidden = [
        'password',
        'remember_token',
    ];

    protected $casts = [
        'email_verified_at' => 'datetime',
        'is_subscribed' => 'boolean',
        'subscription_expires_at' => 'datetime',
        'is_admin' => 'boolean',
    ];

    /**
     * Get the payments for the user.
     */
    public function payments(): HasMany
    {
        return $this->hasMany(Payment::class);
    }

    /**
     * Get the subscriptions for the user.
     */
    public function subscriptions(): HasMany
    {
        return $this->hasMany(Subscription::class);
    }

    /**
     * Get the active subscription for the user.
     */
    public function activeSubscription(): ?Subscription
    {
        return $this->subscriptions()
            ->where('status', 'ACTIVE')
            ->first();
    }

    /**
     * Check if user has an active subscription.
     */
    public function hasActiveSubscription(): bool
    {
        return $this->is_subscribed
            && ($this->subscription_expires_at === null || $this->subscription_expires_at->isFuture());
    }

    /**
     * Check if user is on a premium subscription (MONTHLY or ANNUAL).
     */
    public function isPremium(): bool
    {
        return $this->hasActiveSubscription()
            && in_array($this->subscription_type, ['MONTHLY', 'ANNUAL']);
    }

    /**
     * Check if user is on free subscription.
     */
    public function isFree(): bool
    {
        return !$this->isPremium();
    }

    /**
     * Check if user can add favorites (premium feature).
     */
    public function canAddFavorites(): bool
    {
        return $this->isPremium();
    }

    /**
     * Check if user can view contact information (premium feature).
     */
    public function canViewContactInfo(): bool
    {
        return $this->isPremium();
    }

    /**
     * Check if user can access map (premium feature).
     */
    public function canAccessMap(): bool
    {
        return $this->isPremium();
    }

    /**
     * Check if user is an admin.
     */
    public function isAdmin(): bool
    {
        return $this->is_admin === true;
    }
}
