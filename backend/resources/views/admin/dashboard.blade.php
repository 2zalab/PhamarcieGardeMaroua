@extends('admin.layout')

@section('title', 'Tableau de bord')

@section('content')
<div class="mb-8">
    <h2 class="text-3xl font-bold text-gray-800">Tableau de bord</h2>
    <p class="text-gray-600">Vue d'ensemble du système</p>
</div>

<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-6 mb-8">
    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-teal-600">{{ $stats['total_pharmacies'] }}</div>
        <div class="text-gray-600">Pharmacies totales</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-green-600">{{ $stats['active_pharmacies'] }}</div>
        <div class="text-gray-600">Pharmacies actives</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-blue-600">{{ $stats['on_duty_today'] }}</div>
        <div class="text-gray-600">De garde aujourd'hui</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-purple-600">{{ $stats['total_ratings'] }}</div>
        <div class="text-gray-600">Évaluations totales</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-yellow-600">{{ $stats['average_rating'] }}/5</div>
        <div class="text-gray-600">Note moyenne</div>
    </div>
</div>

<div class="bg-white rounded-lg shadow-md p-6">
    <h3 class="text-xl font-bold text-gray-800 mb-4">Évaluations récentes</h3>
    <div class="overflow-x-auto">
        <table class="min-w-full">
            <thead class="bg-gray-50">
                <tr>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Pharmacie</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Note</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Utilisateur</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Commentaire</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Date</th>
                </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
                @forelse($recentRatings as $rating)
                <tr>
                    <td class="px-6 py-4">{{ $rating->pharmacy->name }}</td>
                    <td class="px-6 py-4">
                        <span class="text-yellow-500 font-bold">{{ $rating->rating }}/5</span>
                    </td>
                    <td class="px-6 py-4">{{ $rating->user_name ?? 'Anonyme' }}</td>
                    <td class="px-6 py-4 text-sm">{{ Str::limit($rating->comment, 50) }}</td>
                    <td class="px-6 py-4 text-sm">{{ $rating->created_at->format('d/m/Y H:i') }}</td>
                </tr>
                @empty
                <tr>
                    <td colspan="5" class="px-6 py-4 text-center text-gray-500">Aucune évaluation</td>
                </tr>
                @endforelse
            </tbody>
        </table>
    </div>
</div>
@endsection
