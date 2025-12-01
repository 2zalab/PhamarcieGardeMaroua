@extends('admin.layout-sidebar')

@section('title', 'Ajouter un horaire de garde')
@section('page-title', 'Ajouter un horaire de garde')

@section('content')
<div class="mb-8">
    <h2 class="text-3xl font-bold text-gray-800">Ajouter un horaire de garde</h2>
    <p class="text-gray-600">Planifier les horaires de garde des pharmacies</p>
</div>

<div class="bg-white rounded-lg shadow-md p-6">
    <form action="{{ route('admin.schedules.store') }}" method="POST">
        @csrf

        <!-- Sélection de la pharmacie -->
        <div class="mb-6">
            <label for="pharmacy_id" class="block text-sm font-medium text-gray-700 mb-2">Pharmacie *</label>
            <select name="pharmacy_id" id="pharmacy_id"
                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('pharmacy_id') border-red-500 @enderror"
                required>
                <option value="">Sélectionnez une pharmacie</option>
                @foreach($pharmacies as $pharmacy)
                    <option value="{{ $pharmacy->id }}" {{ old('pharmacy_id', request('pharmacy_id')) == $pharmacy->id ? 'selected' : '' }}>
                        {{ $pharmacy->name }} - {{ $pharmacy->district ?? 'Sans quartier' }}
                    </option>
                @endforeach
            </select>
            @error('pharmacy_id')
                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
            @enderror
        </div>

        <!-- Dates -->
        <div class="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
            <div>
                <label for="start_date" class="block text-sm font-medium text-gray-700 mb-2">Date de début *</label>
                <input type="date" name="start_date" id="start_date"
                    value="{{ old('start_date') }}"
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('start_date') border-red-500 @enderror"
                    required>
                @error('start_date')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>

            <div>
                <label for="end_date" class="block text-sm font-medium text-gray-700 mb-2">Date de fin *</label>
                <input type="date" name="end_date" id="end_date"
                    value="{{ old('end_date') }}"
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('end_date') border-red-500 @enderror"
                    required>
                @error('end_date')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>
        </div>

        <!-- Horaires optionnels -->
        <div class="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
            <div>
                <label for="start_time" class="block text-sm font-medium text-gray-700 mb-2">Heure de début (optionnel)</label>
                <input type="time" name="start_time" id="start_time"
                    value="{{ old('start_time') }}"
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent">
                <p class="text-xs text-gray-500 mt-1">Laisser vide si horaire non spécifique</p>
            </div>

            <div>
                <label for="end_time" class="block text-sm font-medium text-gray-700 mb-2">Heure de fin (optionnel)</label>
                <input type="time" name="end_time" id="end_time"
                    value="{{ old('end_time') }}"
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent">
                <p class="text-xs text-gray-500 mt-1">Laisser vide si horaire non spécifique</p>
            </div>
        </div>

        <!-- De garde -->
        <div class="mb-6">
            <label class="flex items-center">
                <input type="checkbox" name="is_on_duty" id="is_on_duty" value="1"
                    {{ old('is_on_duty', true) ? 'checked' : '' }}
                    class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                <span class="ml-2 text-sm font-medium text-gray-700">Cette pharmacie est de garde durant cette période</span>
            </label>
            <p class="text-xs text-gray-500 mt-1">Cochez cette case pour indiquer que la pharmacie sera de garde</p>
        </div>

        <!-- Notes -->
        <div class="mb-6">
            <label for="notes" class="block text-sm font-medium text-gray-700 mb-2">Notes (optionnel)</label>
            <textarea name="notes" id="notes" rows="3"
                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent"
                placeholder="Informations complémentaires...">{{ old('notes') }}</textarea>
            <p class="text-xs text-gray-500 mt-1">Ajoutez des notes si nécessaire (ex: horaires spéciaux, fermeture exceptionnelle...)</p>
        </div>

        <!-- Boutons -->
        <div class="flex justify-end space-x-4">
            <a href="{{ route('admin.schedules') }}" class="px-6 py-2 border border-gray-300 rounded-lg text-gray-700 hover:bg-gray-50 flex items-center">
                <i class="fas fa-times mr-2"></i>Annuler
            </a>
            <button type="submit" class="px-6 py-2 bg-teal-600 text-white rounded-lg hover:bg-teal-700 flex items-center">
                <i class="fas fa-check mr-2"></i>Créer l'horaire
            </button>
        </div>
    </form>
</div>

<!-- Aide et conseils -->
<div class="mt-6 grid grid-cols-1 md:grid-cols-2 gap-6">
    <div class="bg-blue-50 border border-blue-200 rounded-lg p-4">
        <h4 class="text-sm font-medium text-blue-900 mb-2">💡 Horaires de garde</h4>
        <p class="text-sm text-blue-800">Les pharmacies de garde assurent un service continu pendant les périodes de fermeture des autres pharmacies (nuits, weekends, jours fériés).</p>
    </div>

    <div class="bg-yellow-50 border border-yellow-200 rounded-lg p-4">
        <h4 class="text-sm font-medium text-yellow-900 mb-2">⚠️ Important</h4>
        <p class="text-sm text-yellow-800">Assurez-vous qu'au moins une pharmacie soit de garde à tout moment pour garantir la continuité du service.</p>
    </div>
</div>

<script>
// Auto-remplir l'heure de fin si l'heure de début est renseignée
document.getElementById('start_time').addEventListener('change', function() {
    const endTimeInput = document.getElementById('end_time');
    if (!endTimeInput.value && this.value) {
        // Si on met 20:00 en début, on suggère 08:00 le lendemain
        if (this.value >= '20:00') {
            endTimeInput.value = '08:00';
        }
    }
});

// Validation: la date de fin doit être >= date de début
document.getElementById('end_date').addEventListener('change', function() {
    const startDate = document.getElementById('start_date').value;
    if (startDate && this.value < startDate) {
        alert('La date de fin doit être postérieure ou égale à la date de début');
        this.value = startDate;
    }
});
</script>
@endsection
