@extends('admin.layout-sidebar')

@section('title', isset($pharmacy) ? 'Modifier la pharmacie' : 'Ajouter une pharmacie')
@section('page-title', isset($pharmacy) ? 'Modifier la pharmacie' : 'Ajouter une pharmacie')

@section('content')
<div class="mb-6">
    <h2 class="text-2xl font-semibold text-gray-800">{{ isset($pharmacy) ? 'Modifier la pharmacie' : 'Formulaire de collecte — Pharmacies (Maroua)' }}</h2>
    <p class="mt-2 text-sm text-gray-600">{{ isset($pharmacy) ? 'Modifier les informations de la pharmacie' : 'Remplis le formulaire pour ajouter une pharmacie. Les champs marqués d\'une * sont obligatoires.' }}</p>
</div>

<div class="bg-white rounded-lg shadow-md p-6">
    <form action="{{ isset($pharmacy) ? route('admin.pharmacies.update', $pharmacy->id) : route('admin.pharmacies.store') }}" method="POST" enctype="multipart/form-data" class="space-y-4">
        @csrf
        @if(isset($pharmacy))
            @method('PUT')
        @endif

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <!-- Nom -->
            <div>
                <label for="name" class="block text-sm font-medium text-gray-700">Nom *</label>
                <input type="text" name="name" id="name" value="{{ old('name', $pharmacy->name ?? '') }}" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('name') border-red-500 @enderror">
                @error('name')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>

            <!-- Ville -->
            <div>
                <label for="city" class="block text-sm font-medium text-gray-700">Ville *</label>
                <input type="text" name="city" id="city" value="{{ old('city', $pharmacy->city ?? 'Maroua') }}" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent">
            </div>

            <!-- Adresse complète -->
            <div class="md:col-span-2">
                <label for="address" class="block text-sm font-medium text-gray-700">Adresse complète *</label>
                <input type="text" name="address" id="address" value="{{ old('address', $pharmacy->address ?? '') }}" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('address') border-red-500 @enderror">
                @error('address')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>

            <!-- District / Quartier -->
            <div>
                <label for="district" class="block text-sm font-medium text-gray-700">District / Quartier</label>
                <input type="text" name="district" id="district" value="{{ old('district', $pharmacy->district ?? '') }}"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent">
            </div>

            <!-- Téléphone principal -->
            <div>
                <label for="phone" class="block text-sm font-medium text-gray-700">Téléphone principal *</label>
                <input type="tel" name="phone" id="phone" value="{{ old('phone', $pharmacy->phone ?? '') }}"
                    pattern="[0-9+\s()-]{6,20}" placeholder="ex: 692316443 ou +237692316443" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('phone') border-red-500 @enderror">
                @error('phone')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>

            <!-- Téléphone secondaire -->
            <div>
                <label for="phone_secondary" class="block text-sm font-medium text-gray-700">Téléphone secondaire</label>
                <input type="tel" name="phone_secondary" id="phone_secondary" value="{{ old('phone_secondary', $pharmacy->phone_secondary ?? '') }}"
                    pattern="[0-9+\s()-]{6,20}"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent">
            </div>

            <!-- Latitude -->
            <div>
                <label for="latitude" class="block text-sm font-medium text-gray-700">Latitude</label>
                <input type="number" step="0.000001" name="latitude" id="latitude" value="{{ old('latitude', $pharmacy->latitude ?? '') }}"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('latitude') border-red-500 @enderror">
                @error('latitude')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>

            <!-- Longitude -->
            <div>
                <label for="longitude" class="block text-sm font-medium text-gray-700">Longitude</label>
                <input type="number" step="0.000001" name="longitude" id="longitude" value="{{ old('longitude', $pharmacy->longitude ?? '') }}"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('longitude') border-red-500 @enderror">
                @error('longitude')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
            </div>

            <!-- Boutons de géolocalisation -->
            <div class="md:col-span-2">
                <button type="button" id="useLocation" class="inline-block px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700">
                    📍 Remplir depuis ma position
                </button>
                <button type="button" id="searchOnMap" class="inline-block ml-2 px-4 py-2 border border-gray-300 rounded-lg hover:bg-gray-50">
                    🗺️ Choisir sur la carte
                </button>
                <p class="text-xs text-gray-500 mt-2">Utilise la géolocalisation du navigateur ou place manuellement le marqueur sur la carte.</p>
            </div>

            <!-- Carte Leaflet -->
            <div class="md:col-span-2">
                <div id="map" class="rounded-lg border border-gray-300" style="height: 350px;"></div>
            </div>

            <!-- Description -->
            <div class="md:col-span-2">
                <label for="description" class="block text-sm font-medium text-gray-700">Description / Services</label>
                <textarea name="description" id="description" rows="3"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent">{{ old('description', $pharmacy->description ?? '') }}</textarea>
            </div>

            <!-- Image - APERÇU AU DÉBUT -->
            <div class="md:col-span-2">
                <label for="image" class="block text-sm font-medium text-gray-700 mb-2">Image (photo)</label>

                <!-- Aperçu actuel si modification -->
                @if(isset($pharmacy) && $pharmacy->image)
                <div class="mb-4 p-4 border border-gray-300 rounded-lg bg-gray-50">
                    <p class="text-sm font-medium text-gray-700 mb-2">Image actuelle:</p>
                    <img src="{{ asset('storage/' . $pharmacy->image) }}" alt="{{ $pharmacy->name }}"
                        class="w-48 h-48 object-cover rounded-lg border-2 border-gray-300">
                </div>
                @endif

                <!-- Aperçu nouvelle image -->
                <div id="imagePreviewContainer" class="mb-4 p-4 border border-dashed border-gray-300 rounded-lg bg-gray-50 hidden">
                    <p class="text-sm font-medium text-gray-700 mb-2">Prévisualisation:</p>
                    <img id="imagePreview" src="" alt="Prévisualisation"
                        class="w-48 h-48 object-cover rounded-lg border-2 border-teal-500">
                </div>

                <input type="file" name="image" id="image" accept="image/*"
                    class="mt-1 block w-full text-sm text-gray-500
                    file:mr-4 file:py-2 file:px-4
                    file:rounded-lg file:border-0
                    file:text-sm file:font-semibold
                    file:bg-teal-50 file:text-teal-700
                    hover:file:bg-teal-100
                    @error('image') border-red-500 @enderror">
                @error('image')
                    <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                @enderror
                <p class="text-xs text-gray-500 mt-1">Formats acceptés: JPEG, PNG, JPG, GIF (max 2MB)</p>
            </div>

            <!-- Checkboxes -->
            <div class="md:col-span-2 flex flex-wrap items-center gap-4">
                <label class="inline-flex items-center">
                    <input type="checkbox" name="has_parking" id="has_parking" value="1"
                        {{ old('has_parking', $pharmacy->has_parking ?? false) ? 'checked' : '' }}
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">🅿️ Parking</span>
                </label>

                <label class="inline-flex items-center">
                    <input type="checkbox" name="has_wheelchair_access" id="has_wheelchair_access" value="1"
                        {{ old('has_wheelchair_access', $pharmacy->has_wheelchair_access ?? false) ? 'checked' : '' }}
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">♿ Accès fauteuil roulant</span>
                </label>

                <label class="inline-flex items-center">
                    <input type="checkbox" name="is_24_hours" id="is_24_hours" value="1"
                        {{ old('is_24_hours', $pharmacy->is_24_hours ?? false) ? 'checked' : '' }}
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">⏰ 24h</span>
                </label>

                @if(isset($pharmacy))
                <label class="inline-flex items-center">
                    <input type="checkbox" name="is_active" id="is_active" value="1"
                        {{ old('is_active', $pharmacy->is_active ?? true) ? 'checked' : '' }}
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">✓ Actif</span>
                </label>
                @endif
            </div>
        </div>

        <!-- Boutons -->
        <div class="flex justify-end space-x-3 pt-4 border-t">
            <a href="{{ route('admin.pharmacies') }}" class="px-6 py-2 border border-gray-300 rounded-lg text-gray-700 hover:bg-gray-50 flex items-center">
                <i class="fas fa-times mr-2"></i>Annuler
            </a>
            <button type="submit" class="px-6 py-2 bg-teal-600 text-white rounded-lg hover:bg-teal-700 flex items-center">
                <i class="fas fa-{{ isset($pharmacy) ? 'save' : 'check' }} mr-2"></i>{{ isset($pharmacy) ? 'Mettre à jour' : 'Enregistrer' }}
            </button>
        </div>
    </form>
</div>

<!-- Scripts Leaflet -->
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function() {
    // Initialiser la carte Leaflet (Maroua par défaut)
    const defaultLat = {{ isset($pharmacy) ? $pharmacy->latitude : '10.595' }};
    const defaultLng = {{ isset($pharmacy) ? $pharmacy->longitude : '14.31' }};

    const map = L.map('map').setView([defaultLat, defaultLng], {{ isset($pharmacy) ? '16' : '13' }});

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '© OpenStreetMap contributors'
    }).addTo(map);

    let marker = null;

    // Fonction pour placer/déplacer le marqueur
    function setMarker(lat, lng) {
        if (marker) {
            map.removeLayer(marker);
        }
        marker = L.marker([lat, lng], {draggable: true}).addTo(map);

        // Mettre à jour les champs quand le marqueur est déplacé
        marker.on('dragend', function(e) {
            const pos = e.target.getLatLng();
            document.getElementById('latitude').value = pos.lat.toFixed(6);
            document.getElementById('longitude').value = pos.lng.toFixed(6);
        });

        map.setView([lat, lng], 16);
        document.getElementById('latitude').value = parseFloat(lat).toFixed(6);
        document.getElementById('longitude').value = parseFloat(lng).toFixed(6);
    }

    // Si on est en mode édition et qu'il y a des coordonnées, placer le marqueur
    @if(isset($pharmacy) && $pharmacy->latitude && $pharmacy->longitude)
        setMarker({{ $pharmacy->latitude }}, {{ $pharmacy->longitude }});
    @endif

    // Bouton géolocalisation
    document.getElementById('useLocation').addEventListener('click', function() {
        if (!navigator.geolocation) {
            alert('❌ Géolocalisation non supportée par votre navigateur');
            return;
        }

        navigator.geolocation.getCurrentPosition(
            function(position) {
                const lat = position.coords.latitude;
                const lng = position.coords.longitude;
                setMarker(lat, lng);
            },
            function(error) {
                alert('❌ Impossible d\'obtenir la position: ' + error.message);
            }
        );
    });

    // Bouton choisir sur la carte
    document.getElementById('searchOnMap').addEventListener('click', function() {
        alert('📍 Cliquez sur la carte pour placer le marqueur à l\'emplacement de la pharmacie.');
        map.once('click', function(e) {
            setMarker(e.latlng.lat, e.latlng.lng);
        });
    });

    // Prévisualisation de l'image
    document.getElementById('image').addEventListener('change', function(e) {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(event) {
                document.getElementById('imagePreview').src = event.target.result;
                document.getElementById('imagePreviewContainer').classList.remove('hidden');
            };
            reader.readAsDataURL(file);
        }
    });
});
</script>

<style>
    #map { z-index: 1; }
    .leaflet-container { font-family: inherit; }
</style>
@endsection
