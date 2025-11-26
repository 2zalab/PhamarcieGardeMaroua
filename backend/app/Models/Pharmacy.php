<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Pharmacy extends Model
{
    use HasFactory;

    protected $fillable = [
        'name',
        'address',
        'phone',
        'phone_secondary',
        'latitude',
        'longitude',
        'image',
        'description',
        'city',
        'district',
        'has_parking',
        'has_wheelchair_access',
        'is_24_hours',
        'is_active',
    ];

    protected $casts = [
        'latitude' => 'decimal:8',
        'longitude' => 'decimal:8',
        'has_parking' => 'boolean',
        'has_wheelchair_access' => 'boolean',
        'is_24_hours' => 'boolean',
        'is_active' => 'boolean',
    ];

    protected $appends = ['image_url'];

    /**
     * Accesseur pour l'URL complète de l'image
     */
    public function getImageUrlAttribute(): ?string
    {
        if ($this->image) {
            return asset('storage/' . $this->image);
        }
        // Image par défaut
        return asset('images/pharmacy-default.png');
    }

    public function schedules(): HasMany
    {
        return $this->hasMany(Schedule::class);
    }

    public function ratings(): HasMany
    {
        return $this->hasMany(Rating::class);
    }

    public function currentSchedule()
    {
        return $this->schedules()
            ->where('start_date', '<=', now())
            ->where('end_date', '>=', now())
            ->where('is_on_duty', true)
            ->first();
    }

    public function isOnDutyToday(): bool
    {
        return $this->currentSchedule() !== null;
    }

    public function averageRating(): float
    {
        return round($this->ratings()->avg('rating') ?? 0, 1);
    }

    public function ratingsCount(): int
    {
        return $this->ratings()->count();
    }
}
