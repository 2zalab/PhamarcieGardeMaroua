<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacie de Garde Maroua - Trouvez rapidement une pharmacie ouverte</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-50">
    <!-- Navigation -->
    <nav class="bg-white shadow-lg sticky top-0 z-50">
        <div class="container-fluid mx-auto px-5">
            <div class="flex justify-between items-center py-4">
                <div class="flex items-center space-x-3">
                    <a href="/">
                        <img src="{{ asset('images/logo.png') }}" 
                            alt="Pharmacie de Garde Logo" 
                            class="h-12 w-12 rounded-xl">
                    </a>
                    <div>
                        <h1 class="text-xl font-bold text-gray-800">Pharmacie de Garde</h1>
                        <p class="text-xs text-gray-600">Maroua, Cameroun</p>
                    </div>
                </div>
                <div class="hidden md:flex items-center space-x-6">
                    <a href="#features" class="text-gray-700 hover:text-teal-600 transition">Fonctionnalités</a>
                    <a href="#how-it-works" class="text-gray-700 hover:text-teal-600 transition">Comment ça marche</a>
                    <a href="/api-docs" class="text-gray-700 hover:text-teal-600 transition">API</a>
                    <a href="{{ route('contact') }}" class="text-gray-700 hover:text-teal-600 transition">Contact</a>
                    <a href="{{ route('admin.login') }}" class="bg-gradient-to-r from-teal-600 to-green-600 text-white px-6 py-2 rounded-lg font-semibold hover:shadow-lg transition">
                        <i class="fas fa-sign-in-alt mr-2"></i>Connexion
                    </a>
                </div>
                <button class="md:hidden text-gray-700" onclick="toggleMobileMenu()">
                    <i class="fas fa-bars text-2xl"></i>
                </button>
            </div>
            <div id="mobile-menu" class="hidden md:hidden pb-4">
                <a href="#features" class="block py-2 text-gray-700 hover:text-teal-600">Fonctionnalités</a>
                <a href="#how-it-works" class="block py-2 text-gray-700 hover:text-teal-600">Comment ça marche</a>
                <a href="/api-docs" class="block py-2 text-gray-700 hover:text-teal-600" target="_blank">API</a>
                <a href="{{ route('admin.login') }}" class="block py-2 text-teal-600 font-semibold">Connexion</a>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="bg-gradient-to-br from-teal-600 to-green-600 text-white py-10">
        <div class="container-fluid mx-auto px-4">
            <div class="flex flex-col md:flex-row items-center">
                <div class="md:w-1/2 mb-10 md:mb-0">
                    <h2 class="text-5xl font-bold mb-6 leading-tight">Trouvez une pharmacie de garde près de chez vous</h2>
                    <p class="text-xl text-teal-100 mb-8">Application mobile et API pour localiser rapidement les pharmacies de garde à Maroua. Disponible 24h/24, 7j/7.</p>
                    <div class="flex flex-wrap gap-4">
                        <a href="#download" class="bg-white text-teal-600 px-8 py-4 rounded-lg font-bold hover:shadow-xl transition transform hover:-translate-y-1">
                            <i class="fab fa-android mr-2"></i>Télécharger l'app
                        </a>
                        <a href="/api-docs" class="bg-teal-700 text-white px-8 py-4 rounded-lg font-bold hover:bg-teal-800 transition" target="_blank">
                            <i class="fas fa-code mr-2"></i>Documentation API
                        </a>
                    </div>
                </div>
                <div class="md:w-1/2 flex justify-center items-center gap-6">
                    <div class="relative">
                        <div class="bg-white/10 backdrop-blur-sm rounded-3xl p-8 border-4 border-white/30">
                            <i class="fas fa-mobile-alt text-9xl text-white"></i>
                        </div>
                        <div class="absolute -top-4 -right-4 bg-yellow-400 rounded-full p-4 animate-bounce">
                            <i class="fas fa-map-marker-alt text-3xl text-white"></i>
                        </div>
                    </div>
                    <div class="hidden md:block">
                        <img src="{{ asset('images/mobileApp.png') }}" alt="Application Mobile" class="h-80 object-contain drop-shadow-2xl">
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Features Section -->
    <section id="features" class="py-20">
        <div class="container-fluid mx-auto px-4">
            <div class="text-center mb-16">
                <h2 class="text-4xl font-bold text-gray-800 mb-4">Fonctionnalités Principales</h2>
                <p class="text-xl text-gray-600">Une solution complète pour gérer et trouver les pharmacies de garde</p>
            </div>
            <div class="grid md:grid-cols-3 gap-8">
                <div class="bg-white rounded-2xl p-8 shadow-lg hover:shadow-xl transition transform hover:-translate-y-2">
                    <div class="bg-gradient-to-br from-teal-500 to-green-500 w-16 h-16 rounded-xl flex items-center justify-center mb-6">
                        <i class="fas fa-map-marked-alt text-3xl text-white"></i>
                    </div>
                    <h3 class="text-2xl font-bold text-gray-800 mb-4">Carte Interactive</h3>
                    <p class="text-gray-600">Visualisez toutes les pharmacies de garde sur une carte interactive avec votre position en temps réel.</p>
                </div>
                <div class="bg-white rounded-2xl p-8 shadow-lg hover:shadow-xl transition transform hover:-translate-y-2">
                    <div class="bg-gradient-to-br from-blue-500 to-purple-500 w-16 h-16 rounded-xl flex items-center justify-center mb-6">
                        <i class="fas fa-calendar-alt text-3xl text-white"></i>
                    </div>
                    <h3 class="text-2xl font-bold text-gray-800 mb-4">Calendrier des Gardes</h3>
                    <p class="text-gray-600">Consultez le calendrier complet des pharmacies de garde par jour, semaine ou mois.</p>
                </div>
                <div class="bg-white rounded-2xl p-8 shadow-lg hover:shadow-xl transition transform hover:-translate-y-2">
                    <div class="bg-gradient-to-br from-orange-500 to-red-500 w-16 h-16 rounded-xl flex items-center justify-center mb-6">
                        <i class="fas fa-search text-3xl text-white"></i>
                    </div>
                    <h3 class="text-2xl font-bold text-gray-800 mb-4">Recherche Avancée</h3>
                    <p class="text-gray-600">Recherchez par nom, quartier ou proximité. Filtrez et triez les résultats selon vos besoins.</p>
                </div>
                <div class="bg-white rounded-2xl p-8 shadow-lg hover:shadow-xl transition transform hover:-translate-y-2">
                    <div class="bg-gradient-to-br from-pink-500 to-rose-500 w-16 h-16 rounded-xl flex items-center justify-center mb-6">
                        <i class="fas fa-heart text-3xl text-white"></i>
                    </div>
                    <h3 class="text-2xl font-bold text-gray-800 mb-4">Favoris</h3>
                    <p class="text-gray-600">Enregistrez vos pharmacies préférées pour y accéder rapidement à tout moment.</p>
                </div>
                <div class="bg-white rounded-2xl p-8 shadow-lg hover:shadow-xl transition transform hover:-translate-y-2">
                    <div class="bg-gradient-to-br from-yellow-500 to-orange-500 w-16 h-16 rounded-xl flex items-center justify-center mb-6">
                        <i class="fas fa-star text-3xl text-white"></i>
                    </div>
                    <h3 class="text-2xl font-bold text-gray-800 mb-4">Évaluations</h3>
                    <p class="text-gray-600">Consultez et laissez des avis sur les pharmacies pour aider la communauté.</p>
                </div>
                <div class="bg-white rounded-2xl p-8 shadow-lg hover:shadow-xl transition transform hover:-translate-y-2">
                    <div class="bg-gradient-to-br from-indigo-500 to-blue-500 w-16 h-16 rounded-xl flex items-center justify-center mb-6">
                        <i class="fas fa-mobile-alt text-3xl text-white"></i>
                    </div>
                    <h3 class="text-2xl font-bold text-gray-800 mb-4">Application Mobile</h3>
                    <p class="text-gray-600">Application Android native avec interface moderne et intuitive.</p>
                </div>
            </div>
        </div>
    </section>

    <!-- How It Works -->
    <section id="how-it-works" class="bg-gray-100 py-20">
        <div class="container-fluid mx-auto px-4">
            <div class="text-center mb-16">
                <h2 class="text-4xl font-bold text-gray-800 mb-4">Comment ça marche ?</h2>
                <p class="text-xl text-gray-600">Simple, rapide et efficace</p>
            </div>
            <div class="grid md:grid-cols-4 gap-8">
                <div class="text-center">
                    <div class="bg-gradient-to-br from-teal-600 to-green-600 w-20 h-20 rounded-full flex items-center justify-center mx-auto mb-6 text-white text-3xl font-bold">1</div>
                    <h3 class="text-xl font-bold text-gray-800 mb-3">Téléchargez l'app</h3>
                    <p class="text-gray-600">Installez l'application depuis le Google Play Store</p>
                </div>
                <div class="text-center">
                    <div class="bg-gradient-to-br from-blue-600 to-purple-600 w-20 h-20 rounded-full flex items-center justify-center mx-auto mb-6 text-white text-3xl font-bold">2</div>
                    <h3 class="text-xl font-bold text-gray-800 mb-3">Activez la localisation</h3>
                    <p class="text-gray-600">Autorisez l'accès à votre position pour trouver les pharmacies proches</p>
                </div>
                <div class="text-center">
                    <div class="bg-gradient-to-br from-orange-600 to-red-600 w-20 h-20 rounded-full flex items-center justify-center mx-auto mb-6 text-white text-3xl font-bold">3</div>
                    <h3 class="text-xl font-bold text-gray-800 mb-3">Recherchez</h3>
                    <p class="text-gray-600">Trouvez les pharmacies de garde près de vous en un clic</p>
                </div>
                <div class="text-center">
                    <div class="bg-gradient-to-br from-pink-600 to-rose-600 w-20 h-20 rounded-full flex items-center justify-center mx-auto mb-6 text-white text-3xl font-bold">4</div>
                    <h3 class="text-xl font-bold text-gray-800 mb-3">Contactez</h3>
                    <p class="text-gray-600">Appelez directement ou consultez les informations de la pharmacie</p>
                </div>
            </div>
        </div>
    </section>

    <!-- API Section -->
    <section class="py-20">
        <div class="container-fluid mx-auto px-4">
            <div class="bg-gradient-to-br from-gray-800 to-gray-900 rounded-3xl p-12 text-white">
                <div class="md:flex items-center justify-between">
                    <div class="mb-8 md:mb-0">
                        <h2 class="text-4xl font-bold mb-4">API RESTful Disponible</h2>
                        <p class="text-gray-300 text-lg mb-6">Intégrez les données des pharmacies de garde dans vos applications</p>
                        <ul class="space-y-3">
                            <li class="flex items-center"><i class="fas fa-check-circle text-green-400 mr-3"></i><span>Documentation complète</span></li>
                            <li class="flex items-center"><i class="fas fa-check-circle text-green-400 mr-3"></i><span>Endpoints REST simples</span></li>
                            <li class="flex items-center"><i class="fas fa-check-circle text-green-400 mr-3"></i><span>Réponses JSON</span></li>
                        </ul>
                    </div>
                    <div>
                        <a href="/api-docs" class="bg-white text-gray-900 px-8 py-4 rounded-lg font-bold hover:shadow-xl transition transform hover:-translate-y-1 inline-block">
                            <i class="fas fa-book mr-2"></i>Voir la documentation
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Stats -->
    <section class="bg-gradient-to-br from-teal-600 to-green-600 py-16">
        <div class="container-fluid mx-auto px-4">
            <div class="grid md:grid-cols-4 gap-8 text-center text-white">
                <div>
                    <div class="text-5xl font-bold mb-2">{{ \App\Models\Pharmacy::count() }}+</div>
                    <div class="text-teal-100">Pharmacies référencées</div>
                </div>
                <div>
                    <div class="text-5xl font-bold mb-2">{{ \App\Models\Schedule::count() }}+</div>
                    <div class="text-teal-100">Horaires planifiés</div>
                </div>
                <div>
                    <div class="text-5xl font-bold mb-2">{{ \App\Models\Rating::count() }}+</div>
                    <div class="text-teal-100">Évaluations</div>
                </div>
                <div>
                    <div class="text-5xl font-bold mb-2">24/7</div>
                    <div class="text-teal-100">Service disponible</div>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="bg-gray-900 text-white py-12">
        <div class="container-fluid mx-auto px-4">
            <div class="grid md:grid-cols-4 gap-8 mb-8">
                <div>
                    <div class="flex items-center space-x-3 mb-4">
                        <div class="bg-gradient-to-br from-teal-600 to-green-600 rounded-xl p-2">
                            <i class="fas fa-pills text-xl text-white"></i>
                        </div>
                        <div>
                            <h3 class="font-bold">Pharmacie de Garde</h3>
                            <p class="text-sm text-gray-400">Maroua</p>
                        </div>
                    </div>
                    <p class="text-gray-400 text-sm">Votre solution pour trouver rapidement une pharmacie de garde à Maroua.</p>
                </div>
                <div>
                    <h4 class="font-bold mb-4">Liens Rapides</h4>
                    <ul class="space-y-2 text-gray-400">
                        <li><a href="#features" class="hover:text-teal-400">Fonctionnalités</a></li>
                        <li><a href="#how-it-works" class="hover:text-teal-400">Comment ça marche</a></li>
                        <li><a href="/api-docs" class="hover:text-teal-400">API Documentation</a></li>
                        <li><a href="{{ route('admin.login') }}" class="hover:text-teal-400">Espace Admin</a></li>
                    </ul>
                </div>
                <div>
                    <h4 class="font-bold mb-4">Support</h4>
                    <ul class="space-y-2 text-gray-400">
                        <li><a href="#" class="hover:text-teal-400">FAQ</a></li>
                        <li><a href="#" class="hover:text-teal-400">Contact</a></li>
                        <li><a href="#" class="hover:text-teal-400">Aide</a></li>
                    </ul>
                </div>
                <div>
                    <h4 class="font-bold mb-4">Télécharger</h4>
                    <a href="#" class="block bg-gray-800 hover:bg-gray-700 rounded-lg p-3 mb-3 transition">
                        <i class="fab fa-google-play text-2xl text-green-400 mr-2"></i>
                        <span class="text-sm">Google Play Store</span>
                    </a>
                </div>
            </div>
            <div class="border-t border-gray-800 pt-8 text-center text-gray-400 text-sm">
                <p>&copy; {{ date('Y') }} Pharmacie de Garde Maroua. Tous droits réservés.</p>
            </div>
        </div>
    </footer>

    <script>
        function toggleMobileMenu() {
            document.getElementById('mobile-menu').classList.toggle('hidden');
        }
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                const target = document.querySelector(this.getAttribute('href'));
                if (target) target.scrollIntoView({ behavior: 'smooth' });
            });
        });
    </script>
</body>
</html>
