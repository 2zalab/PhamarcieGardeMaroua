@extends('admin.layout-sidebar')

@section('title', 'Tableau de bord')
@section('page-title', 'Tableau de bord')

@section('content')
<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-6 mb-8">
    <div class="bg-white rounded-xl shadow-lg p-6 border-l-4 border-teal-500">
        <div class="flex items-center justify-between">
            <div>
                <div class="text-3xl font-bold text-teal-600">{{ $stats['total_pharmacies'] }}</div>
                <div class="text-gray-600 text-sm">Pharmacies totales</div>
            </div>
            <i class="fas fa-hospital text-4xl text-teal-200"></i>
        </div>
    </div>

    <div class="bg-white rounded-xl shadow-lg p-6 border-l-4 border-green-500">
        <div class="flex items-center justify-between">
            <div>
                <div class="text-3xl font-bold text-green-600">{{ $stats['active_pharmacies'] }}</div>
                <div class="text-gray-600 text-sm">Pharmacies actives</div>
            </div>
            <i class="fas fa-check-circle text-4xl text-green-200"></i>
        </div>
    </div>

    <div class="bg-white rounded-xl shadow-lg p-6 border-l-4 border-blue-500">
        <div class="flex items-center justify-between">
            <div>
                <div class="text-3xl font-bold text-blue-600">{{ $stats['on_duty_today'] }}</div>
                <div class="text-gray-600 text-sm">De garde aujourd'hui</div>
            </div>
            <i class="fas fa-calendar-check text-4xl text-blue-200"></i>
        </div>
    </div>

    <div class="bg-white rounded-xl shadow-lg p-6 border-l-4 border-purple-500">
        <div class="flex items-center justify-between">
            <div>
                <div class="text-3xl font-bold text-purple-600">{{ $stats['total_ratings'] }}</div>
                <div class="text-gray-600 text-sm">Évaluations totales</div>
            </div>
            <i class="fas fa-comment-dots text-4xl text-purple-200"></i>
        </div>
    </div>

    <div class="bg-white rounded-xl shadow-lg p-6 border-l-4 border-yellow-500">
        <div class="flex items-center justify-between">
            <div>
                <div class="text-3xl font-bold text-yellow-600">{{ $stats['average_rating'] }}/5</div>
                <div class="text-gray-600 text-sm">Note moyenne</div>
            </div>
            <i class="fas fa-star text-4xl text-yellow-200"></i>
        </div>
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
