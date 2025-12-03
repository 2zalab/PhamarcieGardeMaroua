<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aide - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-50">
    <!-- Navigation -->
    <nav class="bg-white shadow-lg sticky top-0 z-50">
        <div class="container-fluid mx-auto px-4">
            <div class="flex justify-between items-center py-4">
                <a href="/" class="flex items-center space-x-3">
                    <img src="{{ asset('images/logo.png') }}" alt="Pharmacie de Garde Logo" class="h-12 w-12 rounded-xl">
                    <div>
                        <h1 class="text-xl font-bold text-gray-800">Pharmacie de Garde</h1>
                        <p class="text-xs text-gray-600">Maroua, Cameroun</p>
                    </div>
                </a>
                <div class="hidden md:flex items-center space-x-6">
                    <a href="/#features" class="text-gray-700 hover:text-teal-600 transition">Fonctionnalités</a>
                    <a href="/#how-it-works" class="text-gray-700 hover:text-teal-600 transition">Comment ça marche</a>
                    <a href="/api-docs" class="text-gray-700 hover:text-teal-600 transition" target="_blank">API</a>
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
                <a href="/#features" class="block py-2 text-gray-700 hover:text-teal-600">Fonctionnalités</a>
                <a href="/#how-it-works" class="block py-2 text-gray-700 hover:text-teal-600">Comment ça marche</a>
                <a href="/api-docs" class="block py-2 text-gray-700 hover:text-teal-600" target="_blank">API</a>
                <a href="{{ route('contact') }}" class="block py-2 text-gray-700 hover:text-teal-600">Contact</a>
                <a href="{{ route('admin.login') }}" class="block py-2 text-teal-600 font-semibold">Connexion</a>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <section class="bg-gradient-to-br from-teal-600 to-green-600 text-white py-16">
        <div class="container-fluid mx-auto px-4 text-center">
            <h1 class="text-5xl font-bold mb-4">Centre d'Aide</h1>
            <p class="text-xl text-teal-100">Guide d'utilisation de l'application Pharmacie de Garde</p>
        </div>
    </section>

    <!-- Help Content -->
    <section class="py-16">
        <div class="container-fluid mx-auto px-4">
            <div class="max-w-4xl mx-auto">

                <!-- Getting Started -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-rocket text-teal-600 mr-3"></i>
                        Pour Commencer
                    </h2>

                    <div class="bg-white rounded-2xl border border-gray-200 p-8 mb-6">
                        <h3 class="text-xl font-bold text-gray-800 mb-4">1. Installation de l'application</h3>
                        <div class="space-y-4">
                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">1</span>
                                </div>
                                <div class="flex-1">
                                    <p class="text-gray-600">Ouvrez le <strong>Google Play Store</strong> sur votre appareil Android</p>
                                </div>
                            </div>
                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">2</span>
                                </div>
                                <div class="flex-1">
                                    <p class="text-gray-600">Recherchez <strong>"Pharmacie de Garde Maroua"</strong></p>
                                </div>
                            </div>
                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">3</span>
                                </div>
                                <div class="flex-1">
                                    <p class="text-gray-600">Cliquez sur <strong>Installer</strong> et attendez la fin du téléchargement</p>
                                </div>
                            </div>
                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">4</span>
                                </div>
                                <div class="flex-1">
                                    <p class="text-gray-600">Ouvrez l'application et <strong>autorisez l'accès à votre localisation</strong> (recommandé)</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="bg-white rounded-2xl border border-gray-200 p-8">
                        <h3 class="text-xl font-bold text-gray-800 mb-4">2. Première utilisation</h3>
                        <p class="text-gray-600 mb-4">
                            Lors de votre première utilisation, l'application vous demandera quelques autorisations :
                        </p>
                        <ul class="space-y-3">
                            <li class="flex items-start space-x-3">
                                <i class="fas fa-check-circle text-green-500 mt-1"></i>
                                <div>
                                    <strong class="text-gray-800">Localisation :</strong>
                                    <span class="text-gray-600">Pour trouver les pharmacies proches de vous</span>
                                </div>
                            </li>
                            <li class="flex items-start space-x-3">
                                <i class="fas fa-check-circle text-green-500 mt-1"></i>
                                <div>
                                    <strong class="text-gray-800">Internet :</strong>
                                    <span class="text-gray-600">Pour accéder aux informations en temps réel</span>
                                </div>
                            </li>
                            <li class="flex items-start space-x-3">
                                <i class="fas fa-check-circle text-green-500 mt-1"></i>
                                <div>
                                    <strong class="text-gray-800">Notifications (optionnel) :</strong>
                                    <span class="text-gray-600">Pour recevoir des alertes sur vos pharmacies favorites</span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <!-- Main Features -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-search text-teal-600 mr-3"></i>
                        Rechercher une Pharmacie
                    </h2>

                    <div class="grid md:grid-cols-2 gap-6 mb-6">
                        <div class="bg-white rounded-2xl border border-gray-200 p-6">
                            <div class="bg-gradient-to-br from-teal-500 to-green-500 w-16 h-16 rounded-xl flex items-center justify-center mb-4">
                                <i class="fas fa-map-marker-alt text-3xl text-white"></i>
                            </div>
                            <h3 class="text-xl font-bold text-gray-800 mb-3">Par Localisation</h3>
                            <p class="text-gray-600 mb-3">Utilisez votre position GPS pour trouver les pharmacies les plus proches :</p>
                            <ol class="space-y-2 text-sm text-gray-600">
                                <li>1. Activez votre GPS</li>
                                <li>2. Cliquez sur "Pharmacies proches"</li>
                                <li>3. Consultez la liste ou la carte</li>
                            </ol>
                        </div>

                        <div class="bg-white rounded-2xl border border-gray-200 p-6">
                            <div class="bg-gradient-to-br from-blue-500 to-purple-500 w-16 h-16 rounded-xl flex items-center justify-center mb-4">
                                <i class="fas fa-keyboard text-3xl text-white"></i>
                            </div>
                            <h3 class="text-xl font-bold text-gray-800 mb-3">Par Nom ou Quartier</h3>
                            <p class="text-gray-600 mb-3">Recherchez manuellement une pharmacie :</p>
                            <ol class="space-y-2 text-sm text-gray-600">
                                <li>1. Cliquez sur la barre de recherche</li>
                                <li>2. Tapez le nom ou le quartier</li>
                                <li>3. Sélectionnez dans les résultats</li>
                            </ol>
                        </div>

                        <div class="bg-white rounded-2xl border border-gray-200 p-6">
                            <div class="bg-gradient-to-br from-orange-500 to-red-500 w-16 h-16 rounded-xl flex items-center justify-center mb-4">
                                <i class="fas fa-calendar-alt text-3xl text-white"></i>
                            </div>
                            <h3 class="text-xl font-bold text-gray-800 mb-3">Par Date</h3>
                            <p class="text-gray-600 mb-3">Consultez le calendrier des gardes :</p>
                            <ol class="space-y-2 text-sm text-gray-600">
                                <li>1. Allez dans "Calendrier"</li>
                                <li>2. Sélectionnez une date</li>
                                <li>3. Voir les pharmacies de garde</li>
                            </ol>
                        </div>

                        <div class="bg-white rounded-2xl border border-gray-200 p-6">
                            <div class="bg-gradient-to-br from-pink-500 to-rose-500 w-16 h-16 rounded-xl flex items-center justify-center mb-4">
                                <i class="fas fa-map text-3xl text-white"></i>
                            </div>
                            <h3 class="text-xl font-bold text-gray-800 mb-3">Via la Carte</h3>
                            <p class="text-gray-600 mb-3">Explorez toutes les pharmacies :</p>
                            <ol class="space-y-2 text-sm text-gray-600">
                                <li>1. Ouvrez la vue "Carte"</li>
                                <li>2. Zoomez sur votre zone</li>
                                <li>3. Cliquez sur un marqueur</li>
                            </ol>
                        </div>
                    </div>
                </div>

                <!-- Managing Favorites -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-heart text-teal-600 mr-3"></i>
                        Gérer vos Favoris
                    </h2>

                    <div class="bg-white rounded-2xl border border-gray-200 p-8">
                        <div class="space-y-6">
                            <div>
                                <h3 class="text-lg font-bold text-gray-800 mb-3">Ajouter une pharmacie aux favoris</h3>
                                <ol class="space-y-2 text-gray-600">
                                    <li class="flex items-start space-x-3">
                                        <span class="font-semibold text-teal-600">1.</span>
                                        <span>Ouvrez la fiche d'une pharmacie</span>
                                    </li>
                                    <li class="flex items-start space-x-3">
                                        <span class="font-semibold text-teal-600">2.</span>
                                        <span>Cliquez sur l'icône <i class="far fa-heart text-gray-400"></i> en haut à droite</span>
                                    </li>
                                    <li class="flex items-start space-x-3">
                                        <span class="font-semibold text-teal-600">3.</span>
                                        <span>L'icône devient rouge <i class="fas fa-heart text-red-500"></i> = ajouté aux favoris</span>
                                    </li>
                                </ol>
                            </div>

                            <div class="border-t border-gray-200 pt-6">
                                <h3 class="text-lg font-bold text-gray-800 mb-3">Accéder à vos favoris</h3>
                                <ol class="space-y-2 text-gray-600">
                                    <li class="flex items-start space-x-3">
                                        <span class="font-semibold text-teal-600">1.</span>
                                        <span>Allez dans le menu principal</span>
                                    </li>
                                    <li class="flex items-start space-x-3">
                                        <span class="font-semibold text-teal-600">2.</span>
                                        <span>Sélectionnez "Mes Favoris"</span>
                                    </li>
                                    <li class="flex items-start space-x-3">
                                        <span class="font-semibold text-teal-600">3.</span>
                                        <span>Retrouvez toutes vos pharmacies préférées</span>
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Ratings -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-star text-teal-600 mr-3"></i>
                        Évaluer une Pharmacie
                    </h2>

                    <div class="bg-white rounded-2xl border border-gray-200 p-8">
                        <p class="text-gray-600 mb-6">
                            Partagez votre expérience pour aider la communauté à faire les meilleurs choix.
                        </p>

                        <div class="space-y-4">
                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">1</span>
                                </div>
                                <div class="flex-1">
                                    <h4 class="font-semibold text-gray-800 mb-1">Accédez à la pharmacie</h4>
                                    <p class="text-gray-600">Ouvrez la fiche détaillée de la pharmacie que vous souhaitez évaluer</p>
                                </div>
                            </div>

                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">2</span>
                                </div>
                                <div class="flex-1">
                                    <h4 class="font-semibold text-gray-800 mb-1">Donnez une note</h4>
                                    <p class="text-gray-600">Cliquez sur "Laisser un avis" et sélectionnez de 1 à 5 étoiles</p>
                                    <div class="mt-2">
                                        <i class="fas fa-star text-yellow-400"></i>
                                        <i class="fas fa-star text-yellow-400"></i>
                                        <i class="fas fa-star text-yellow-400"></i>
                                        <i class="fas fa-star text-yellow-400"></i>
                                        <i class="fas fa-star text-yellow-400"></i>
                                    </div>
                                </div>
                            </div>

                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">3</span>
                                </div>
                                <div class="flex-1">
                                    <h4 class="font-semibold text-gray-800 mb-1">Partagez votre avis</h4>
                                    <p class="text-gray-600">Écrivez un commentaire pour expliquer votre évaluation (optionnel)</p>
                                </div>
                            </div>

                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <span class="font-bold text-teal-600">4</span>
                                </div>
                                <div class="flex-1">
                                    <h4 class="font-semibold text-gray-800 mb-1">Validez</h4>
                                    <p class="text-gray-600">Cliquez sur "Envoyer" pour publier votre évaluation</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Tips Section -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-lightbulb text-teal-600 mr-3"></i>
                        Conseils et Astuces
                    </h2>

                    <div class="grid md:grid-cols-2 gap-6">
                        <div class="bg-gradient-to-br from-blue-50 to-purple-50 rounded-2xl border border-blue-200 p-6">
                            <div class="flex items-start space-x-3 mb-3">
                                <i class="fas fa-battery-full text-blue-600 text-2xl"></i>
                                <h3 class="text-lg font-bold text-gray-800">Économisez la batterie</h3>
                            </div>
                            <p class="text-gray-600">Désactivez le GPS après avoir trouvé votre pharmacie pour économiser la batterie.</p>
                        </div>

                        <div class="bg-gradient-to-br from-green-50 to-teal-50 rounded-2xl border border-green-200 p-6">
                            <div class="flex items-start space-x-3 mb-3">
                                <i class="fas fa-bell text-green-600 text-2xl"></i>
                                <h3 class="text-lg font-bold text-gray-800">Activez les notifications</h3>
                            </div>
                            <p class="text-gray-600">Recevez des alertes quand vos pharmacies favorites sont de garde.</p>
                        </div>

                        <div class="bg-gradient-to-br from-orange-50 to-red-50 rounded-2xl border border-orange-200 p-6">
                            <div class="flex items-start space-x-3 mb-3">
                                <i class="fas fa-phone text-orange-600 text-2xl"></i>
                                <h3 class="text-lg font-bold text-gray-800">Appelez avant de vous déplacer</h3>
                            </div>
                            <p class="text-gray-600">Contactez la pharmacie pour vérifier la disponibilité du médicament recherché.</p>
                        </div>

                        <div class="bg-gradient-to-br from-pink-50 to-rose-50 rounded-2xl border border-pink-200 p-6">
                            <div class="flex items-start space-x-3 mb-3">
                                <i class="fas fa-sync text-pink-600 text-2xl"></i>
                                <h3 class="text-lg font-bold text-gray-800">Gardez l'app à jour</h3>
                            </div>
                            <p class="text-gray-600">Mettez régulièrement à jour l'application pour profiter des nouvelles fonctionnalités.</p>
                        </div>
                    </div>
                </div>

                <!-- Contact CTA -->
                <div class="bg-gradient-to-br from-teal-600 to-green-600 rounded-2xl p-8 text-white text-center">
                    <i class="fas fa-question-circle text-5xl mb-4 opacity-80"></i>
                    <h3 class="text-2xl font-bold mb-4">Besoin d'aide supplémentaire ?</h3>
                    <p class="text-teal-100 mb-6">Consultez notre FAQ ou contactez notre équipe d'assistance</p>
                    <div class="flex flex-wrap justify-center gap-4">
                        <a href="{{ route('faq') }}" class="inline-block bg-white text-teal-600 px-6 py-3 rounded-lg font-bold hover:shadow-xl transition">
                            <i class="fas fa-question mr-2"></i>Voir la FAQ
                        </a>
                        <a href="{{ route('contact') }}" class="inline-block bg-teal-700 text-white px-6 py-3 rounded-lg font-bold hover:bg-teal-800 transition">
                            <i class="fas fa-envelope mr-2"></i>Nous Contacter
                        </a>
                    </div>
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
                        <li><a href="/#features" class="hover:text-teal-400">Fonctionnalités</a></li>
                        <li><a href="/#how-it-works" class="hover:text-teal-400">Comment ça marche</a></li>
                        <li><a href="/api-docs" class="hover:text-teal-400" target="_blank">API Documentation</a></li>
                        <li><a href="{{ route('admin.login') }}" class="hover:text-teal-400">Espace Admin</a></li>
                    </ul>
                </div>
                <div>
                    <h4 class="font-bold mb-4">Support</h4>
                    <ul class="space-y-2 text-gray-400">
                        <li><a href="{{ route('faq') }}" class="hover:text-teal-400">FAQ</a></li>
                        <li><a href="{{ route('contact') }}" class="hover:text-teal-400">Contact</a></li>
                        <li><a href="{{ route('aide') }}" class="hover:text-teal-400">Aide</a></li>
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
    </script>
</body>
</html>
