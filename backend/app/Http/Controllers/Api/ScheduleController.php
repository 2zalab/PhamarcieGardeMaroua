<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Pharmacy;
use App\Models\Schedule;
use Illuminate\Http\Request;
use Carbon\Carbon;
use Illuminate\Support\Facades\DB;

class ScheduleController extends Controller
{
    /**
     * Récupère les pharmacies de garde pour un jour spécifique
     *
     * @param string $date Format: YYYY-MM-DD
     */
    public function getScheduleByDay($date)
    {
        try {
            $targetDate = Carbon::parse($date);

            $pharmacies = Pharmacy::whereHas('schedules', function ($query) use ($targetDate) {
                $query->where('is_on_duty', true)
                      ->whereDate('start_date', '<=', $targetDate)
                      ->whereDate('end_date', '>=', $targetDate);
            })
            ->with(['schedules' => function ($query) use ($targetDate) {
                $query->where('is_on_duty', true)
                      ->whereDate('start_date', '<=', $targetDate)
                      ->whereDate('end_date', '>=', $targetDate);
            }])
            ->get();

            return response()->json([
                'success' => true,
                'data' => [
                    'date' => $targetDate->format('Y-m-d'),
                    'day_of_week' => $this->getDayName($targetDate),
                    'pharmacies' => $pharmacies
                ]
            ]);
        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de la récupération des données',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Récupère les pharmacies de garde pour une semaine
     *
     * @param string $date Date dans la semaine (YYYY-MM-DD)
     */
    public function getScheduleByWeek($date)
    {
        try {
            $targetDate = Carbon::parse($date);
            $startOfWeek = $targetDate->copy()->startOfWeek(Carbon::MONDAY);
            $endOfWeek = $targetDate->copy()->endOfWeek(Carbon::SUNDAY);

            $schedulesByDay = [];

            for ($day = $startOfWeek->copy(); $day <= $endOfWeek; $day->addDay()) {
                $pharmacies = Pharmacy::whereHas('schedules', function ($query) use ($day) {
                    $query->where('is_on_duty', true)
                          ->whereDate('start_date', '<=', $day)
                          ->whereDate('end_date', '>=', $day);
                })
                ->with(['schedules' => function ($query) use ($day) {
                    $query->where('is_on_duty', true)
                          ->whereDate('start_date', '<=', $day)
                          ->whereDate('end_date', '>=', $day);
                }])
                ->get();

                $schedulesByDay[] = [
                    'date' => $day->format('Y-m-d'),
                    'day_of_week' => $this->getDayName($day),
                    'pharmacies' => $pharmacies
                ];
            }

            return response()->json([
                'success' => true,
                'data' => $schedulesByDay
            ]);
        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de la récupération des données',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Récupère les pharmacies de garde pour un mois
     *
     * @param int $year Année (ex: 2025)
     * @param int $month Mois (1-12)
     */
    public function getScheduleByMonth($year, $month)
    {
        try {
            $startOfMonth = Carbon::create($year, $month, 1)->startOfDay();
            $endOfMonth = $startOfMonth->copy()->endOfMonth();

            $schedulesByDay = [];

            for ($day = $startOfMonth->copy(); $day <= $endOfMonth; $day->addDay()) {
                $pharmacies = Pharmacy::whereHas('schedules', function ($query) use ($day) {
                    $query->where('is_on_duty', true)
                          ->whereDate('start_date', '<=', $day)
                          ->whereDate('end_date', '>=', $day);
                })
                ->with(['schedules' => function ($query) use ($day) {
                    $query->where('is_on_duty', true)
                          ->whereDate('start_date', '<=', $day)
                          ->whereDate('end_date', '>=', $day);
                }])
                ->get();

                $schedulesByDay[] = [
                    'date' => $day->format('Y-m-d'),
                    'day_of_week' => $this->getDayName($day),
                    'pharmacies' => $pharmacies
                ];
            }

            return response()->json([
                'success' => true,
                'data' => $schedulesByDay
            ]);
        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de la récupération des données',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Récupère les pharmacies de garde pour une plage de dates
     *
     * @param Request $request
     */
    public function getScheduleByRange(Request $request)
    {
        $request->validate([
            'start_date' => 'required|date',
            'end_date' => 'required|date|after_or_equal:start_date'
        ]);

        try {
            $startDate = Carbon::parse($request->start_date);
            $endDate = Carbon::parse($request->end_date);

            $schedulesByDay = [];

            for ($day = $startDate->copy(); $day <= $endDate; $day->addDay()) {
                $pharmacies = Pharmacy::whereHas('schedules', function ($query) use ($day) {
                    $query->where('is_on_duty', true)
                          ->whereDate('start_date', '<=', $day)
                          ->whereDate('end_date', '>=', $day);
                })
                ->with(['schedules' => function ($query) use ($day) {
                    $query->where('is_on_duty', true)
                          ->whereDate('start_date', '<=', $day)
                          ->whereDate('end_date', '>=', $day);
                }])
                ->get();

                $schedulesByDay[] = [
                    'date' => $day->format('Y-m-d'),
                    'day_of_week' => $this->getDayName($day),
                    'pharmacies' => $pharmacies
                ];
            }

            return response()->json([
                'success' => true,
                'data' => $schedulesByDay
            ]);
        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Erreur lors de la récupération des données',
                'error' => $e->getMessage()
            ], 500);
        }
    }

    /**
     * Retourne le nom du jour en français
     */
    private function getDayName(Carbon $date)
    {
        $days = [
            0 => 'Dimanche',
            1 => 'Lundi',
            2 => 'Mardi',
            3 => 'Mercredi',
            4 => 'Jeudi',
            5 => 'Vendredi',
            6 => 'Samedi'
        ];

        return $days[$date->dayOfWeek];
    }
}
