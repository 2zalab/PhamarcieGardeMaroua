<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\PharmacyController;
use App\Http\Controllers\Api\RatingController;
use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\FavoritesController;

// Authentication endpoints (public)
Route::post('/auth/google', [AuthController::class, 'googleAuth']);

// Protected routes (require authentication)
Route::middleware('auth:sanctum')->group(function () {
    // Auth user info
    Route::get('/auth/me', [AuthController::class, 'me']);
    Route::post('/auth/logout', [AuthController::class, 'logout']);

    // Favorites endpoints
    Route::get('/favorites', [FavoritesController::class, 'index']);
    Route::post('/favorites', [FavoritesController::class, 'store']);
    Route::delete('/favorites/{pharmacyId}', [FavoritesController::class, 'destroy']);
    Route::get('/favorites/{pharmacyId}/check', [FavoritesController::class, 'check']);

    // Ratings (protected)
    Route::post('/pharmacies/{id}/ratings', [RatingController::class, 'store']);
});

// Pharmacies endpoints (public)
Route::get('/pharmacies', [PharmacyController::class, 'index']);
Route::post('/pharmacies', [PharmacyController::class, 'store']);
Route::get('/pharmacies/on-duty', [PharmacyController::class, 'onDuty']);
Route::get('/pharmacies/nearby', [PharmacyController::class, 'nearby']);
Route::get('/pharmacies/{id}', [PharmacyController::class, 'show']);

// Ratings endpoints (public read)
Route::get('/pharmacies/{id}/ratings', [RatingController::class, 'index']);
