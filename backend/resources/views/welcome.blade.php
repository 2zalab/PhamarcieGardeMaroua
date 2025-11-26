<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacie de Garde Maroua - API</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-teal-50 to-green-50">
    <div class="min-h-screen flex items-center justify-center p-4">
        <div class="max-w-4xl w-full">
            <!-- Header -->
            <div class="text-center mb-12">
                <div class="inline-flex items-center justify-center w-20 h-20 bg-teal-600 rounded-full mb-4">
                    <svg class="w-12 h-12 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19.428 15.428a2 2 0 00-1.022-.547l-2.387-.477a6 6 0 00-3.86.517l-.318.158a6 6 0 01-3.86.517L6.05 15.21a2 2 0 00-1.806.547M8 4h8l-1 1v5.172a2 2 0 00.586 1.414l5 5c1.26 1.26.367 3.414-1.415 3.414H4.828c-1.782 0-2.674-2.154-1.414-3.414l5-5A2 2 0 009 10.172V5L8 4z"></path>
                    </svg>
                </div>
                <h1 class="text-4xl font-bold text-gray-800 mb-2">Pharmacie de Garde Maroua</h1>
                <p class="text-xl text-gray-600">API REST - Version 2.0.0</p>
            </div>

            <!-- API Info Card -->
            <div class="bg-white rounded-2xl shadow-xl p-8 mb-6">
                <h2 class="text-2xl font-bold text-gray-800 mb-6">📡 Endpoints Disponibles</h2>

                <div class="space-y-4">
                    <!-- Endpoint Item -->
                    <div class="border-l-4 border-teal-500 pl-4 py-2">
                        <div class="flex items-center justify-between">
                            <div>
                                <span class="inline-block bg-green-100 text-green-800 text-xs font-semibold px-2 py-1 rounded">GET</span>
                                <code class="ml-2 text-gray-700 font-mono">/api/pharmacies</code>
                            </div>
                            <a href="/api/pharmacies" class="text-teal-600 hover:text-teal-800 text-sm">Tester →</a>
                        </div>
                        <p class="text-sm text-gray-600 mt-1">Liste de toutes les pharmacies</p>
                    </div>

                    <div class="border-l-4 border-teal-500 pl-4 py-2">
                        <div class="flex items-center justify-between">
                            <div>
                                <span class="inline-block bg-green-100 text-green-800 text-xs font-semibold px-2 py-1 rounded">GET</span>
                                <code class="ml-2 text-gray-700 font-mono">/api/pharmacies/on-duty</code>
                            </div>
                            <a href="/api/pharmacies/on-duty" class="text-teal-600 hover:text-teal-800 text-sm">Tester →</a>
                        </div>
                        <p class="text-sm text-gray-600 mt-1">Pharmacies de garde actuellement</p>
                    </div>

                    <div class="border-l-4 border-teal-500 pl-4 py-2">
                        <div class="flex items-center justify-between">
                            <div>
                                <span class="inline-block bg-green-100 text-green-800 text-xs font-semibold px-2 py-1 rounded">GET</span>
                                <code class="ml-2 text-gray-700 font-mono">/api/pharmacies/nearby</code>
                            </div>
                        </div>
                        <p class="text-sm text-gray-600 mt-1">Pharmacies à proximité (params: latitude, longitude, radius)</p>
                    </div>

                    <div class="border-l-4 border-teal-500 pl-4 py-2">
                        <div class="flex items-center justify-between">
                            <div>
                                <span class="inline-block bg-green-100 text-green-800 text-xs font-semibold px-2 py-1 rounded">GET</span>
                                <code class="ml-2 text-gray-700 font-mono">/api/pharmacies/{id}</code>
                            </div>
                        </div>
                        <p class="text-sm text-gray-600 mt-1">Détails d'une pharmacie</p>
                    </div>

                    <div class="border-l-4 border-blue-500 pl-4 py-2">
                        <div class="flex items-center justify-between">
                            <div>
                                <span class="inline-block bg-green-100 text-green-800 text-xs font-semibold px-2 py-1 rounded">GET</span>
                                <code class="ml-2 text-gray-700 font-mono">/api/pharmacies/{id}/ratings</code>
                            </div>
                        </div>
                        <p class="text-sm text-gray-600 mt-1">Évaluations d'une pharmacie</p>
                    </div>

                    <div class="border-l-4 border-orange-500 pl-4 py-2">
                        <div class="flex items-center justify-between">
                            <div>
                                <span class="inline-block bg-blue-100 text-blue-800 text-xs font-semibold px-2 py-1 rounded">POST</span>
                                <code class="ml-2 text-gray-700 font-mono">/api/pharmacies/{id}/ratings</code>
                            </div>
                        </div>
                        <p class="text-sm text-gray-600 mt-1">Ajouter une évaluation</p>
                    </div>
                </div>
            </div>

            <!-- Admin Panel Card -->
            <div class="bg-gradient-to-r from-teal-600 to-green-600 rounded-2xl shadow-xl p-8 text-white">
                <div class="flex items-center justify-between">
                    <div>
                        <h3 class="text-2xl font-bold mb-2">🎛️ Panel d'Administration</h3>
                        <p class="text-teal-100">Gérer les pharmacies, horaires et évaluations</p>
                    </div>
                    <a href="/admin" class="bg-white text-teal-600 px-6 py-3 rounded-lg font-semibold hover:bg-teal-50 transition">
                        Accéder →
                    </a>
                </div>
            </div>

            <!-- Footer -->
            <div class="text-center mt-8 text-gray-600">
                <p class="mb-2">🏥 Développé avec ❤️ pour les habitants de Maroua</p>
                <p class="text-sm">Version 2.0.0 • Laravel {{ app()->version() }}</p>
            </div>
        </div>
    </div>
</body>
</html>
