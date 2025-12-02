<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AdminController;
use App\Http\Controllers\Web\AuthController;
use App\Http\Controllers\ContactController;

// Note: The welcome route (/) is defined in RouteServiceProvider
// to avoid session middleware issues

// API Documentation
Route::get('/api-docs', function () {
    return view('api-docs');
})->name('api.docs');

// Contact
Route::get('/contact', [ContactController::class, 'show'])->name('contact');
Route::post('/contact', [ContactController::class, 'send'])->name('contact.send');

// Formulaire de collecte des pharmacies (public)
Route::get('/collecte-pharmacies', function () {
    return view('collecte-pharmacies');
})->name('collecte.pharmacies');

// Admin Authentication Routes (public)
Route::prefix('admin')->name('admin.')->group(function () {
    Route::get('/login', [AuthController::class, 'showLoginForm'])->name('login');
    Route::post('/login', [AuthController::class, 'login'])->name('login.submit');
});

// Admin routes (protected)
Route::prefix('admin')->name('admin.')->middleware('admin.auth')->group(function () {
    Route::post('/logout', [AuthController::class, 'logout'])->name('logout');
    Route::get('/', [AdminController::class, 'dashboard'])->name('dashboard');

    // Pharmacies
    Route::get('/pharmacies', [AdminController::class, 'pharmacies'])->name('pharmacies');
    Route::get('/pharmacies/create', [AdminController::class, 'createPharmacy'])->name('pharmacies.create');
    Route::post('/pharmacies', [AdminController::class, 'storePharmacy'])->name('pharmacies.store');
    Route::get('/pharmacies/{id}', [AdminController::class, 'showPharmacy'])->name('pharmacies.show');
    Route::get('/pharmacies/{id}/edit', [AdminController::class, 'editPharmacy'])->name('pharmacies.edit');
    Route::put('/pharmacies/{id}', [AdminController::class, 'updatePharmacy'])->name('pharmacies.update');
    Route::delete('/pharmacies/{id}', [AdminController::class, 'deletePharmacy'])->name('pharmacies.delete');

    // Schedules
    Route::get('/schedules', [AdminController::class, 'schedules'])->name('schedules');
    Route::get('/schedules/create', [AdminController::class, 'createSchedule'])->name('schedules.create');
    Route::post('/schedules', [AdminController::class, 'storeSchedule'])->name('schedules.store');
    Route::delete('/schedules/{id}', [AdminController::class, 'deleteSchedule'])->name('schedules.delete');

    // Ratings
    Route::get('/ratings', [AdminController::class, 'ratings'])->name('ratings');
    Route::delete('/ratings/{id}', [AdminController::class, 'deleteRating'])->name('ratings.delete');
});
