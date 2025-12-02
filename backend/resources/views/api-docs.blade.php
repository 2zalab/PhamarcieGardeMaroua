<!DOCTYPE html>
<html lang="fr" class="scroll-smooth">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentation API - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        .code-block {
            background: #1e293b;
            color: #e2e8f0;
        }
        .scrollbar-hide::-webkit-scrollbar {
            display: none;
        }
        .scrollbar-hide {
            -ms-overflow-style: none;
            scrollbar-width: none;
        }
    </style>
</head>
<body class="bg-gray-50">
    <!-- Top Navigation -->
    <nav class="bg-white border-b border-gray-200 fixed top-0 left-0 right-0 z-40">
        <div class="px-6 py-4">
            <div class="flex justify-between items-center">
                <a href="/" class="flex items-center space-x-3">
                    <img src="{{ asset('images/logo.png') }}" alt="Logo" class="h-10 w-10 rounded-xl">
                    <div>
                        <span class="text-xl font-bold text-gray-800">Pharmacie de Garde</span>
                        <span class="text-xs text-gray-500 block">Documentation API</span>
                    </div>
                </a>
                <div class="flex items-center space-x-4">
                    <div class="hidden md:flex items-center bg-gray-100 text-gray-700 px-4 py-2 rounded-lg text-sm font-mono">
                        <i class="fas fa-link mr-2 text-teal-600"></i>
                        {{ url('/api') }}
                    </div>
                    <a href="/" class="text-gray-700 hover:text-teal-600 transition">
                        <i class="fas fa-arrow-left mr-2"></i>Accueil
                    </a>
                    <!--a href="{{ route('admin.login') }}" class="bg-teal-600 text-white px-4 py-2 rounded-lg hover:bg-teal-700 transition">
                        <i class="fas fa-user-shield mr-2"></i>Admin
                    </a-->
                </div>
            </div>
        </div>
    </nav>

    <div class="flex pt-16">
        <!-- Sidebar -->
        <aside class="w-64 bg-white border-r border-gray-200 fixed left-0 top-16 bottom-0 overflow-y-auto scrollbar-hide hidden lg:block">
            <div class="p-6">
                <h3 class="text-xs font-semibold text-gray-400 uppercase tracking-wider mb-4">Navigation</h3>
                <nav class="space-y-1">
                    <a href="#introduction" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-info-circle w-5 mr-3"></i>Introduction
                    </a>
                    <a href="#authentication" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-key w-5 mr-3"></i>Authentification
                    </a>

                    <div class="pt-4 pb-2">
                        <h4 class="text-xs font-semibold text-gray-400 uppercase tracking-wider px-3">Endpoints</h4>
                    </div>

                    <a href="#pharmacies" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-hospital w-5 mr-3"></i>Pharmacies
                    </a>
                    <a href="#schedules" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-calendar-alt w-5 mr-3"></i>Horaires
                    </a>
                    <a href="#ratings" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-star w-5 mr-3"></i>Évaluations
                    </a>
                    <a href="#auth-endpoints" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-lock w-5 mr-3"></i>Auth Endpoints
                    </a>

                    <div class="pt-4 pb-2">
                        <h4 class="text-xs font-semibold text-gray-400 uppercase tracking-wider px-3">Ressources</h4>
                    </div>

                    <a href="#errors" class="flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-lg hover:bg-gray-50 hover:text-teal-600 transition">
                        <i class="fas fa-exclamation-triangle w-5 mr-3"></i>Codes d'erreur
                    </a>
                </nav>
            </div>
        </aside>

        <!-- Main Content -->
        <main class="flex-1 lg:ml-64">
            <div class="max-w-4xl mx-auto px-6 py-8 pb-20">

                <!-- Introduction -->
                <section id="introduction" class="mb-16">
                    <h1 class="text-4xl font-bold text-gray-900 mb-4">Documentation API</h1>
                    <p class="text-xl text-gray-600 mb-6">
                        Bienvenue dans la documentation de l'API Pharmacie de Garde Maroua.
                        Cette API RESTful vous permet d'accéder aux données des pharmacies de garde,
                        aux horaires et aux évaluations.
                    </p>

                    <div class="bg-teal-50 border-l-4 border-teal-500 p-6 rounded-r-lg mb-6">
                        <div class="flex">
                            <i class="fas fa-lightbulb text-teal-600 text-xl mr-4 mt-1"></i>
                            <div>
                                <h3 class="font-bold text-teal-900 mb-2">URL de base</h3>
                                <code class="bg-white text-teal-800 px-3 py-1 rounded font-mono text-sm">
                                    {{ url('/api') }}
                                </code>
                            </div>
                        </div>
                    </div>

                    <div class="bg-blue-50 border-l-4 border-blue-500 p-6 rounded-r-lg">
                        <div class="flex">
                            <i class="fas fa-code text-blue-600 text-xl mr-4 mt-1"></i>
                            <div>
                                <h3 class="font-bold text-blue-900 mb-2">Format de réponse</h3>
                                <p class="text-blue-800 text-sm">
                                    Toutes les réponses sont au format JSON avec l'en-tête
                                    <code class="bg-white px-2 py-1 rounded text-xs">Content-Type: application/json</code>
                                </p>
                            </div>
                        </div>
                    </div>
                </section>

                <!-- Authentication -->
                <section id="authentication" class="mb-16">
                    <h2 class="text-3xl font-bold text-gray-900 mb-4 flex items-center">
                        <i class="fas fa-key text-teal-600 mr-3"></i>
                        Authentification
                    </h2>
                    <p class="text-gray-600 mb-6">
                        Certains endpoints nécessitent une authentification. Utilisez un token Bearer dans l'en-tête Authorization.
                    </p>

                    <div class="bg-gray-900 rounded-lg p-6 overflow-x-auto mb-4">
                        <pre class="text-sm text-gray-300"><code>Authorization: Bearer YOUR_ACCESS_TOKEN</code></pre>
                    </div>

                    <div class="bg-yellow-50 border-l-4 border-yellow-400 p-4 rounded-r-lg">
                        <div class="flex">
                            <i class="fas fa-info-circle text-yellow-600 mr-3 mt-1"></i>
                            <p class="text-sm text-yellow-800">
                                Les endpoints publics (liste des pharmacies, horaires) ne nécessitent pas d'authentification.
                            </p>
                        </div>
                    </div>
                </section>

                <!-- Pharmacies Endpoints -->
                <section id="pharmacies" class="mb-16">
                    <h2 class="text-3xl font-bold text-gray-900 mb-6 flex items-center">
                        <i class="fas fa-hospital text-teal-600 mr-3"></i>
                        Pharmacies
                    </h2>

                    <!-- GET /pharmacies -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/pharmacies</code>
                        </div>
                        <p class="text-gray-600 mb-4">Récupère la liste de toutes les pharmacies disponibles.</p>

                        <div class="border-t pt-4">
                            <h4 class="font-semibold text-gray-700 mb-3">Réponse</h4>
                            <div class="code-block rounded-lg p-4 overflow-x-auto">
                                <pre class="text-sm"><code>{
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
                    </div>

                    <!-- GET /pharmacies/on-duty -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/pharmacies/on-duty</code>
                        </div>
                        <p class="text-gray-600 mb-4">Récupère uniquement les pharmacies de garde actuellement ouvertes.</p>
                    </div>

                    <!-- GET /pharmacies/nearby -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/pharmacies/nearby</code>
                        </div>
                        <p class="text-gray-600 mb-4">Trouve les pharmacies à proximité d'une position GPS donnée.</p>

                        <div class="bg-blue-50 rounded-lg p-4 mb-4">
                            <h4 class="font-semibold text-blue-900 mb-2 text-sm">Paramètres (Query)</h4>
                            <div class="space-y-2 text-sm">
                                <div class="flex items-start">
                                    <code class="bg-white px-2 py-1 rounded text-xs text-blue-800 mr-3">latitude</code>
                                    <span class="text-blue-700">Latitude (requis) - Type: float</span>
                                </div>
                                <div class="flex items-start">
                                    <code class="bg-white px-2 py-1 rounded text-xs text-blue-800 mr-3">longitude</code>
                                    <span class="text-blue-700">Longitude (requis) - Type: float</span>
                                </div>
                                <div class="flex items-start">
                                    <code class="bg-white px-2 py-1 rounded text-xs text-blue-800 mr-3">radius</code>
                                    <span class="text-blue-700">Rayon en km (optionnel, défaut: 10) - Type: integer</span>
                                </div>
                            </div>
                        </div>

                        <div class="border-t pt-4">
                            <h4 class="font-semibold text-gray-700 mb-3">Exemple de requête</h4>
                            <div class="code-block rounded-lg p-4">
                                <code class="text-sm">GET /api/pharmacies/nearby?latitude=10.5897&longitude=14.3154&radius=5</code>
                            </div>
                        </div>
                    </div>

                    <!-- GET /pharmacies/{id} -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/pharmacies/{id}</code>
                        </div>
                        <p class="text-gray-600">Récupère les détails complets d'une pharmacie spécifique par son ID.</p>
                    </div>
                </section>

                <!-- Schedules Endpoints -->
                <section id="schedules" class="mb-16">
                    <h2 class="text-3xl font-bold text-gray-900 mb-6 flex items-center">
                        <i class="fas fa-calendar-alt text-blue-600 mr-3"></i>
                        Horaires de Garde
                    </h2>

                    <!-- GET /schedules/day/{date} -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/schedules/day/{date}</code>
                        </div>
                        <p class="text-gray-600 mb-4">Récupère les pharmacies de garde pour un jour spécifique.</p>

                        <div class="border-t pt-4">
                            <h4 class="font-semibold text-gray-700 mb-3">Exemple</h4>
                            <div class="code-block rounded-lg p-4">
                                <code class="text-sm">GET /api/schedules/day/2025-12-01</code>
                            </div>
                        </div>
                    </div>

                    <!-- GET /schedules/week/{date} -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/schedules/week/{date}</code>
                        </div>
                        <p class="text-gray-600">Récupère les pharmacies de garde pour toute la semaine contenant la date spécifiée.</p>
                    </div>

                    <!-- GET /schedules/month/{year}/{month} -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/schedules/month/{year}/{month}</code>
                        </div>
                        <p class="text-gray-600 mb-4">Récupère toutes les pharmacies de garde pour un mois spécifique.</p>

                        <div class="border-t pt-4">
                            <h4 class="font-semibold text-gray-700 mb-3">Exemple</h4>
                            <div class="code-block rounded-lg p-4">
                                <code class="text-sm">GET /api/schedules/month/2025/12</code>
                            </div>
                        </div>
                    </div>
                </section>

                <!-- Ratings Endpoints -->
                <section id="ratings" class="mb-16">
                    <h2 class="text-3xl font-bold text-gray-900 mb-6 flex items-center">
                        <i class="fas fa-star text-yellow-500 mr-3"></i>
                        Évaluations
                    </h2>

                    <!-- GET /pharmacies/{id}/ratings -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-green-100 text-green-700 font-bold px-3 py-1 rounded text-sm mr-3">GET</span>
                            <code class="text-lg font-mono text-gray-800">/api/pharmacies/{id}/ratings</code>
                        </div>
                        <p class="text-gray-600">Récupère toutes les évaluations d'une pharmacie spécifique.</p>
                    </div>

                    <!-- POST /pharmacies/{id}/ratings -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-blue-100 text-blue-700 font-bold px-3 py-1 rounded text-sm mr-3">POST</span>
                            <code class="text-lg font-mono text-gray-800">/api/pharmacies/{id}/ratings</code>
                            <span class="ml-3 bg-red-100 text-red-700 text-xs px-2 py-1 rounded font-semibold">
                                <i class="fas fa-lock mr-1"></i>Auth
                            </span>
                        </div>
                        <p class="text-gray-600 mb-4">Ajoute une nouvelle évaluation pour une pharmacie. Nécessite une authentification.</p>

                        <div class="bg-blue-50 rounded-lg p-4 mb-4">
                            <h4 class="font-semibold text-blue-900 mb-2 text-sm">Corps de la requête (JSON)</h4>
                            <div class="code-block rounded-lg p-4 mt-2">
                                <pre class="text-sm"><code>{
  "rating": 5,
  "comment": "Excellent service et accueil chaleureux!"
}</code></pre>
                            </div>
                        </div>

                        <div class="bg-gray-50 rounded-lg p-4">
                            <h4 class="font-semibold text-gray-700 mb-2 text-sm">Validation</h4>
                            <ul class="text-sm text-gray-600 space-y-1">
                                <li><code class="bg-white px-2 py-1 rounded text-xs">rating</code> - Requis, entier entre 1 et 5</li>
                                <li><code class="bg-white px-2 py-1 rounded text-xs">comment</code> - Optionnel, chaîne de caractères</li>
                            </ul>
                        </div>
                    </div>
                </section>

                <!-- Auth Endpoints -->
                <section id="auth-endpoints" class="mb-16">
                    <h2 class="text-3xl font-bold text-gray-900 mb-6 flex items-center">
                        <i class="fas fa-lock text-red-600 mr-3"></i>
                        Authentification (Endpoints)
                    </h2>

                    <!-- POST /auth/login -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6 mb-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-blue-100 text-blue-700 font-bold px-3 py-1 rounded text-sm mr-3">POST</span>
                            <code class="text-lg font-mono text-gray-800">/api/auth/login</code>
                        </div>
                        <p class="text-gray-600">Connexion via Google OAuth pour obtenir un token d'accès.</p>
                    </div>

                    <!-- POST /auth/logout -->
                    <div class="bg-white rounded-xl border border-gray-200 p-6">
                        <div class="flex items-center mb-4">
                            <span class="bg-blue-100 text-blue-700 font-bold px-3 py-1 rounded text-sm mr-3">POST</span>
                            <code class="text-lg font-mono text-gray-800">/api/auth/logout</code>
                            <span class="ml-3 bg-red-100 text-red-700 text-xs px-2 py-1 rounded font-semibold">
                                <i class="fas fa-lock mr-1"></i>Auth
                            </span>
                        </div>
                        <p class="text-gray-600">Déconnexion et révocation du token d'accès.</p>
                    </div>
                </section>

                <!-- Error Codes -->
                <section id="errors" class="mb-16">
                    <h2 class="text-3xl font-bold text-gray-900 mb-6 flex items-center">
                        <i class="fas fa-exclamation-triangle text-orange-600 mr-3"></i>
                        Codes d'erreur
                    </h2>

                    <div class="bg-white rounded-xl border border-gray-200 overflow-hidden">
                        <table class="min-w-full divide-y divide-gray-200">
                            <thead class="bg-gray-50">
                                <tr>
                                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Code</th>
                                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Signification</th>
                                </tr>
                            </thead>
                            <tbody class="bg-white divide-y divide-gray-200">
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <code class="bg-green-100 text-green-800 px-2 py-1 rounded text-sm font-mono">200</code>
                                    </td>
                                    <td class="px-6 py-4 text-sm text-gray-900">OK - Requête réussie</td>
                                </tr>
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <code class="bg-red-100 text-red-800 px-2 py-1 rounded text-sm font-mono">400</code>
                                    </td>
                                    <td class="px-6 py-4 text-sm text-gray-900">Bad Request - Paramètres invalides</td>
                                </tr>
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <code class="bg-red-100 text-red-800 px-2 py-1 rounded text-sm font-mono">401</code>
                                    </td>
                                    <td class="px-6 py-4 text-sm text-gray-900">Unauthorized - Authentification requise</td>
                                </tr>
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <code class="bg-red-100 text-red-800 px-2 py-1 rounded text-sm font-mono">404</code>
                                    </td>
                                    <td class="px-6 py-4 text-sm text-gray-900">Not Found - Ressource introuvable</td>
                                </tr>
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <code class="bg-red-100 text-red-800 px-2 py-1 rounded text-sm font-mono">500</code>
                                    </td>
                                    <td class="px-6 py-4 text-sm text-gray-900">Internal Server Error - Erreur serveur</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </section>

                <!-- Footer -->
                <div class="border-t pt-8 text-center text-gray-600">
                    <p class="mb-4">Besoin d'aide ? Contactez le support technique</p>
                    <a href="/" class="inline-flex items-center text-teal-600 hover:text-teal-700 font-semibold">
                        <i class="fas fa-home mr-2"></i>Retour à l'accueil
                    </a>
                </div>
            </div>
        </main>
    </div>

    <script>
        // Smooth scroll et highlight actif dans le sidebar
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                const target = document.querySelector(this.getAttribute('href'));
                if (target) {
                    target.scrollIntoView({
                        behavior: 'smooth',
                        block: 'start'
                    });
                }
            });
        });

        // Highlight section active dans la navigation
        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const id = entry.target.getAttribute('id');
                    document.querySelectorAll('aside a').forEach(link => {
                        link.classList.remove('bg-teal-50', 'text-teal-600');
                        if (link.getAttribute('href') === `#${id}`) {
                            link.classList.add('bg-teal-50', 'text-teal-600');
                        }
                    });
                }
            });
        }, { threshold: 0.5 });

        document.querySelectorAll('section[id]').forEach(section => {
            observer.observe(section);
        });
    </script>
</body>
</html>
