<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAQ - Pharmacie de Garde Maroua</title>
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
            <h1 class="text-5xl font-bold mb-4">Foire Aux Questions</h1>
            <p class="text-xl text-teal-100">Trouvez rapidement des réponses à vos questions</p>
        </div>
    </section>

    <!-- FAQ Content -->
    <section class="py-16">
        <div class="container-fluid mx-auto px-4">
            <div class="max-w-4xl mx-auto">

                <!-- General Section -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-info-circle text-teal-600 mr-3"></i>
                        Questions Générales
                    </h2>

                    <div class="space-y-4">
                        <!-- Question 1 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(1)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Qu'est-ce que Pharmacie de Garde Maroua ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-1"></i>
                            </button>
                            <div id="faq-1" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Pharmacie de Garde Maroua est une application mobile et un service web qui vous permet de localiser rapidement les pharmacies de garde ouvertes à Maroua. Le service est disponible 24h/24, 7j/7 pour vous aider à trouver une pharmacie proche de vous en cas d'urgence.
                                </p>
                            </div>
                        </div>

                        <!-- Question 2 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(2)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Le service est-il gratuit ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-2"></i>
                            </button>
                            <div id="faq-2" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Oui, l'application mobile et le service web sont entièrement gratuits. Vous pouvez rechercher et localiser les pharmacies de garde sans aucun frais.
                                </p>
                            </div>
                        </div>

                        <!-- Question 3 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(3)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Comment sont mises à jour les informations des pharmacies ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-3"></i>
                            </button>
                            <div id="faq-3" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Les informations des pharmacies sont régulièrement mises à jour par notre équipe administrative. Les horaires de garde, les coordonnées et les disponibilités sont vérifiés quotidiennement pour garantir des informations fiables et précises.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Application Section -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-mobile-alt text-teal-600 mr-3"></i>
                        Application Mobile
                    </h2>

                    <div class="space-y-4">
                        <!-- Question 4 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(4)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Comment télécharger l'application ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-4"></i>
                            </button>
                            <div id="faq-4" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    L'application est disponible sur Google Play Store pour les appareils Android. Recherchez "Pharmacie de Garde Maroua" ou utilisez le lien de téléchargement disponible sur notre site web.
                                </p>
                            </div>
                        </div>

                        <!-- Question 5 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(5)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    L'application nécessite-t-elle une connexion Internet ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-5"></i>
                            </button>
                            <div id="faq-5" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Oui, une connexion Internet est nécessaire pour accéder aux informations en temps réel des pharmacies de garde. Cependant, vous pouvez enregistrer vos pharmacies favorites pour y accéder hors ligne.
                                </p>
                            </div>
                        </div>

                        <!-- Question 6 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(6)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Pourquoi l'application demande-t-elle ma localisation ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-6"></i>
                            </button>
                            <div id="faq-6" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    L'application utilise votre localisation pour vous montrer les pharmacies de garde les plus proches de vous et calculer les itinéraires. Vous pouvez refuser l'accès à la localisation et rechercher manuellement par quartier ou nom de pharmacie.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Fonctionnalités Section -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-cogs text-teal-600 mr-3"></i>
                        Fonctionnalités
                    </h2>

                    <div class="space-y-4">
                        <!-- Question 7 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(7)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Comment rechercher une pharmacie de garde ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-7"></i>
                            </button>
                            <div id="faq-7" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Plusieurs options s'offrent à vous : utilisez la carte interactive pour voir toutes les pharmacies de garde, activez votre localisation pour trouver les pharmacies proches, ou recherchez par nom de pharmacie ou quartier. Vous pouvez également filtrer par date pour voir les pharmacies de garde pour un jour spécifique.
                                </p>
                            </div>
                        </div>

                        <!-- Question 8 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(8)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Puis-je ajouter une pharmacie à mes favoris ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-8"></i>
                            </button>
                            <div id="faq-8" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Oui, vous pouvez ajouter vos pharmacies préférées à votre liste de favoris en cliquant sur l'icône cœur. Cela vous permet d'y accéder rapidement et de recevoir des notifications lorsqu'elles sont de garde.
                                </p>
                            </div>
                        </div>

                        <!-- Question 9 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(9)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Comment laisser un avis sur une pharmacie ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-9"></i>
                            </button>
                            <div id="faq-9" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Sur la page de détails d'une pharmacie, vous trouverez une section "Évaluations". Cliquez sur "Laisser un avis", donnez une note (1 à 5 étoiles) et partagez votre expérience. Votre avis aidera les autres utilisateurs à faire leur choix.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Support Section -->
                <div class="mb-12">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-headset text-teal-600 mr-3"></i>
                        Support & Assistance
                    </h2>

                    <div class="space-y-4">
                        <!-- Question 10 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(10)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Comment signaler une erreur ou un problème ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-10"></i>
                            </button>
                            <div id="faq-10" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Vous pouvez nous contacter via la page <a href="{{ route('contact') }}" class="text-teal-600 hover:text-teal-700 font-semibold">Contact</a> ou nous envoyer un email à <a href="mailto:contact@mit.cm" class="text-teal-600 hover:text-teal-700 font-semibold">contact@mit.cm</a>. Décrivez le problème rencontré et notre équipe vous répondra dans les plus brefs délais.
                                </p>
                            </div>
                        </div>

                        <!-- Question 11 -->
                        <div class="bg-white rounded-2xl border border-gray-200 overflow-hidden">
                            <button onclick="toggleFaq(11)" class="w-full flex items-center justify-between p-6 text-left hover:bg-gray-50 transition">
                                <span class="font-semibold text-gray-800 flex items-start">
                                    <i class="fas fa-question-circle text-teal-600 mr-3 mt-1"></i>
                                    Je suis pharmacien, comment ajouter ma pharmacie ?
                                </span>
                                <i class="fas fa-chevron-down text-gray-400 transform transition-transform" id="icon-11"></i>
                            </button>
                            <div id="faq-11" class="hidden px-6 pb-6">
                                <p class="text-gray-600 ml-8">
                                    Contactez-nous via notre <a href="{{ route('contact') }}" class="text-teal-600 hover:text-teal-700 font-semibold">formulaire de contact</a> ou par téléphone au +237 691 805 321. Nous vous guiderons dans le processus d'inscription et de configuration de votre pharmacie sur la plateforme.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- CTA Section -->
                <div class="bg-gradient-to-br from-teal-600 to-green-600 rounded-2xl p-8 text-white text-center">
                    <h3 class="text-2xl font-bold mb-4">Vous n'avez pas trouvé votre réponse ?</h3>
                    <p class="text-teal-100 mb-6">Notre équipe est là pour vous aider</p>
                    <a href="{{ route('contact') }}" class="inline-block bg-white text-teal-600 px-8 py-3 rounded-lg font-bold hover:shadow-xl transition transform hover:-translate-y-1">
                        <i class="fas fa-envelope mr-2"></i>Contactez-nous
                    </a>
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

        function toggleFaq(id) {
            const faqElement = document.getElementById('faq-' + id);
            const iconElement = document.getElementById('icon-' + id);

            faqElement.classList.toggle('hidden');
            iconElement.classList.toggle('rotate-180');
        }
    </script>
</body>
</html>
