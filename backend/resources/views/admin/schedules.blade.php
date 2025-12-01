@extends('admin.layout-sidebar')

@section('title', 'Gestion des horaires de garde')
@section('page-title', 'Horaires de garde')

@section('content')
<div class="mb-8 flex justify-between items-center">
    <div>
        <h2 class="text-3xl font-bold text-gray-800">Horaires de garde</h2>
        <p class="text-gray-600">Gérer les horaires des pharmacies de garde</p>
    </div>
    <a href="{{ route('admin.schedules.create') }}" class="bg-teal-600 hover:bg-teal-700 text-white font-bold py-3 px-6 rounded-lg shadow-lg hover:shadow-xl transition duration-200">
        <i class="fas fa-plus mr-2"></i>Ajouter un horaire
    </a>
</div>

<!-- Filtres -->
<div class="bg-white rounded-lg shadow-md p-4 mb-6">
    <div class="flex flex-wrap gap-3">
        <a href="{{ route('admin.schedules') }}" class="px-4 py-2 rounded {{ !request('filter') ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            Tous
        </a>
        <a href="{{ route('admin.schedules', ['filter' => 'current']) }}" class="px-4 py-2 rounded {{ request('filter') === 'current' ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            En cours
        </a>
        <a href="{{ route('admin.schedules', ['filter' => 'upcoming']) }}" class="px-4 py-2 rounded {{ request('filter') === 'upcoming' ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            À venir
        </a>
        <a href="{{ route('admin.schedules', ['filter' => 'past']) }}" class="px-4 py-2 rounded {{ request('filter') === 'past' ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            Passés
        </a>
    </div>
</div>

<!-- Tableau des horaires -->
<div class="bg-white rounded-lg shadow-md overflow-hidden">
    <table class="min-w-full text-sm">
        <thead class="bg-gray-50">
            <tr>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">Pharmacie</th>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">Date début</th>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">Date fin</th>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">Horaires</th>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">De garde</th>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">Statut</th>
                <th class="px-3 py-2 text-left text-xs font-medium text-gray-500 uppercase">Actions</th>
            </tr>
        </thead>
        <tbody class="bg-white divide-y divide-gray-200">
            @forelse($schedules as $schedule)
            @php
                $now = now();
                $startDate = \Carbon\Carbon::parse($schedule->start_date);
                $endDate = \Carbon\Carbon::parse($schedule->end_date);

                if ($now->lt($startDate)) {
                    $status = 'À venir';
                    $statusClass = 'bg-blue-100 text-blue-800';
                } elseif ($now->between($startDate, $endDate)) {
                    $status = 'En cours';
                    $statusClass = 'bg-green-100 text-green-800';
                } else {
                    $status = 'Terminé';
                    $statusClass = 'bg-gray-100 text-gray-800';
                }
            @endphp
            <tr class="hover:bg-gray-50">
                <td class="px-3 py-2">
                    <a href="{{ route('admin.pharmacies.show', $schedule->pharmacy->id) }}" class="font-medium text-teal-600 hover:text-teal-800">
                        {{ $schedule->pharmacy->name }}
                    </a>
                </td>
                <td class="px-3 py-2">{{ $startDate->format('d/m/Y') }}</td>
                <td class="px-3 py-2">{{ $endDate->format('d/m/Y') }}</td>
                <td class="px-3 py-2">
                    @if($schedule->start_time && $schedule->end_time)
                        {{ $schedule->start_time }} - {{ $schedule->end_time }}
                    @else
                        <span class="text-gray-400">-</span>
                    @endif
                </td>
                <td class="px-3 py-2">
                    <span class="px-2 py-1 text-xs rounded {{ $schedule->is_on_duty ? 'bg-green-100 text-green-800' : 'bg-gray-100 text-gray-800' }}">
                        {{ $schedule->is_on_duty ? 'Oui' : 'Non' }}
                    </span>
                </td>
                <td class="px-3 py-2">
                    <span class="px-2 py-1 text-xs rounded {{ $statusClass }}">
                        {{ $status }}
                    </span>
                </td>
                <td class="px-3 py-2">
                    <div class="flex items-center space-x-2">
                        @if($schedule->notes)
                        <button onclick="alert('{{ addslashes($schedule->notes) }}')" class="text-blue-600 hover:text-blue-800 transition" title="Voir les notes">
                            <i class="fas fa-info-circle"></i>
                        </button>
                        @endif
                        <form action="{{ route('admin.schedules.delete', $schedule->id) }}" method="POST" class="inline" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cet horaire?')">
                            @csrf
                            @method('DELETE')
                            <button type="submit" class="text-red-600 hover:text-red-800 transition" title="Supprimer">
                                <i class="fas fa-trash"></i>
                            </button>
                        </form>
                    </div>
                </td>
            </tr>
            @empty
            <tr>
                <td colspan="7" class="px-3 py-4 text-center text-gray-500">Aucun horaire enregistré</td>
            </tr>
            @endforelse
        </tbody>
    </table>
</div>

<!-- Pagination -->
@if($schedules->hasPages())
<div class="mt-6">
    <div class="flex items-center justify-between">
        <div class="text-sm text-gray-600">
            Affichage de <span class="font-semibold">{{ $schedules->firstItem() }}</span> à <span class="font-semibold">{{ $schedules->lastItem() }}</span> sur <span class="font-semibold">{{ $schedules->total() }}</span> horaires
        </div>

        <nav class="flex items-center space-x-2">
            {{-- Bouton Précédent --}}
            @if ($schedules->onFirstPage())
                <span class="px-4 py-2 text-sm bg-gray-100 text-gray-400 rounded-lg cursor-not-allowed">
                    <i class="fas fa-chevron-left mr-1"></i>Précédent
                </span>
            @else
                <a href="{{ $schedules->previousPageUrl() }}" class="px-4 py-2 text-sm bg-white border border-gray-300 text-gray-700 rounded-lg hover:bg-gray-50 transition">
                    <i class="fas fa-chevron-left mr-1"></i>Précédent
                </a>
            @endif

            {{-- Numéros de page --}}
            <div class="flex items-center space-x-1">
                @foreach ($schedules->getUrlRange(1, $schedules->lastPage()) as $page => $url)
                    @if ($page == $schedules->currentPage())
                        <span class="px-3 py-2 text-sm bg-teal-600 text-white rounded-lg font-semibold">{{ $page }}</span>
                    @else
                        <a href="{{ $url }}" class="px-3 py-2 text-sm bg-white border border-gray-300 text-gray-700 rounded-lg hover:bg-gray-50 transition">{{ $page }}</a>
                    @endif
                @endforeach
            </div>

            {{-- Bouton Suivant --}}
            @if ($schedules->hasMorePages())
                <a href="{{ $schedules->nextPageUrl() }}" class="px-4 py-2 text-sm bg-white border border-gray-300 text-gray-700 rounded-lg hover:bg-gray-50 transition">
                    Suivant<i class="fas fa-chevron-right ml-1"></i>
                </a>
            @else
                <span class="px-4 py-2 text-sm bg-gray-100 text-gray-400 rounded-lg cursor-not-allowed">
                    Suivant<i class="fas fa-chevron-right ml-1"></i>
                </span>
            @endif
        </nav>
    </div>
</div>
@endif

<!-- Statistiques rapides -->
<div class="grid grid-cols-1 md:grid-cols-3 gap-6 mt-6">
    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-2xl font-bold text-blue-600">
            {{ $schedules->where('start_date', '>', now())->count() }}
        </div>
        <div class="text-gray-600">Horaires à venir</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-2xl font-bold text-green-600">
            {{ $schedules->filter(function($s) {
                return now()->between(\Carbon\Carbon::parse($s->start_date), \Carbon\Carbon::parse($s->end_date));
            })->count() }}
        </div>
        <div class="text-gray-600">Horaires en cours</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-2xl font-bold text-teal-600">
            {{ $schedules->where('is_on_duty', true)->count() }}
        </div>
        <div class="text-gray-600">Pharmacies de garde</div>
    </div>
</div>
@endsection
