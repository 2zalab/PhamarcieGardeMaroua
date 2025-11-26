@extends('admin.layout')

@section('title', 'Collecte Pharmacies — Maroua')

@section('content')
<div class="mb-6">
    <h2 class="text-2xl font-semibold text-gray-800">Formulaire de collecte — Pharmacies (Maroua)</h2>
    <p class="mt-2 text-sm text-gray-600">Remplis le formulaire pour ajouter une pharmacie. Les champs marqués d'une * sont obligatoires.</p>
</div>

<div class="bg-white rounded-lg shadow-md p-6">
    <form id="pharmacyForm" class="space-y-4" enctype="multipart/form-data">
        @csrf

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <!-- Nom -->
            <div>
                <label for="name" class="block text-sm font-medium text-gray-700">Nom *</label>
                <input type="text" name="name" id="name" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- Ville -->
            <div>
                <label for="city" class="block text-sm font-medium text-gray-700">Ville *</label>
                <input type="text" name="city" id="city" value="Maroua" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- Adresse complète -->
            <div class="md:col-span-2">
                <label for="address" class="block text-sm font-medium text-gray-700">Adresse complète *</label>
                <input type="text" name="address" id="address" required
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- District / Quartier -->
            <div>
                <label for="district" class="block text-sm font-medium text-gray-700">District / Quartier</label>
                <input type="text" name="district" id="district"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- Téléphone principal -->
            <div>
                <label for="phone" class="block text-sm font-medium text-gray-700">Téléphone principal *</label>
                <input type="tel" name="phone" id="phone" pattern="[0-9+\s()-]{6,20}" required
                    placeholder="ex: 692316443 ou +237692316443"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- Téléphone secondaire -->
            <div>
                <label for="phone_secondary" class="block text-sm font-medium text-gray-700">Téléphone secondaire</label>
                <input type="tel" name="phone_secondary" id="phone_secondary" pattern="[0-9+\s()-]{6,20}"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- Latitude -->
            <div>
                <label for="latitude" class="block text-sm font-medium text-gray-700">Latitude</label>
                <input type="number" step="0.000001" name="latitude" id="latitude"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
            </div>

            <!-- Longitude -->
            <div>
                <label for="longitude" class="block text-sm font-medium text-gray-700">Longitude</label>
                <input type="number" step="0.000001" name="longitude" id="longitude"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent" />
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
                <div id="map" class="rounded-lg border border-gray-300" style="height: 300px;"></div>
            </div>

            <!-- Description -->
            <div class="md:col-span-2">
                <label for="description" class="block text-sm font-medium text-gray-700">Description / Services</label>
                <textarea name="description" id="description" rows="3"
                    class="mt-1 block w-full border border-gray-300 rounded-lg px-3 py-2 focus:ring-2 focus:ring-teal-500 focus:border-transparent"></textarea>
            </div>

            <!-- Image -->
            <div class="md:col-span-2">
                <label for="image" class="block text-sm font-medium text-gray-700 mb-2">Image (photo)</label>

                <!-- Aperçu image -->
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
                    hover:file:bg-teal-100" />
                <p class="text-xs text-gray-500 mt-1">Formats acceptés: JPEG, PNG, JPG, GIF (max 2MB)</p>
            </div>

            <!-- Checkboxes -->
            <div class="md:col-span-2 flex flex-wrap items-center gap-4">
                <label class="inline-flex items-center">
                    <input type="checkbox" name="has_parking" id="has_parking"
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">🅿️ Parking</span>
                </label>

                <label class="inline-flex items-center">
                    <input type="checkbox" name="has_wheelchair_access" id="has_wheelchair_access"
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">♿ Accès fauteuil roulant</span>
                </label>

                <label class="inline-flex items-center">
                    <input type="checkbox" name="is_24_hours" id="is_24_hours"
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">⏰ 24h</span>
                </label>

                <label class="inline-flex items-center">
                    <input type="checkbox" name="is_active" id="is_active" checked
                        class="w-4 h-4 text-teal-600 rounded focus:ring-teal-500">
                    <span class="ml-2 text-sm text-gray-700">✓ Actif</span>
                </label>
            </div>
        </div>

        <!-- Boutons -->
        <div class="flex justify-end space-x-3 pt-4 border-t">
            <button type="reset" class="px-6 py-2 border border-gray-300 rounded-lg text-gray-700 hover:bg-gray-50">
                Réinitialiser
            </button>
            <button type="submit" class="px-6 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700">
                ✓ Envoyer
            </button>
        </div>

        <!-- Message de retour -->
        <div id="message" class="mt-4 text-sm"></div>
    </form>
</div>

<!-- Note d'information -->
<div class="mt-6 bg-blue-50 border border-blue-200 rounded-lg p-4">
    <h4 class="text-sm font-medium text-blue-900 mb-2">📝 Note</h4>
    <p class="text-sm text-blue-800">Le formulaire envoie les données en POST vers <code class="bg-blue-100 px-1 rounded">/api/pharmacies</code> (multipart/form-data). Les données seront enregistrées dans la base de données et apparaîtront dans la liste des pharmacies.</p>
</div>

<!-- Scripts Leaflet -->
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function() {
    // Carte Leaflet
    const map = L.map('map').setView([10.595, 14.31], 13);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '© OpenStreetMap contributors'
    }).addTo(map);

    let marker = null;

    function setMarker(lat, lng) {
        if (marker) map.removeLayer(marker);
        marker = L.marker([lat, lng], {draggable: true}).addTo(map);
        marker.on('dragend', function(e) {
            const p = e.target.getLatLng();
            document.getElementById('latitude').value = p.lat.toFixed(6);
            document.getElementById('longitude').value = p.lng.toFixed(6);
        });
        map.setView([lat, lng], 16);
        document.getElementById('latitude').value = parseFloat(lat).toFixed(6);
        document.getElementById('longitude').value = parseFloat(lng).toFixed(6);
    }

    // Géolocalisation
    document.getElementById('useLocation').addEventListener('click', () => {
        if (!navigator.geolocation) {
            alert('❌ Géolocalisation non supportée par votre navigateur');
            return;
        }
        navigator.geolocation.getCurrentPosition(pos => {
            const lat = pos.coords.latitude;
            const lng = pos.coords.longitude;
            setMarker(lat, lng);
        }, err => alert('❌ Impossible d\'obtenir la position : ' + err.message));
    });

    // Choisir sur la carte
    document.getElementById('searchOnMap').addEventListener('click', () => {
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

    // Soumission via fetch (multipart)
    document.getElementById('pharmacyForm').addEventListener('submit', async function(e) {
        e.preventDefault();
        const form = e.target;
        const url = '/api/pharmacies';

        const formData = new FormData(form);
        // Normaliser les cases à cocher (valeur 0/1)
        ['has_parking', 'has_wheelchair_access', 'is_24_hours', 'is_active'].forEach(k => {
            formData.set(k, document.getElementById(k).checked ? '1' : '0');
        });

        // Afficher un loader
        const submitBtn = form.querySelector('button[type="submit"]');
        const originalText = submitBtn.innerHTML;
        submitBtn.innerHTML = '⏳ Envoi en cours...';
        submitBtn.disabled = true;

        try {
            const res = await fetch(url, {
                method: 'POST',
                body: formData,
                headers: {
                    'X-CSRF-TOKEN': document.querySelector('input[name="_token"]').value
                }
            });

            if (!res.ok) {
                const errorData = await res.json();
                throw new Error(errorData.message || errorData.error || 'Erreur lors de l\'envoi');
            }

            const data = await res.json();
            document.getElementById('message').innerHTML = '<div class="p-4 bg-green-50 border border-green-200 rounded-lg"><span class="text-green-600 font-medium">✓ Enregistrement réussi !</span><br><span class="text-sm text-green-700">La pharmacie a été ajoutée avec succès.</span></div>';

            // Réinitialiser le formulaire
            form.reset();
            if (marker) {
                map.removeLayer(marker);
                marker = null;
            }
            document.getElementById('imagePreviewContainer').classList.add('hidden');

            // Scroll vers le message
            document.getElementById('message').scrollIntoView({ behavior: 'smooth', block: 'center' });

        } catch (err) {
            document.getElementById('message').innerHTML = '<div class="p-4 bg-red-50 border border-red-200 rounded-lg"><span class="text-red-600 font-medium">✗ Erreur</span><br><span class="text-sm text-red-700">' + (err.message || err) + '</span></div>';
            document.getElementById('message').scrollIntoView({ behavior: 'smooth', block: 'center' });
        } finally {
            submitBtn.innerHTML = originalText;
            submitBtn.disabled = false;
        }
    });
});
</script>

<style>
    #map { z-index: 1; }
    .leaflet-container { font-family: inherit; }
</style>
@endsection
