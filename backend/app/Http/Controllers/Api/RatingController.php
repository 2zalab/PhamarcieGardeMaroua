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
            'user_name' => $validated['user_name'] ?? null,
            'user_email' => $validated['user_email'] ?? null,
            'device_id' => $validated['device_id'] ?? null,
        ]);

        return response()->json([
            'success' => true,
            'message' => 'Évaluation enregistrée avec succès',
            'data' => [
                'rating' => $rating,
                'average_rating' => $pharmacy->averageRating(),
                'ratings_count' => $pharmacy->ratingsCount(),
            ]
        ], 201);
    }

    public function index($pharmacyId): JsonResponse
    {
        $pharmacy = Pharmacy::find($pharmacyId);

        if (!$pharmacy) {
            return response()->json([
                'success' => false,
                'message' => 'Pharmacie non trouvée'
            ], 404);
        }

        $ratings = $pharmacy->ratings()
            ->latest()
            ->get()
            ->map(function($rating) {
                return [
                    'id' => $rating->id,
                    'rating' => $rating->rating,
                    'comment' => $rating->comment,
                    'user_name' => $rating->user_name ?? 'Anonyme',
                    'created_at' => $rating->created_at->format('Y-m-d H:i:s'),
                ];
            });

        return response()->json([
            'success' => true,
            'data' => [
                'ratings' => $ratings,
                'average_rating' => $pharmacy->averageRating(),
                'ratings_count' => $pharmacy->ratingsCount(),
            ]
        ]);
    }
}
