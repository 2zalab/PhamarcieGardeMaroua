@extends('admin.layout-sidebar')

@section('title', 'Détails de la pharmacie')
@section('page-title', 'Détails de la pharmacie')

@section('content')
<div class="mb-8 flex justify-between items-center">
    <div>
        <h2 class="text-3xl font-bold text-gray-800">{{ $pharmacy->name }}</h2>
        <p class="text-gray-600">Détails et informations complètes</p>
    </div>
    <div class="space-x-2">
        <a href="{{ route('admin.pharmacies') }}" class="px-4 py-2 bg-gray-200 text-gray-700 rounded hover:bg-gray-300 inline-flex items-center">
            <i class="fas fa-arrow-left mr-2"></i>Retour
        </a>
        <a href="{{ route('admin.pharmacies.edit', $pharmacy->id) }}" class="px-4 py-2 bg-teal-600 text-white rounded hover:bg-teal-700 inline-flex items-center">
            <i class="fas fa-edit mr-2"></i>Modifier
        </a>
    </div>
</div>

<!-- Image de la pharmacie -->
@if($pharmacy->image)
<div class="mb-6 bg-white rounded-lg shadow-md overflow-hidden">
    <img src="{{ asset('storage/' . $pharmacy->image) }}" alt="{{ $pharmacy->name }}"
        class="w-full h-64 object-cover">
</div>
@endif

<!-- Informations principales -->
<div class="grid grid-cols-1 lg:grid-cols-3 gap-6 mb-6">
    <!-- Carte d'informations -->
    <div class="lg:col-span-2 bg-white rounded-lg shadow-md p-6">
        <h3 class="text-xl font-bold text-gray-800 mb-4">Informations générales</h3>

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
                <label class="text-sm font-medium text-gray-500">Nom</label>
                <p class="text-gray-900 font-medium">{{ $pharmacy->name }}</p>
            </div>

            <div>
                <label class="text-sm font-medium text-gray-500">Statut</label>
                <p>
                    <span class="px-3 py-1 text-sm rounded {{ $pharmacy->is_active ? 'bg-green-100 text-green-800' : 'bg-red-100 text-red-800' }}">
                        {{ $pharmacy->is_active ? 'Active' : 'Inactive' }}
                    </span>
                </p>
            </div>

            <div>
                <label class="text-sm font-medium text-gray-500">Téléphone principal</label>
                <p class="text-gray-900">{{ $pharmacy->phone }}</p>
            </div>

            @if($pharmacy->phone_secondary)
            <div>
                <label class="text-sm font-medium text-gray-500">Téléphone secondaire</label>
                <p class="text-gray-900">{{ $pharmacy->phone_secondary }}</p>
            </div>
            @endif

            <div class="md:col-span-2">
                <label class="text-sm font-medium text-gray-500">Adresse</label>
                <p class="text-gray-900">{{ $pharmacy->address }}</p>
            </div>

            @if($pharmacy->district)
            <div>
                <label class="text-sm font-medium text-gray-500">Quartier</label>
                <p class="text-gray-900">{{ $pharmacy->district }}</p>
            </div>
            @endif

            <div>
                <label class="text-sm font-medium text-gray-500">Coordonnées GPS</label>
                <p class="text-gray-900">{{ $pharmacy->latitude }}, {{ $pharmacy->longitude }}</p>
            </div>

            @if($pharmacy->description)
            <div class="md:col-span-2">
                <label class="text-sm font-medium text-gray-500">Description</label>
                <p class="text-gray-900">{{ $pharmacy->description }}</p>
            </div>
            @endif
        </div>

        <!-- Services et équipements -->
        <div class="mt-6">
            <label class="text-sm font-medium text-gray-500 mb-2 block">Services et équipements</label>
            <div class="flex flex-wrap gap-2">
                @if($pharmacy->has_parking)
                <span class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm">🅿️ Parking</span>
                @endif
                @if($pharmacy->has_wheelchair_access)
                <span class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm">♿ Accès handicapé</span>
                @endif
                @if($pharmacy->is_24_hours)
                <span class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm">⏰ 24h/24</span>
                @endif
                @if(!$pharmacy->has_parking && !$pharmacy->has_wheelchair_access && !$pharmacy->is_24_hours)
                <span class="text-gray-500 text-sm">Aucun service spécifique</span>
                @endif
            </div>
        </div>
    </div>

    <!-- Statistiques -->
    <div class="space-y-6">
        <div class="bg-white rounded-lg shadow-md p-6">
            <h3 class="text-lg font-bold text-gray-800 mb-4">Statistiques</h3>
            <div class="space-y-4">
                <div>
                    <div class="text-3xl font-bold text-yellow-600">
                        {{ round($pharmacy->ratings_avg_rating ?? 0, 1) }}/5
                    </div>
                    <div class="text-sm text-gray-600">Note moyenne</div>
                </div>
                <div>
                    <div class="text-3xl font-bold text-blue-600">
                        {{ $pharmacy->ratings_count }}
                    </div>
                    <div class="text-sm text-gray-600">Évaluations</div>
                </div>
                <div>
                    <div class="text-3xl font-bold text-green-600">
                        {{ $currentSchedules->count() }}
                    </div>
                    <div class="text-sm text-gray-600">Horaires à venir</div>
                </div>
            </div>
        </div>

        <div class="bg-white rounded-lg shadow-md p-6">
            <h3 class="text-lg font-bold text-gray-800 mb-4">Actions rapides</h3>
            <div class="space-y-2">
                <a href="{{ route('admin.schedules.create') }}?pharmacy_id={{ $pharmacy->id }}" class="flex items-center justify-center w-full px-4 py-2 bg-teal-600 text-white rounded hover:bg-teal-700">
                    <i class="fas fa-calendar-plus mr-2"></i>Ajouter un horaire
                </a>
                <a href="{{ route('admin.pharmacies.edit', $pharmacy->id) }}" class="flex items-center justify-center w-full px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700">
                    <i class="fas fa-edit mr-2"></i>Modifier
                </a>
            </div>
        </div>
    </div>
</div>

<!-- Horaires de garde à venir -->
<div class="bg-white rounded-lg shadow-md p-6 mb-6">
    <h3 class="text-xl font-bold text-gray-800 mb-4">Horaires de garde à venir</h3>
    @if($currentSchedules->count() > 0)
    <div class="overflow-x-auto">
        <table class="min-w-full">
            <thead class="bg-gray-50">
                <tr>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Date début</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Date fin</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Horaires</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">De garde</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Notes</th>
                </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
                @foreach($currentSchedules as $schedule)
                <tr>
                    <td class="px-6 py-4">{{ \Carbon\Carbon::parse($schedule->start_date)->format('d/m/Y') }}</td>
                    <td class="px-6 py-4">{{ \Carbon\Carbon::parse($schedule->end_date)->format('d/m/Y') }}</td>
                    <td class="px-6 py-4">
                        @if($schedule->start_time && $schedule->end_time)
                            {{ $schedule->start_time }} - {{ $schedule->end_time }}
                        @else
                            -
                        @endif
                    </td>
                    <td class="px-6 py-4">
                        <span class="px-2 py-1 text-xs rounded {{ $schedule->is_on_duty ? 'bg-green-100 text-green-800' : 'bg-gray-100 text-gray-800' }}">
                            {{ $schedule->is_on_duty ? 'Oui' : 'Non' }}
                        </span>
                    </td>
                    <td class="px-6 py-4 text-sm">{{ $schedule->notes ?? '-' }}</td>
                </tr>
                @endforeach
            </tbody>
        </table>
    </div>
    @else
    <p class="text-gray-500 text-center py-4">Aucun horaire de garde programmé</p>
    @endif
</div>

<!-- Évaluations récentes -->
<div class="bg-white rounded-lg shadow-md p-6">
    <h3 class="text-xl font-bold text-gray-800 mb-4">Évaluations récentes</h3>
    @if($recentRatings->count() > 0)
    <div class="space-y-4">
        @foreach($recentRatings as $rating)
        <div class="border-b border-gray-200 pb-4 last:border-0">
            <div class="flex justify-between items-start">
                <div>
                    <div class="flex items-center space-x-2">
                        <span class="text-yellow-500 font-bold text-lg">{{ $rating->rating }}/5</span>
                        <span class="text-gray-600">par {{ $rating->user_name ?? 'Anonyme' }}</span>
                    </div>
                    @if($rating->comment)
                    <p class="text-gray-700 mt-2">{{ $rating->comment }}</p>
                    @endif
                </div>
                <span class="text-sm text-gray-500">{{ $rating->created_at->diffForHumans() }}</span>
            </div>
        </div>
        @endforeach
    </div>
    <div class="mt-4 text-center">
        <a href="{{ route('admin.ratings') }}" class="text-teal-600 hover:text-teal-700">Voir toutes les évaluations →</a>
    </div>
    @else
    <p class="text-gray-500 text-center py-4">Aucune évaluation pour cette pharmacie</p>
    @endif
</div>
@endsection
