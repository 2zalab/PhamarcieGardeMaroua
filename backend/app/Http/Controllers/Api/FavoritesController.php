<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Favorite;
use App\Models\Pharmacy;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class FavoritesController extends Controller
{
    /**
     * Récupérer tous les favoris de l'utilisateur
     *
     * @param Request $request
     * @return \Illuminate\Http\JsonResponse
     */
    public function index(Request $request)
    {
        try {
            $user = $request->user();

            // Récupérer les IDs des pharmacies favorites
            $favoriteIds = Favorite::where('user_id', $user->id)
                ->pluck('pharmacy_id')
                ->toArray();

            // Récupérer les pharmacies favorites avec leurs détails
            $pharmacies = Pharmacy::whereIn('id', $favoriteIds)
                ->with('schedules')
                ->get();

            return response()->json([
                'success' => true,
                'data' => [
                    'favorite_ids' => $favoriteIds,
                    'pharmacies' => $pharmacies
                ]
            ], 200);

        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Failed to fetch favorites',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Ajouter une pharmacie aux favoris
     *
     * @param Request $request
     * @return \Illuminate\Http\JsonResponse
     */
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'pharmacy_id' => 'required|integer|exists:pharmacies,id',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'success' => false,
                'message' => 'Validation error',
                'errors' => $validator->errors()
            ], 422);
        }

        try {
            $user = $request->user();
            $pharmacyId = $request->pharmacy_id;

            // Vérifier si déjà en favoris
            $exists = Favorite::where('user_id', $user->id)
                ->where('pharmacy_id', $pharmacyId)
                ->exists();

            if ($exists) {
                return response()->json([
                    'success' => false,
                    'message' => 'Pharmacy already in favorites'
                ], 409);
            }

            // Ajouter aux favoris
            Favorite::create([
                'user_id' => $user->id,
                'pharmacy_id' => $pharmacyId,
            ]);

            return response()->json([
                'success' => true,
                'message' => 'Pharmacy added to favorites'
            ], 201);

        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Failed to add favorite',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Retirer une pharmacie des favoris
     *
     * @param Request $request
     * @param int $pharmacyId
     * @return \Illuminate\Http\JsonResponse
     */
    public function destroy(Request $request, $pharmacyId)
    {
        try {
            $user = $request->user();

            $deleted = Favorite::where('user_id', $user->id)
                ->where('pharmacy_id', $pharmacyId)
                ->delete();

            if (!$deleted) {
                return response()->json([
                    'success' => false,
                    'message' => 'Favorite not found'
                ], 404);
            }

            return response()->json([
                'success' => true,
                'message' => 'Pharmacy removed from favorites'
            ], 200);

        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Failed to remove favorite',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Vérifier si une pharmacie est en favoris
     *
     * @param Request $request
     * @param int $pharmacyId
     * @return \Illuminate\Http\JsonResponse
     */
    public function check(Request $request, $pharmacyId)
    {
        try {
            $user = $request->user();

            $isFavorite = Favorite::where('user_id', $user->id)
                ->where('pharmacy_id', $pharmacyId)
                ->exists();

            return response()->json([
                'success' => true,
                'data' => [
                    'is_favorite' => $isFavorite
                ]
            ], 200);

        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Failed to check favorite',
                'error' => $e->getMessage()
            ], 500);
        }
    }
}
