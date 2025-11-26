<?php

namespace App\Http\Controllers;

use App\Models\Pharmacy;
use App\Models\Schedule;
use App\Models\Rating;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class AdminController extends Controller
{
    public function dashboard()
    {
        $stats = [
            'total_pharmacies' => Pharmacy::count(),
            'active_pharmacies' => Pharmacy::where('is_active', true)->count(),
            'on_duty_today' => Pharmacy::whereHas('schedules', function($query) {
                $query->where('start_date', '<=', now())
                      ->where('end_date', '>=', now())
                      ->where('is_on_duty', true);
            })->count(),
            'total_ratings' => Rating::count(),
            'average_rating' => round(Rating::avg('rating'), 1),
        ];

        $recentRatings = Rating::with('pharmacy')
            ->latest()
            ->take(10)
            ->get();

        return view('admin.dashboard', compact('stats', 'recentRatings'));
    }

    public function pharmacies()
    {
        $pharmacies = Pharmacy::withCount('ratings')
            ->withAvg('ratings', 'rating')
            ->get();

        return view('admin.pharmacies', compact('pharmacies'));
    }

    public function createPharmacy()
    {
        return view('admin.pharmacy-form');
    }

    public function storePharmacy(Request $request)
    {
        $validated = $request->validate([
            'name' => 'required|string|max:255',
            'address' => 'required|string|max:255',
            'phone' => 'required|string|max:20',
            'phone_secondary' => 'nullable|string|max:20',
            'latitude' => 'required|numeric',
            'longitude' => 'required|numeric',
            'district' => 'nullable|string|max:100',
            'description' => 'nullable|string',
            'image' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
            'has_parking' => 'boolean',
            'has_wheelchair_access' => 'boolean',
            'is_24_hours' => 'boolean',
        ]);

        // Gérer l'upload de l'image
        if ($request->hasFile('image')) {
            $image = $request->file('image');
            $imageName = time() . '_' . $image->getClientOriginalName();
            $imagePath = $image->storeAs('pharmacies', $imageName, 'public');
            $validated['image'] = $imagePath;
        }

        Pharmacy::create($validated);

        return redirect()->route('admin.pharmacies')
            ->with('success', 'Pharmacie créée avec succès!');
    }

    public function showPharmacy($id)
    {
        $pharmacy = Pharmacy::withCount('ratings')
            ->withAvg('ratings', 'rating')
            ->findOrFail($id);

        $recentRatings = $pharmacy->ratings()
            ->latest()
            ->take(5)
            ->get();

        $currentSchedules = $pharmacy->schedules()
            ->where('end_date', '>=', now())
            ->orderBy('start_date')
            ->get();

        return view('admin.pharmacy-show', compact('pharmacy', 'recentRatings', 'currentSchedules'));
    }

    public function editPharmacy($id)
    {
        $pharmacy = Pharmacy::findOrFail($id);
        return view('admin.pharmacy-form', compact('pharmacy'));
    }

    public function updatePharmacy(Request $request, $id)
    {
        $pharmacy = Pharmacy::findOrFail($id);

        $validated = $request->validate([
            'name' => 'required|string|max:255',
            'address' => 'required|string|max:255',
            'phone' => 'required|string|max:20',
            'phone_secondary' => 'nullable|string|max:20',
            'latitude' => 'required|numeric',
            'longitude' => 'required|numeric',
            'district' => 'nullable|string|max:100',
            'description' => 'nullable|string',
            'image' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
            'has_parking' => 'boolean',
            'has_wheelchair_access' => 'boolean',
            'is_24_hours' => 'boolean',
            'is_active' => 'boolean',
        ]);

        // Gérer l'upload de l'image
        if ($request->hasFile('image')) {
            // Supprimer l'ancienne image si elle existe
            if ($pharmacy->image) {
                \Storage::disk('public')->delete($pharmacy->image);
            }

            $image = $request->file('image');
            $imageName = time() . '_' . $image->getClientOriginalName();
            $imagePath = $image->storeAs('pharmacies', $imageName, 'public');
            $validated['image'] = $imagePath;
        }

        $pharmacy->update($validated);

        return redirect()->route('admin.pharmacies')
            ->with('success', 'Pharmacie mise à jour avec succès!');
    }

    public function deletePharmacy($id)
    {
        $pharmacy = Pharmacy::findOrFail($id);
        $pharmacy->delete();

        return redirect()->route('admin.pharmacies')
            ->with('success', 'Pharmacie supprimée avec succès!');
    }

    public function schedules()
    {
        $schedules = Schedule::with('pharmacy')
            ->orderBy('start_date', 'desc')
            ->paginate(20);

        return view('admin.schedules', compact('schedules'));
    }

    public function createSchedule()
    {
        $pharmacies = Pharmacy::where('is_active', true)->get();
        return view('admin.schedule-form', compact('pharmacies'));
    }

    public function storeSchedule(Request $request)
    {
        $validated = $request->validate([
            'pharmacy_id' => 'required|exists:pharmacies,id',
            'start_date' => 'required|date',
            'end_date' => 'required|date|after_or_equal:start_date',
            'start_time' => 'nullable|date_format:H:i',
            'end_time' => 'nullable|date_format:H:i',
            'is_on_duty' => 'boolean',
            'notes' => 'nullable|string',
        ]);

        Schedule::create($validated);

        return redirect()->route('admin.schedules')
            ->with('success', 'Horaire créé avec succès!');
    }

    public function deleteSchedule($id)
    {
        $schedule = Schedule::findOrFail($id);
        $schedule->delete();

        return redirect()->route('admin.schedules')
            ->with('success', 'Horaire supprimé avec succès!');
    }

    public function ratings()
    {
        $ratings = Rating::with('pharmacy')
            ->latest()
            ->paginate(20);

        return view('admin.ratings', compact('ratings'));
    }

    public function deleteRating($id)
    {
        $rating = Rating::findOrFail($id);
        $rating->delete();

        return redirect()->route('admin.ratings')
            ->with('success', 'Évaluation supprimée avec succès!');
    }
}
