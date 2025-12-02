<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
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
                        <span class="text-xs text-gray-500 block">Contact</span>
                    </div>
                </a>
                <div class="flex items-center space-x-4">
                    <a href="/" class="text-gray-700 hover:text-teal-600 transition">
                        <i class="fas fa-arrow-left mr-2"></i>Accueil
                    </a>
                    <a href="{{ route('admin.login') }}" class="bg-teal-600 text-white px-4 py-2 rounded-lg hover:bg-teal-700 transition">
                        <i class="fas fa-user-shield mr-2"></i>Admin
                    </a>
                </div>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="pt-16">
        <div class="max-w-4xl mx-auto px-6 py-8 pb-20">
            <h1 class="text-4xl font-bold text-gray-900 mb-4">Contactez-nous</h1>
            <p class="text-xl text-gray-600 mb-8">
                Nous sommes à votre écoute pour toute question ou suggestion
            </p>

            <div class="grid md:grid-cols-2 gap-8">
                <!-- Contact Form -->
                <div class="bg-white rounded-lg border border-gray-200 p-6">
                    <h2 class="text-2xl font-bold text-gray-800 mb-6">Envoyer un message</h2>

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

                    <form action="{{ route('contact.send') }}" method="POST" class="space-y-4">
                        @csrf

                        <div>
                            <label for="name" class="block text-sm font-medium text-gray-700 mb-2">Nom complet *</label>
                            <input
                                type="text"
                                name="name"
                                id="name"
                                value="{{ old('name') }}"
                                required
                                class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('name') border-red-500 @enderror"
                                placeholder="Votre nom complet">
                            @error('name')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="email" class="block text-sm font-medium text-gray-700 mb-2">Email *</label>
                            <input
                                type="email"
                                name="email"
                                id="email"
                                value="{{ old('email') }}"
                                required
                                class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('email') border-red-500 @enderror"
                                placeholder="votre.email@exemple.com">
                            @error('email')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="phone" class="block text-sm font-medium text-gray-700 mb-2">Téléphone</label>
                            <input
                                type="tel"
                                name="phone"
                                id="phone"
                                value="{{ old('phone') }}"
                                class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('phone') border-red-500 @enderror"
                                placeholder="+237 6XX XX XX XX">
                            @error('phone')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="subject" class="block text-sm font-medium text-gray-700 mb-2">Sujet *</label>
                            <input
                                type="text"
                                name="subject"
                                id="subject"
                                value="{{ old('subject') }}"
                                required
                                class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('subject') border-red-500 @enderror"
                                placeholder="Sujet de votre message">
                            @error('subject')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <div>
                            <label for="message" class="block text-sm font-medium text-gray-700 mb-2">Message *</label>
                            <textarea
                                name="message"
                                id="message"
                                rows="5"
                                required
                                class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent @error('message') border-red-500 @enderror"
                                placeholder="Écrivez votre message ici...">{{ old('message') }}</textarea>
                            @error('message')
                                <p class="text-red-500 text-sm mt-1">{{ $message }}</p>
                            @enderror
                        </div>

                        <button
                            type="submit"
                            class="w-full bg-teal-600 text-white px-4 py-2 rounded-lg hover:bg-teal-700 transition">
                            <i class="fas fa-paper-plane mr-2"></i>Envoyer le message
                        </button>
                    </form>
                </div>

                <!-- Contact Information -->
                <div class="space-y-6">
                    <!-- Info Card -->
                    <div class="bg-white rounded-lg border border-gray-200 p-6">
                        <h2 class="text-2xl font-bold text-gray-800 mb-6">Nos Coordonnées</h2>

                        <div class="space-y-4">
                            <!-- Address -->
                            <div>
                                <h3 class="font-semibold text-gray-800 mb-1 text-sm">
                                    <i class="fas fa-map-marker-alt text-teal-600 mr-2"></i>Adresse
                                </h3>
                                <p class="text-gray-600 text-sm ml-6">Hardé, Maroua<br>
                                Près du commissariat du 1er arrondissement<br>
                                Cameroun</p>
                            </div>

                            <!-- Phone -->
                            <div>
                                <h3 class="font-semibold text-gray-800 mb-1 text-sm">
                                    <i class="fas fa-phone text-teal-600 mr-2"></i>Téléphone
                                </h3>
                                <div class="ml-6 text-sm">
                                    <a href="tel:+237691805321" class="text-teal-600 hover:text-teal-700 block">+237 691 805 321</a>
                                    <a href="tel:+237672277579" class="text-teal-600 hover:text-teal-700 block">+237 672 277 579</a>
                                </div>
                            </div>

                            <!-- Email -->
                            <div>
                                <h3 class="font-semibold text-gray-800 mb-1 text-sm">
                                    <i class="fas fa-envelope text-teal-600 mr-2"></i>Email
                                </h3>
                                <a href="mailto:contact@mit.cm" class="text-teal-600 hover:text-teal-700 ml-6 text-sm">contact@mit.cm</a>
                            </div>

                            <!-- Hours -->
                            <div>
                                <h3 class="font-semibold text-gray-800 mb-1 text-sm">
                                    <i class="fas fa-clock text-teal-600 mr-2"></i>Horaires
                                </h3>
                                <p class="text-gray-600 text-sm ml-6">Lundi - Vendredi: 8h - 16h<br>
                                <span class="text-xs italic">Rendez-vous sur demande</span></p>
                            </div>
                        </div>
                    </div>

                    <!-- Social Media -->
                    <div class="bg-white rounded-lg border border-gray-200 p-6">
                        <h3 class="text-lg font-bold text-gray-800 mb-4">Suivez-nous</h3>
                        <div class="space-y-2">
                            <a href="https://github.com/Maroua-Innovation-Technology" target="_blank" class="flex items-center space-x-2 text-gray-700 hover:text-teal-600 transition text-sm">
                                <i class="fab fa-github w-5"></i>
                                <span>GitHub</span>
                            </a>
                            <a href="https://www.linkedin.com/company/maroua-it/" target="_blank" class="flex items-center space-x-2 text-gray-700 hover:text-teal-600 transition text-sm">
                                <i class="fab fa-linkedin w-5"></i>
                                <span>LinkedIn</span>
                            </a>
                            <a href="https://web.facebook.com/profile.php?id=61572934537559&locale=fr_FR#" target="_blank" class="flex items-center space-x-2 text-gray-700 hover:text-teal-600 transition text-sm">
                                <i class="fab fa-facebook w-5"></i>
                                <span>Facebook</span>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-gray-900 text-white py-6">
        <div class="px-6 text-center">
            <p class="text-gray-400 text-sm">© {{ date('Y') }} Pharmacie de Garde Maroua. Tous droits réservés.</p>
        </div>
    </footer>
</body>
</html>
