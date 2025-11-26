<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AdminController;

// Note: The welcome route (/) is defined in RouteServiceProvider
// to avoid session middleware issues

// Formulaire de collecte des pharmacies (public)
Route::get('/collecte-pharmacies', function () {
    return view('collecte-pharmacies');
})->name('collecte.pharmacies');

// Admin routes
Route::prefix('admin')->name('admin.')->group(function () {
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
