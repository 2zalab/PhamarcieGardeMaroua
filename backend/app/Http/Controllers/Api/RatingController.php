<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Pharmacy;
use App\Models\Rating;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;

class RatingController extends Controller
{
    public function store(Request $request, $pharmacyId): JsonResponse
    {
        $pharmacy = Pharmacy::find($pharmacyId);

        if (!$pharmacy) {
            return response()->json([
                'success' => false,
                'message' => 'Pharmacie non trouvée'
            ], 404);
        }

        $validated = $request->validate([
            'rating' => 'required|integer|min:1|max:5',
            'comment' => 'nullable|string|max:500',
            'user_name' => 'nullable|string|max:100',
            'user_email' => 'nullable|email|max:100',
            'device_id' => 'nullable|string|max:100',
        ]);

        $rating = Rating::create([
            'pharmacy_id' => $pharmacyId,
            'rating' => $validated['rating'],
            'comment' => $validated['comment'] ?? null,
            'user_name' => $validated['user_name'] ?? 'Anonyme',
            'user_email' => $validated['user_email'] ?? null,
            'device_id' => $validated['device_id'] ?? null,
        ]);

        return response()->json([
            'success' => true,
            'message' => 'Évaluation enregistrée avec succès',
            'rating' => [
                'id' => $rating->id,
                'pharmacy_id' => $rating->pharmacy_id,
                'rating' => $rating->rating,
                'comment' => $rating->comment,
                'user_name' => $rating->user_name,
                'user_email' => $rating->user_email,
                'device_id' => $rating->device_id,
                'created_at' => $rating->created_at->toISOString(),
            ]
        ], 201);
    }

    public function index(Request $request, $pharmacyId): JsonResponse
    {
        $pharmacy = Pharmacy::find($pharmacyId);

        if (!$pharmacy) {
            return response()->json([
                'success' => false,
                'message' => 'Pharmacie non trouvée'
            ], 404);
        }

        // Limiter au nombre d'avis demandés (par défaut 10, max 50)
        $limit = min((int) $request->query('limit', 10), 50);
        $offset = (int) $request->query('offset', 0);

        // Récupérer les avis triés du plus récent au plus ancien
        $ratings = $pharmacy->ratings()
            ->latest()
            ->skip($offset)
            ->take($limit)
            ->get()
            ->map(function($rating) {
                return [
                    'id' => $rating->id,
                    'pharmacy_id' => $rating->pharmacy_id,
                    'rating' => $rating->rating,
                    'comment' => $rating->comment,
                    'user_name' => $rating->user_name ?? 'Anonyme',
                    'user_email' => $rating->user_email,
                    'device_id' => $rating->device_id,
                    'created_at' => $rating->created_at->toISOString(),
                ];
            });

        return response()->json([
            'ratings' => $ratings,
            'average_rating' => round($pharmacy->averageRating(), 1),
            'total_ratings' => $pharmacy->ratingsCount(),
        ]);
    }
}
