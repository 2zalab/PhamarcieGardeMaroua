<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contactez-nous - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-50">
    <!-- Navigation -->
    <nav class="bg-white shadow-lg sticky top-0 z-50">
        <div class="container mx-auto px-4">
            <div class="flex justify-between items-center py-4">
                <a href="/" class="flex items-center space-x-3">
                    <img src="{{ asset('images/logo.png') }}" alt="Logo" class="h-12 w-12 rounded-xl">
                    <div>
                        <h1 class="text-xl font-bold text-gray-800">Pharmacie de Garde</h1>
                        <p class="text-xs text-gray-600">Maroua, Cameroun</p>
                    </div>
                </a>
                <a href="/" class="text-gray-700 hover:text-teal-600 transition">
                    <i class="fas fa-arrow-left mr-2"></i>Retour à l'accueil
                </a>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <section class="bg-gradient-to-br from-teal-600 to-green-600 text-white py-16">
        <div class="container mx-auto px-4 text-center">
            <h1 class="text-5xl font-bold mb-4">Contactez-nous</h1>
            <p class="text-xl text-teal-100">Nous sommes à votre écoute pour toute question ou suggestion</p>
        </div>
    </section>

    <!-- Main Content -->
    <section class="py-16">
        <div class="container mx-auto px-4">
            <div class="grid md:grid-cols-2 gap-12 max-w-6xl mx-auto">

                <!-- Contact Form -->
                <div class="bg-white rounded-2xl shadow-xl p-8">
                    <h2 class="text-3xl font-bold text-gray-800 mb-6">
                        <i class="fas fa-envelope text-teal-600 mr-3"></i>
                        Envoyez-nous un message
                    </h2>

                    @if(session('success'))
                        <div class="mb-6 bg-green-50 border-l-4 border-green-500 p-4 rounded-r-lg">
                            <div class="flex items-center">
                                <i class="fas fa-check-circle text-green-500 text-xl mr-3"></i>
                                <p class="text-green-700">{{ session('success') }}</p>
                            </div>
                        </div>
                    @endif

                    @if(session('error'))
                        <div class="mb-6 bg-red-50 border-l-4 border-red-500 p-4 rounded-r-lg">
                            <div class="flex items-center">
                                <i class="fas fa-exclamation-circle text-red-500 text-xl mr-3"></i>
                                <p class="text-red-700">{{ session('error') }}</p>
                            </div>
                        </div>
                    @endif

                    <form action="{{ route('contact.send') }}" method="POST" class="space-y-6">
                        @csrf

                        <div>
                            <label for="name" class="block text-sm font-semibold text-gray-700 mb-2">
                                <i class="fas fa-user mr-2 text-teal-600"></i>Nom complet *
                            </label>
                            <input
                                type="text"
                                name="name"
                                id="name"
                                value="{{ old('name') }}"
                                required
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('name') border-red-500 @enderror"
                                placeholder="Votre nom complet">
                            @error('name')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="email" class="block text-sm font-semibold text-gray-700 mb-2">
                                <i class="fas fa-envelope mr-2 text-teal-600"></i>Email *
                            </label>
                            <input
                                type="email"
                                name="email"
                                id="email"
                                value="{{ old('email') }}"
                                required
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('email') border-red-500 @enderror"
                                placeholder="votre.email@exemple.com">
                            @error('email')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="phone" class="block text-sm font-semibold text-gray-700 mb-2">
                                <i class="fas fa-phone mr-2 text-teal-600"></i>Téléphone
                            </label>
                            <input
                                type="tel"
                                name="phone"
                                id="phone"
                                value="{{ old('phone') }}"
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('phone') border-red-500 @enderror"
                                placeholder="+237 6XX XX XX XX">
                            @error('phone')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="subject" class="block text-sm font-semibold text-gray-700 mb-2">
                                <i class="fas fa-tag mr-2 text-teal-600"></i>Sujet *
                            </label>
                            <input
                                type="text"
                                name="subject"
                                id="subject"
                                value="{{ old('subject') }}"
                                required
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('subject') border-red-500 @enderror"
                                placeholder="Sujet de votre message">
                            @error('subject')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="message" class="block text-sm font-semibold text-gray-700 mb-2">
                                <i class="fas fa-comment-dots mr-2 text-teal-600"></i>Message *
                            </label>
                            <textarea
                                name="message"
                                id="message"
                                rows="6"
                                required
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('message') border-red-500 @enderror"
                                placeholder="Écrivez votre message ici...">{{ old('message') }}</textarea>
                            @error('message')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <button
                            type="submit"
                            class="w-full bg-gradient-to-r from-teal-600 to-green-600 text-white px-8 py-4 rounded-lg font-bold hover:shadow-xl transition transform hover:-translate-y-1">
                            <i class="fas fa-paper-plane mr-2"></i>Envoyer le message
                        </button>
                    </form>
                </div>

                <!-- Contact Information -->
                <div class="space-y-6">
                    <!-- Info Card -->
                    <div class="bg-white rounded-2xl shadow-xl p-8">
                        <h2 class="text-3xl font-bold text-gray-800 mb-6">
                            <i class="fas fa-info-circle text-teal-600 mr-3"></i>
                            Nos Coordonnées
                        </h2>

                        <div class="space-y-6">
                            <!-- Address -->
                            <div class="flex items-start space-x-4">
                                <div class="bg-teal-100 rounded-lg p-3 flex-shrink-0">
                                    <i class="fas fa-map-marker-alt text-teal-600 text-xl"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold text-gray-800 mb-1">Adresse</h3>
                                    <p class="text-gray-600">Hardé, Maroua</p>
                                    <p class="text-gray-600">Près du commissariat du 1er arrondissement</p>
                                    <p class="text-gray-600">Cameroun</p>
                                </div>
                            </div>

                            <!-- Phone -->
                            <div class="flex items-start space-x-4">
                                <div class="bg-green-100 rounded-lg p-3 flex-shrink-0">
                                    <i class="fas fa-phone text-green-600 text-xl"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold text-gray-800 mb-1">Téléphone</h3>
                                    <a href="tel:+237691805321" class="text-gray-600 hover:text-teal-600 block">+237 691 805 321</a>
                                    <a href="tel:+237672277579" class="text-gray-600 hover:text-teal-600 block">+237 672 277 579</a>
                                </div>
                            </div>

                            <!-- Email -->
                            <div class="flex items-start space-x-4">
                                <div class="bg-blue-100 rounded-lg p-3 flex-shrink-0">
                                    <i class="fas fa-envelope text-blue-600 text-xl"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold text-gray-800 mb-1">Email</h3>
                                    <a href="mailto:contact@mit.cm" class="text-gray-600 hover:text-teal-600">contact@mit.cm</a>
                                </div>
                            </div>

                            <!-- Hours -->
                            <div class="flex items-start space-x-4">
                                <div class="bg-yellow-100 rounded-lg p-3 flex-shrink-0">
                                    <i class="fas fa-clock text-yellow-600 text-xl"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold text-gray-800 mb-1">Horaires</h3>
                                    <p class="text-gray-600">Lundi - Vendredi: 8h - 16h</p>
                                    <p class="text-gray-600 text-sm italic">Rendez-vous sur demande</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Social Media -->
                    <div class="bg-gradient-to-br from-teal-600 to-green-600 rounded-2xl shadow-xl p-8 text-white">
                        <h3 class="text-2xl font-bold mb-6">
                            <i class="fas fa-share-alt mr-3"></i>
                            Suivez-nous
                        </h3>
                        <div class="space-y-4">
                            <a href="https://github.com/Maroua-Innovation-Technology" target="_blank" class="flex items-center space-x-3 hover:bg-white/10 p-3 rounded-lg transition">
                                <i class="fab fa-github text-2xl"></i>
                                <span>GitHub</span>
                            </a>
                            <a href="https://www.linkedin.com/company/maroua-it/" target="_blank" class="flex items-center space-x-3 hover:bg-white/10 p-3 rounded-lg transition">
                                <i class="fab fa-linkedin text-2xl"></i>
                                <span>LinkedIn</span>
                            </a>
                            <a href="https://web.facebook.com/profile.php?id=61572934537559&locale=fr_FR#" target="_blank" class="flex items-center space-x-3 hover:bg-white/10 p-3 rounded-lg transition">
                                <i class="fab fa-facebook text-2xl"></i>
                                <span>Facebook</span>
                            </a>
                        </div>
                    </div>

                    <!-- Map (Optional) -->
                    <div class="bg-white rounded-2xl shadow-xl p-8">
                        <h3 class="text-xl font-bold text-gray-800 mb-4">
                            <i class="fas fa-building text-teal-600 mr-2"></i>
                            Maroua Innovation Technology
                        </h3>
                        <p class="text-gray-600 mb-4">
                            Nous sommes une entreprise technologique basée à Maroua, spécialisée dans le développement de solutions innovantes pour améliorer la vie quotidienne.
                        </p>
                        <a href="/" class="inline-flex items-center text-teal-600 hover:text-teal-700 font-semibold">
                            <i class="fas fa-arrow-right mr-2"></i>En savoir plus
                        </a>
                    </div>
                </div>

            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="bg-gray-900 text-white py-8">
        <div class="container mx-auto px-4 text-center">
            <p class="text-gray-400">© {{ date('Y') }} Maroua Innovation Technology. Tous droits réservés.</p>
        </div>
    </footer>
</body>
</html>
