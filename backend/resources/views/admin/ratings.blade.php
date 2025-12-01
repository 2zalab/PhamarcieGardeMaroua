@extends('admin.layout-sidebar')

@section('title', 'Gestion des évaluations')
@section('page-title', 'Évaluations')

@section('content')
<div class="mb-8">
    <div>
        <h2 class="text-3xl font-bold text-gray-800">Évaluations</h2>
        <p class="text-gray-600">Gérer les avis et évaluations des pharmacies</p>
    </div>
</div>

<!-- Statistiques globales -->
<div class="grid grid-cols-1 md:grid-cols-4 gap-6 mb-6">
    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-blue-600">{{ $ratings->total() }}</div>
        <div class="text-gray-600">Total évaluations</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-yellow-600">
            {{ $ratings->count() > 0 ? round($ratings->avg('rating'), 1) : 0 }}/5
        </div>
        <div class="text-gray-600">Note moyenne</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-green-600">
            {{ $ratings->where('rating', '>=', 4)->count() }}
        </div>
        <div class="text-gray-600">Avis positifs (4-5)</div>
    </div>

    <div class="bg-white rounded-lg shadow-md p-6">
        <div class="text-3xl font-bold text-red-600">
            {{ $ratings->where('rating', '<=', 2)->count() }}
        </div>
        <div class="text-gray-600">Avis négatifs (1-2)</div>
    </div>
</div>

<!-- Filtres -->
<div class="bg-white rounded-lg shadow-md p-4 mb-6">
    <div class="flex flex-wrap gap-3">
        <a href="{{ route('admin.ratings') }}" class="px-4 py-2 rounded {{ !request('rating') ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            Tous
        </a>
        <a href="{{ route('admin.ratings', ['rating' => 5]) }}" class="px-4 py-2 rounded {{ request('rating') == 5 ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            ⭐ 5 étoiles
        </a>
        <a href="{{ route('admin.ratings', ['rating' => 4]) }}" class="px-4 py-2 rounded {{ request('rating') == 4 ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            ⭐ 4 étoiles
        </a>
        <a href="{{ route('admin.ratings', ['rating' => 3]) }}" class="px-4 py-2 rounded {{ request('rating') == 3 ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            ⭐ 3 étoiles
        </a>
        <a href="{{ route('admin.ratings', ['rating' => 2]) }}" class="px-4 py-2 rounded {{ request('rating') == 2 ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            ⭐ 2 étoiles
        </a>
        <a href="{{ route('admin.ratings', ['rating' => 1]) }}" class="px-4 py-2 rounded {{ request('rating') == 1 ? 'bg-teal-600 text-white' : 'bg-gray-200 text-gray-700 hover:bg-gray-300' }}">
            ⭐ 1 étoile
        </a>
    </div>
</div>

<!-- Liste des évaluations -->
<div class="bg-white rounded-lg shadow-md overflow-hidden">
    <table class="min-w-full">
        <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Pharmacie</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Note</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Utilisateur</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Commentaire</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Date</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Actions</th>
            </tr>
        </thead>
        <tbody class="bg-white divide-y divide-gray-200">
            @forelse($ratings as $rating)
            <tr class="{{ $rating->rating <= 2 ? 'bg-red-50' : '' }}">
                <td class="px-6 py-4">
                    <a href="{{ route('admin.pharmacies.show', $rating->pharmacy->id) }}" class="font-medium text-teal-600 hover:text-teal-800">
                        {{ $rating->pharmacy->name }}
                    </a>
                </td>
                <td class="px-6 py-4">
                    <div class="flex items-center">
                        <span class="text-2xl font-bold {{ $rating->rating >= 4 ? 'text-green-600' : ($rating->rating == 3 ? 'text-yellow-600' : 'text-red-600') }}">
                            {{ $rating->rating }}
                        </span>
                        <span class="text-gray-500 ml-1">/5</span>
                    </div>
                    <div class="text-yellow-500 text-sm">
                        {{ str_repeat('⭐', $rating->rating) }}{{ str_repeat('☆', 5 - $rating->rating) }}
                    </div>
                </td>
                <td class="px-6 py-4">
                    <div class="font-medium">{{ $rating->user_name ?? 'Anonyme' }}</div>
                    @if($rating->user_phone)
                    <div class="text-sm text-gray-500">{{ $rating->user_phone }}</div>
                    @endif
                </td>
                <td class="px-6 py-4">
                    @if($rating->comment)
                    <div class="max-w-md">
                        <p class="text-sm text-gray-900">{{ Str::limit($rating->comment, 100) }}</p>
                        @if(strlen($rating->comment) > 100)
                        <button onclick="alert('{{ addslashes($rating->comment) }}')" class="text-teal-600 text-xs hover:text-teal-800 mt-1 flex items-center" title="Lire le commentaire complet">
                            <i class="fas fa-arrow-right mr-1"></i>Lire plus
                        </button>
                        @endif
                    </div>
                    @else
                    <span class="text-gray-500 text-sm">Aucun commentaire</span>
                    @endif
                </td>
                <td class="px-6 py-4">
                    <div class="text-sm">{{ $rating->created_at->format('d/m/Y') }}</div>
                    <div class="text-xs text-gray-500">{{ $rating->created_at->format('H:i') }}</div>
                    <div class="text-xs text-gray-400">{{ $rating->created_at->diffForHumans() }}</div>
                </td>
                <td class="px-6 py-4">
                    <form action="{{ route('admin.ratings.delete', $rating->id) }}" method="POST" class="inline" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cette évaluation?')">
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="text-red-600 hover:text-red-800 transition" title="Supprimer">
                            <i class="fas fa-trash text-lg"></i>
                        </button>
                    </form>
                </td>
            </tr>
            @empty
            <tr>
                <td colspan="6" class="px-6 py-8 text-center text-gray-500">
                    <div class="text-4xl mb-2">📝</div>
                    <p>Aucune évaluation trouvée</p>
                </td>
            </tr>
            @endforelse
        </tbody>
    </table>
</div>

<!-- Pagination -->
@if($ratings->hasPages())
<div class="mt-6">
    {{ $ratings->links() }}
</div>
@endif

<!-- Graphique de distribution des notes -->
<div class="mt-6 bg-white rounded-lg shadow-md p-6">
    <h3 class="text-xl font-bold text-gray-800 mb-4">Distribution des notes</h3>

    @php
        $totalRatings = $ratings->total();
        $ratingCounts = [
            5 => $ratings->where('rating', 5)->count(),
            4 => $ratings->where('rating', 4)->count(),
            3 => $ratings->where('rating', 3)->count(),
            2 => $ratings->where('rating', 2)->count(),
            1 => $ratings->where('rating', 1)->count(),
        ];
    @endphp

    <div class="space-y-3">
        @foreach([5, 4, 3, 2, 1] as $star)
            @php
                $count = $ratingCounts[$star];
                $percentage = $totalRatings > 0 ? ($count / $totalRatings) * 100 : 0;
            @endphp
            <div class="flex items-center">
                <div class="w-20 text-sm font-medium">{{ $star }} étoiles</div>
                <div class="flex-1 mx-4">
                    <div class="bg-gray-200 rounded-full h-4 overflow-hidden">
                        <div class="h-full {{ $star >= 4 ? 'bg-green-500' : ($star == 3 ? 'bg-yellow-500' : 'bg-red-500') }}"
                             style="width: {{ $percentage }}%"></div>
                    </div>
                </div>
                <div class="w-16 text-sm text-gray-600 text-right">
                    {{ $count }} ({{ round($percentage, 1) }}%)
                </div>
            </div>
        @endforeach
    </div>
</div>
@endsection
