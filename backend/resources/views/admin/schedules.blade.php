@extends('admin.layout')

@section('title', 'Gestion des horaires de garde')

@section('content')
<div class="mb-8 flex justify-between items-center">
    <div>
        <h2 class="text-3xl font-bold text-gray-800">Horaires de garde</h2>
        <p class="text-gray-600">Gérer les horaires des pharmacies de garde</p>
    </div>
    <a href="{{ route('admin.schedules.create') }}" class="bg-teal-600 hover:bg-teal-700 text-white font-bold py-2 px-4 rounded">
        + Ajouter un horaire
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
    <table class="min-w-full">
        <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Pharmacie</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Date début</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Date fin</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Horaires</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">De garde</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Statut</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Actions</th>
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
            <tr>
                <td class="px-6 py-4">
                    <a href="{{ route('admin.pharmacies.show', $schedule->pharmacy->id) }}" class="font-medium text-teal-600 hover:text-teal-800">
                        {{ $schedule->pharmacy->name }}
                    </a>
                </td>
                <td class="px-6 py-4">{{ $startDate->format('d/m/Y') }}</td>
                <td class="px-6 py-4">{{ $endDate->format('d/m/Y') }}</td>
                <td class="px-6 py-4">
                    @if($schedule->start_time && $schedule->end_time)
                        {{ $schedule->start_time }} - {{ $schedule->end_time }}
                    @else
                        <span class="text-gray-500">-</span>
                    @endif
                </td>
                <td class="px-6 py-4">
                    <span class="px-2 py-1 text-xs rounded {{ $schedule->is_on_duty ? 'bg-green-100 text-green-800' : 'bg-gray-100 text-gray-800' }}">
                        {{ $schedule->is_on_duty ? 'Oui' : 'Non' }}
                    </span>
                </td>
                <td class="px-6 py-4">
                    <span class="px-2 py-1 text-xs rounded {{ $statusClass }}">
                        {{ $status }}
                    </span>
                </td>
                <td class="px-6 py-4 space-x-2">
                    @if($schedule->notes)
                    <button onclick="alert('{{ addslashes($schedule->notes) }}')" class="text-blue-600 hover:text-blue-800">Notes</button>
                    @endif
                    <form action="{{ route('admin.schedules.delete', $schedule->id) }}" method="POST" class="inline" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cet horaire?')">
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="text-red-600 hover:text-red-800">Supprimer</button>
                    </form>
                </td>
            </tr>
            @empty
            <tr>
                <td colspan="7" class="px-6 py-4 text-center text-gray-500">Aucun horaire enregistré</td>
            </tr>
            @endforelse
        </tbody>
    </table>
</div>

<!-- Pagination -->
@if($schedules->hasPages())
<div class="mt-6">
    {{ $schedules->links() }}
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
