<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\PharmacyController;
use App\Http\Controllers\Api\RatingController;
use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\FavoritesController;
use App\Http\Controllers\PaymentController;
use App\Http\Controllers\SubscriptionController;
use App\Http\Controllers\WebhookController;

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

// Webhook endpoints (public - must be accessible by CamPay)
Route::post('/webhooks/campay', [WebhookController::class, 'handleCamPayWebhook']);

// Payment and Subscription endpoints (protected)
Route::middleware('auth:sanctum')->group(function () {
    // Payment endpoints
    Route::post('/payments/campay/initiate', [PaymentController::class, 'initiateCamPayPayment']);
    Route::get('/payments/{reference}/status', [PaymentController::class, 'checkPaymentStatus']);
    Route::get('/payments/history', [PaymentController::class, 'getPaymentHistory']);

    // Subscription endpoints
    Route::post('/subscriptions/activate', [SubscriptionController::class, 'activateSubscription']);
    Route::get('/subscriptions/status', [SubscriptionController::class, 'checkSubscriptionStatus']);
    Route::post('/subscriptions/cancel', [SubscriptionController::class, 'cancelSubscription']);
    Route::get('/subscriptions/history', [SubscriptionController::class, 'getSubscriptionHistory']);
});
