@extends('admin.layout-sidebar')

@section('title', 'Gestion des pharmacies')
@section('page-title', 'Pharmacies')

@section('content')
<div class="mb-8 flex justify-between items-center">
    <div>
        <h2 class="text-3xl font-bold text-gray-800">Pharmacies</h2>
        <p class="text-gray-600">Gérer les pharmacies de Maroua</p>
    </div>
    <a href="{{ route('admin.pharmacies.create') }}" class="bg-teal-600 hover:bg-teal-700 text-white font-bold py-3 px-6 rounded-lg shadow-lg hover:shadow-xl transition duration-200">
        <i class="fas fa-plus mr-2"></i>Ajouter une pharmacie
    </a>
</div>

<div class="bg-white rounded-lg shadow-md overflow-hidden">
    <table class="min-w-full">
        <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Image</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Nom</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Téléphone</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Quartier</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Note</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Status</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Actions</th>
            </tr>
        </thead>
        <tbody class="bg-white divide-y divide-gray-200">
            @forelse($pharmacies as $pharmacy)
            <tr>
                <td class="px-6 py-4">
                    <img src="{{ $pharmacy->image ? asset('storage/' . $pharmacy->image) : asset('images/pharmacy-default.png') }}"
                        alt="{{ $pharmacy->name }}"
                        class="w-16 h-16 object-cover rounded-lg">
                </td>
                <td class="px-6 py-4 font-medium">{{ $pharmacy->name }}</td>
                <td class="px-6 py-4">{{ $pharmacy->phone }}</td>
                <td class="px-6 py-4">{{ $pharmacy->district ?? '-' }}</td>
                <td class="px-6 py-4">
                    <span class="text-yellow-500">
                        {{ round($pharmacy->ratings_avg_rating ?? 0, 1) }}/5
                    </span>
                    <span class="text-gray-500 text-sm">({{ $pharmacy->ratings_count }})</span>
                </td>
                <td class="px-6 py-4">
                    <span class="px-2 py-1 text-xs rounded {{ $pharmacy->is_active ? 'bg-green-100 text-green-800' : 'bg-red-100 text-red-800' }}">
                        {{ $pharmacy->is_active ? 'Active' : 'Inactive' }}
                    </span>
                </td>
                <td class="px-6 py-4">
                    <div class="flex items-center space-x-3">
                        <a href="{{ route('admin.pharmacies.show', $pharmacy->id) }}" class="text-teal-600 hover:text-teal-800 transition" title="Voir les détails">
                            <i class="fas fa-eye text-lg"></i>
                        </a>
                        <a href="{{ route('admin.pharmacies.edit', $pharmacy->id) }}" class="text-blue-600 hover:text-blue-800 transition" title="Modifier">
                            <i class="fas fa-edit text-lg"></i>
                        </a>
                        <form action="{{ route('admin.pharmacies.delete', $pharmacy->id) }}" method="POST" class="inline" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cette pharmacie?')">
                            @csrf
                            @method('DELETE')
                            <button type="submit" class="text-red-600 hover:text-red-800 transition" title="Supprimer">
                                <i class="fas fa-trash text-lg"></i>
                            </button>
                        </form>
                    </div>
                </td>
            </tr>
            @empty
            <tr>
                <td colspan="7" class="px-6 py-4 text-center text-gray-500">Aucune pharmacie</td>
            </tr>
            @endforelse
        </tbody>
    </table>
</div>
@endsection
