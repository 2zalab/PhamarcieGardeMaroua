<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentation API - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-50">
    <!-- Navigation -->
    <nav class="bg-white shadow-lg">
        <div class="container mx-auto px-4 py-4">
            <div class="flex justify-between items-center">
                <a href="/" class="flex items-center space-x-3">
                    <div class="bg-gradient-to-br from-teal-600 to-green-600 rounded-xl p-2">
                        <i class="fas fa-pills text-xl text-white"></i>
                    </div>
                    <span class="text-xl font-bold text-gray-800">Pharmacie de Garde</span>
                </a>
                <a href="/" class="text-gray-700 hover:text-teal-600">
                    <i class="fas fa-arrow-left mr-2"></i>Retour à l'accueil
                </a>
            </div>
        </div>
    </nav>

    <div class="container mx-auto px-4 py-12">
        <!-- Header -->
        <div class="text-center mb-12">
            <h1 class="text-5xl font-bold text-gray-800 mb-4">Documentation API</h1>
            <p class="text-xl text-gray-600">API REST pour accéder aux données des pharmacies de garde</p>
            <div class="mt-4 inline-flex items-center bg-teal-100 text-teal-800 px-4 py-2 rounded-lg">
                <i class="fas fa-link mr-2"></i>
                <span class="font-mono text-sm">Base URL: {{ url('/api') }}</span>
            </div>
        </div>

        <!-- Authentication Notice -->
        <div class="bg-yellow-50 border-l-4 border-yellow-400 p-6 rounded-r-lg mb-8">
            <div class="flex">
                <i class="fas fa-exclamation-triangle text-yellow-400 text-2xl mr-4"></i>
                <div>
                    <h3 class="font-bold text-yellow-800 mb-2">Authentification</h3>
                    <p class="text-yellow-700">
                        Certains endpoints nécessitent une authentification via token Bearer. 
                        Les endpoints publics sont accessibles sans authentification.
                    </p>
                </div>
            </div>
        </div>

        <!-- Endpoints -->
        <div class="space-y-8">
            <!-- Pharmacies Section -->
            <div class="bg-white rounded-2xl shadow-lg p-8">
                <h2 class="text-3xl font-bold text-gray-800 mb-6 flex items-center">
                    <i class="fas fa-hospital text-teal-600 mr-3"></i>
                    Pharmacies
                </h2>

                <!-- GET /pharmacies -->
                <div class="mb-8 border-l-4 border-green-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/pharmacies</code>
                    </div>
                    <p class="text-gray-600 mb-4">Récupérer la liste de toutes les pharmacies</p>
                    
                    <div class="bg-gray-50 rounded-lg p-4">
                        <p class="text-sm font-semibold text-gray-700 mb-2">Réponse (200 OK):</p>
                        <pre class="text-xs bg-gray-800 text-green-400 p-4 rounded overflow-x-auto"><code>{
  "success": true,
  "data": [
    {
      "id": 1,
      "name": "Pharmacie Centrale",
      "address": "Avenue Hassan II",
      "phone": "+237 699 99 99 99",
      "latitude": 10.5897,
      "longitude": 14.3154,
      "district": "Domayo",
      "is_active": true,
      "is_24_hours": false,
      "average_rating": 4.5,
      "ratings_count": 12
    }
  ]
}</code></pre>
                    </div>
                </div>

                <!-- GET /pharmacies/on-duty -->
                <div class="mb-8 border-l-4 border-blue-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/pharmacies/on-duty</code>
                    </div>
                    <p class="text-gray-600 mb-4">Récupérer les pharmacies de garde actuellement ouvertes</p>
                    
                    <div class="bg-gray-50 rounded-lg p-4">
                        <p class="text-sm font-semibold text-gray-700 mb-2">Réponse (200 OK):</p>
                        <pre class="text-xs bg-gray-800 text-green-400 p-4 rounded overflow-x-auto"><code>{
  "success": true,
  "data": [...]
}</code></pre>
                    </div>
                </div>

                <!-- GET /pharmacies/nearby -->
                <div class="mb-8 border-l-4 border-purple-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/pharmacies/nearby</code>
                    </div>
                    <p class="text-gray-600 mb-4">Trouver les pharmacies à proximité d'une position</p>
                    
                    <div class="bg-blue-50 rounded-lg p-4 mb-4">
                        <p class="text-sm font-semibold text-blue-900 mb-2">Paramètres (Query):</p>
                        <ul class="text-sm text-blue-800 space-y-1">
                            <li><code class="bg-white px-2 py-1 rounded">latitude</code> - Latitude (required)</li>
                            <li><code class="bg-white px-2 py-1 rounded">longitude</code> - Longitude (required)</li>
                            <li><code class="bg-white px-2 py-1 rounded">radius</code> - Rayon en km (optional, default: 10)</li>
                        </ul>
                    </div>

                    <div class="bg-gray-50 rounded-lg p-4">
                        <p class="text-sm font-semibold text-gray-700 mb-2">Exemple:</p>
                        <code class="text-xs bg-gray-800 text-green-400 p-3 rounded block overflow-x-auto">
                            GET /api/pharmacies/nearby?latitude=10.5897&longitude=14.3154&radius=5
                        </code>
                    </div>
                </div>

                <!-- GET /pharmacies/{id} -->
                <div class="border-l-4 border-orange-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/pharmacies/{id}</code>
                    </div>
                    <p class="text-gray-600 mb-4">Récupérer les détails d'une pharmacie spécifique</p>
                </div>
            </div>

            <!-- Schedules Section -->
            <div class="bg-white rounded-2xl shadow-lg p-8">
                <h2 class="text-3xl font-bold text-gray-800 mb-6 flex items-center">
                    <i class="fas fa-calendar-alt text-blue-600 mr-3"></i>
                    Calendrier des Gardes
                </h2>

                <!-- GET /schedules/day/{date} -->
                <div class="mb-8 border-l-4 border-green-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/schedules/day/{date}</code>
                    </div>
                    <p class="text-gray-600 mb-4">Pharmacies de garde pour un jour spécifique</p>
                    
                    <div class="bg-gray-50 rounded-lg p-4">
                        <p class="text-sm font-semibold text-gray-700 mb-2">Exemple:</p>
                        <code class="text-xs bg-gray-800 text-green-400 p-3 rounded block">
                            GET /api/schedules/day/2025-11-28
                        </code>
                    </div>
                </div>

                <!-- GET /schedules/week/{date} -->
                <div class="mb-8 border-l-4 border-blue-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/schedules/week/{date}</code>
                    </div>
                    <p class="text-gray-600 mb-4">Pharmacies de garde pour une semaine</p>
                </div>

                <!-- GET /schedules/month/{year}/{month} -->
                <div class="border-l-4 border-purple-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/schedules/month/{year}/{month}</code>
                    </div>
                    <p class="text-gray-600 mb-4">Pharmacies de garde pour un mois</p>
                    
                    <div class="bg-gray-50 rounded-lg p-4">
                        <p class="text-sm font-semibold text-gray-700 mb-2">Exemple:</p>
                        <code class="text-xs bg-gray-800 text-green-400 p-3 rounded block">
                            GET /api/schedules/month/2025/11
                        </code>
                    </div>
                </div>
            </div>

            <!-- Ratings Section -->
            <div class="bg-white rounded-2xl shadow-lg p-8">
                <h2 class="text-3xl font-bold text-gray-800 mb-6 flex items-center">
                    <i class="fas fa-star text-yellow-500 mr-3"></i>
                    Évaluations
                </h2>

                <!-- GET /pharmacies/{id}/ratings -->
                <div class="mb-8 border-l-4 border-green-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-green-100 text-green-800 text-sm font-bold px-3 py-1 rounded mr-3">GET</span>
                        <code class="text-lg font-mono text-gray-800">/api/pharmacies/{id}/ratings</code>
                    </div>
                    <p class="text-gray-600 mb-4">Récupérer toutes les évaluations d'une pharmacie</p>
                </div>

                <!-- POST /pharmacies/{id}/ratings -->
                <div class="border-l-4 border-blue-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-blue-100 text-blue-800 text-sm font-bold px-3 py-1 rounded mr-3">POST</span>
                        <code class="text-lg font-mono text-gray-800">/api/pharmacies/{id}/ratings</code>
                        <span class="ml-2 bg-red-100 text-red-800 text-xs px-2 py-1 rounded">Auth Required</span>
                    </div>
                    <p class="text-gray-600 mb-4">Ajouter une évaluation pour une pharmacie</p>
                    
                    <div class="bg-blue-50 rounded-lg p-4 mb-4">
                        <p class="text-sm font-semibold text-blue-900 mb-2">Corps de la requête (JSON):</p>
                        <pre class="text-xs bg-gray-800 text-green-400 p-4 rounded overflow-x-auto"><code>{
  "rating": 5,
  "comment": "Excellent service!"
}</code></pre>
                    </div>
                </div>
            </div>

            <!-- Authentication Section -->
            <div class="bg-white rounded-2xl shadow-lg p-8">
                <h2 class="text-3xl font-bold text-gray-800 mb-6 flex items-center">
                    <i class="fas fa-lock text-red-600 mr-3"></i>
                    Authentification
                </h2>

                <!-- POST /auth/login -->
                <div class="mb-8 border-l-4 border-blue-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-blue-100 text-blue-800 text-sm font-bold px-3 py-1 rounded mr-3">POST</span>
                        <code class="text-lg font-mono text-gray-800">/api/auth/login</code>
                    </div>
                    <p class="text-gray-600 mb-4">Se connecter avec Google OAuth</p>
                </div>

                <!-- POST /auth/logout -->
                <div class="border-l-4 border-red-500 pl-6">
                    <div class="flex items-center mb-2">
                        <span class="bg-blue-100 text-blue-800 text-sm font-bold px-3 py-1 rounded mr-3">POST</span>
                        <code class="text-lg font-mono text-gray-800">/api/auth/logout</code>
                        <span class="ml-2 bg-red-100 text-red-800 text-xs px-2 py-1 rounded">Auth Required</span>
                    </div>
                    <p class="text-gray-600 mb-4">Se déconnecter</p>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <div class="mt-12 text-center text-gray-600">
            <p class="mb-4">Pour plus d'informations, contactez le support technique</p>
            <a href="/" class="inline-flex items-center text-teal-600 hover:text-teal-700 font-semibold">
                <i class="fas fa-arrow-left mr-2"></i>Retour à l'accueil
            </a>
        </div>
    </div>
</body>
</html>
