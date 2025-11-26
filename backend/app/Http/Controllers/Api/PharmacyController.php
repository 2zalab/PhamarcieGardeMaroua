<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Pharmacy;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Validator;

class PharmacyController extends Controller
{
    /**
     * Créer une nouvelle pharmacie avec upload d'image
     */
    public function store(Request $request): JsonResponse
    {
        $validator = Validator::make($request->all(), [
            'name' => 'required|string|max:255',
            'city' => 'required|string|max:255',
            'address' => 'required|string|max:500',
            'phone' => 'required|string|max:20',
            'phone_secondary' => 'nullable|string|max:20',
            'latitude' => 'nullable|numeric|between:-90,90',
            'longitude' => 'nullable|numeric|between:-180,180',
            'description' => 'nullable|string',
            'district' => 'nullable|string|max:255',
            'image' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
            'has_parking' => 'nullable|boolean',
            'has_wheelchair_access' => 'nullable|boolean',
            'is_24_hours' => 'nullable|boolean',
            'is_active' => 'nullable|boolean',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'success' => false,
                'message' => 'Validation error',
                'errors' => $validator->errors()
            ], 422);
        }

        try {
            $data = $validator->validated();

            // Upload de l'image si elle existe
            if ($request->hasFile('image')) {
                $image = $request->file('image');
                $imageName = time() . '_' . $image->getClientOriginalName();
                $imagePath = $image->storeAs('pharmacies', $imageName, 'public');
                $data['image'] = $imagePath;
            }

            // Convertir les valeurs booléennes
            $data['has_parking'] = isset($data['has_parking']) ? (bool)$data['has_parking'] : false;
            $data['has_wheelchair_access'] = isset($data['has_wheelchair_access']) ? (bool)$data['has_wheelchair_access'] : false;
            $data['is_24_hours'] = isset($data['is_24_hours']) ? (bool)$data['is_24_hours'] : false;
            $data['is_active'] = isset($data['is_active']) ? (bool)$data['is_active'] : true;

            $pharmacy = Pharmacy::create($data);

            return response()->json([
                'success' => true,
                'message' => 'Pharmacie créée avec succès',
                'data' => $pharmacy
            ], 201);

        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de la création',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function index(Request $request): JsonResponse
    {
        $query = Pharmacy::with('schedules')
            ->where('is_active', true);

        if ($request->has('search')) {
            $search = $request->input('search');
            $query->where(function($q) use ($search) {
                $q->where('name', 'like', "%{$search}%")
                  ->orWhere('address', 'like', "%{$search}%")
                  ->orWhere('district', 'like', "%{$search}%");
            });
        }

        if ($request->has('district')) {
            $query->where('district', $request->input('district'));
        }

        $pharmacies = $query->get()->map(function($pharmacy) {
            return [
                'id' => $pharmacy->id,
                'name' => $pharmacy->name,
                'address' => $pharmacy->address,
                'phone' => $pharmacy->phone,
                'phone_secondary' => $pharmacy->phone_secondary,
                'latitude' => (float) $pharmacy->latitude,
                'longitude' => (float) $pharmacy->longitude,
                'image_url' => $pharmacy->image_url,
                'description' => $pharmacy->description,
                'city' => $pharmacy->city,
                'district' => $pharmacy->district,
                'has_parking' => $pharmacy->has_parking,
                'has_wheelchair_access' => $pharmacy->has_wheelchair_access,
                'is_24_hours' => $pharmacy->is_24_hours,
                'is_on_duty_today' => $pharmacy->isOnDutyToday(),
                'current_schedule' => $pharmacy->currentSchedule(),
            ];
        });

        return response()->json([
            'success' => true,
            'data' => $pharmacies
        ]);
    }

    public function show($id): JsonResponse
    {
        $pharmacy = Pharmacy::with('schedules')->find($id);

        if (!$pharmacy) {
            return response()->json([
                'success' => false,
                'message' => 'Pharmacie non trouvée'
            ], 404);
        }

        return response()->json([
            'success' => true,
            'data' => [
                'id' => $pharmacy->id,
                'name' => $pharmacy->name,
                'address' => $pharmacy->address,
                'phone' => $pharmacy->phone,
                'phone_secondary' => $pharmacy->phone_secondary,
                'latitude' => (float) $pharmacy->latitude,
                'longitude' => (float) $pharmacy->longitude,
                'image_url' => $pharmacy->image_url,
                'description' => $pharmacy->description,
                'city' => $pharmacy->city,
                'district' => $pharmacy->district,
                'has_parking' => $pharmacy->has_parking,
                'has_wheelchair_access' => $pharmacy->has_wheelchair_access,
                'is_24_hours' => $pharmacy->is_24_hours,
                'is_on_duty_today' => $pharmacy->isOnDutyToday(),
                'schedules' => $pharmacy->schedules,
            ]
        ]);
    }

    public function onDuty(): JsonResponse
    {
        $pharmacies = Pharmacy::with('schedules')
            ->where('is_active', true)
            ->get()
            ->filter(function($pharmacy) {
                return $pharmacy->isOnDutyToday();
            })
            ->values()
            ->map(function($pharmacy) {
                return [
                    'id' => $pharmacy->id,
                    'name' => $pharmacy->name,
                    'address' => $pharmacy->address,
                    'phone' => $pharmacy->phone,
                    'phone_secondary' => $pharmacy->phone_secondary,
                    'latitude' => (float) $pharmacy->latitude,
                    'longitude' => (float) $pharmacy->longitude,
                    'image_url' => $pharmacy->image_url,
                    'description' => $pharmacy->description,
                    'city' => $pharmacy->city,
                    'district' => $pharmacy->district,
                    'has_parking' => $pharmacy->has_parking,
                    'has_wheelchair_access' => $pharmacy->has_wheelchair_access,
                    'is_24_hours' => $pharmacy->is_24_hours,
                    'current_schedule' => $pharmacy->currentSchedule(),
                ];
            });

        return response()->json([
            'success' => true,
            'data' => $pharmacies
        ]);
    }

    public function nearby(Request $request): JsonResponse
    {
        $request->validate([
            'latitude' => 'required|numeric',
            'longitude' => 'required|numeric',
            'radius' => 'nullable|numeric|min:0.1|max:50'
        ]);

        $lat = $request->input('latitude');
        $lng = $request->input('longitude');
        $radius = $request->input('radius', 10);

        $pharmacies = Pharmacy::selectRaw("
                *,
                (6371 * acos(cos(radians(?)) * cos(radians(latitude)) * cos(radians(longitude) - radians(?)) + sin(radians(?)) * sin(radians(latitude)))) AS distance
            ", [$lat, $lng, $lat])
            ->where('is_active', true)
            ->having('distance', '<', $radius)
            ->orderBy('distance')
            ->with('schedules')
            ->get()
            ->map(function($pharmacy) {
                return [
                    'id' => $pharmacy->id,
                    'name' => $pharmacy->name,
                    'address' => $pharmacy->address,
                    'phone' => $pharmacy->phone,
                    'phone_secondary' => $pharmacy->phone_secondary,
                    'latitude' => (float) $pharmacy->latitude,
                    'longitude' => (float) $pharmacy->longitude,
                    'image_url' => $pharmacy->image_url,
                    'description' => $pharmacy->description,
                    'city' => $pharmacy->city,
                    'district' => $pharmacy->district,
                    'has_parking' => $pharmacy->has_parking,
                    'has_wheelchair_access' => $pharmacy->has_wheelchair_access,
                    'is_24_hours' => $pharmacy->is_24_hours,
                    'is_on_duty_today' => $pharmacy->isOnDutyToday(),
                    'distance' => round($pharmacy->distance, 2),
                ];
            });

        return response()->json([
            'success' => true,
            'data' => $pharmacies
        ]);
    }
}
