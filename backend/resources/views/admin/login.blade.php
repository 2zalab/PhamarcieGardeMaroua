<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion Admin - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gradient-to-br from-teal-50 to-green-50 min-h-screen">
    <div class="min-h-screen flex">
        <!-- Left Side - Image/Illustration -->
        <div class="hidden lg:flex lg:w-1/2 bg-gradient-to-br from-teal-600 to-green-600 p-12 flex-col justify-between relative overflow-hidden">
            <!-- Pattern Background -->
            <div class="absolute inset-0 opacity-10">
                <div class="absolute inset-0" style="background-image: url('data:image/svg+xml,%3Csvg width=\'60\' height=\'60\' viewBox=\'0 0 60 60\' xmlns=\'http://www.w3.org/2000/svg\'%3E%3Cg fill=\'none\' fill-rule=\'evenodd\'%3E%3Cg fill=\'%23ffffff\' fill-opacity=\'1\'%3E%3Cpath d=\'M36 34v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zm0-30V0h-2v4h-4v2h4v4h2V6h4V4h-4zM6 34v-4H4v4H0v2h4v4h2v-4h4v-2H6zM6 4V0H4v4H0v2h4v4h2V6h4V4H6z\'/%3E%3C/g%3E%3C/g%3E%3C/svg%3E');"></div>
            </div>

            <!-- Content -->
            <div class="relative z-10">
                <div class="flex items-center space-x-3 mb-8">
                    <div class="bg-white rounded-xl p-3 shadow-lg">
                        <i class="fas fa-pills text-3xl text-teal-600"></i>
                    </div>
                    <div>
                        <h1 class="text-2xl font-bold text-white">Pharmacie de Garde</h1>
                        <p class="text-teal-100">Maroua</p>
                    </div>
                </div>
            </div>

            <div class="relative z-10">
                <div class="bg-white/10 backdrop-blur-sm rounded-2xl p-8 border border-white/20">
                    <i class="fas fa-hospital text-6xl text-white mb-6"></i>
                    <h2 class="text-3xl font-bold text-white mb-4">
                        Gérez votre plateforme en toute simplicité
                    </h2>
                    <p class="text-teal-100 text-lg mb-6">
                        Accédez au tableau de bord administrateur pour gérer les pharmacies,
                        les horaires de garde, et suivre les évaluations des utilisateurs.
                    </p>
                    <div class="space-y-3">
                        <div class="flex items-center space-x-3">
                            <div class="bg-white/20 rounded-lg p-2">
                                <i class="fas fa-check text-white"></i>
                            </div>
                            <span class="text-white">Gestion des pharmacies en temps réel</span>
                        </div>
                        <div class="flex items-center space-x-3">
                            <div class="bg-white/20 rounded-lg p-2">
                                <i class="fas fa-check text-white"></i>
                            </div>
                            <span class="text-white">Planification des horaires de garde</span>
                        </div>
                        <div class="flex items-center space-x-3">
                            <div class="bg-white/20 rounded-lg p-2">
                                <i class="fas fa-check text-white"></i>
                            </div>
                            <span class="text-white">Statistiques et analyses détaillées</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="relative z-10">
                <p class="text-teal-100 text-sm">
                    © {{ date('Y') }} Pharmacie de Garde Maroua. Tous droits réservés.
                </p>
            </div>
        </div>

        <!-- Right Side - Login Form -->
        <div class="w-full lg:w-1/2 flex items-center justify-center p-8">
            <div class="w-full max-w-md">
                <!-- Logo Mobile -->
                <div class="lg:hidden mb-8 text-center">
                    <div class="inline-flex items-center justify-center w-16 h-16 bg-teal-600 rounded-xl mb-4">
                        <i class="fas fa-pills text-2xl text-white"></i>
                    </div>
                    <h1 class="text-2xl font-bold text-gray-800">Pharmacie de Garde</h1>
                    <p class="text-gray-600">Maroua</p>
                </div>

                <!-- Login Card -->
                <div class="bg-white rounded-2xl shadow-2xl p-8">
                    <div class="mb-8">
                        <h2 class="text-3xl font-bold text-gray-800 mb-2">Bienvenue!</h2>
                        <p class="text-gray-600">Connectez-vous à votre espace administrateur</p>
                    </div>

                    <!-- Messages -->
                    @if(session('error'))
                        <div class="mb-6 bg-red-50 border-l-4 border-red-500 p-4 rounded-r-lg">
                            <div class="flex items-center">
                                <i class="fas fa-exclamation-circle text-red-500 mr-3"></i>
                                <p class="text-red-700">{{ session('error') }}</p>
                            </div>
                        </div>
                    @endif

                    @if(session('success'))
                        <div class="mb-6 bg-green-50 border-l-4 border-green-500 p-4 rounded-r-lg">
                            <div class="flex items-center">
                                <i class="fas fa-check-circle text-green-500 mr-3"></i>
                                <p class="text-green-700">{{ session('success') }}</p>
                            </div>
                        </div>
                    @endif

                    <!-- Login Form -->
                    <form action="{{ route('admin.login.submit') }}" method="POST" class="space-y-6">
                        @csrf

                        <!-- Email -->
                        <div>
                            <label for="email" class="block text-sm font-medium text-gray-700 mb-2">
                                <i class="fas fa-envelope mr-2 text-teal-600"></i>Adresse email
                            </label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                value="{{ old('email') }}"
                                required
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent transition duration-200"
                                placeholder="votre@email.com"
                            >
                            @error('email')
                                <p class="mt-1 text-sm text-red-600">{{ $message }}</p>
                            @enderror
                        </div>

                        <!-- Password -->
                        <div>
                            <label for="password" class="block text-sm font-medium text-gray-700 mb-2">
                                <i class="fas fa-lock mr-2 text-teal-600"></i>Mot de passe
                            </label>
                            <input
                                type="password"
                                id="password"
                                name="password"
                                required
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-teal-500 focus:border-transparent transition duration-200"
                                placeholder="••••••••"
                            >
                            @error('password')
                                <p class="mt-1 text-sm text-red-600">{{ $message }}</p>
                            @enderror
                        </div>

                        <!-- Submit Button -->
                        <button
                            type="submit"
                            class="w-full bg-gradient-to-r from-teal-600 to-green-600 text-white py-3 rounded-lg font-semibold hover:from-teal-700 hover:to-green-700 transition duration-200 shadow-lg hover:shadow-xl transform hover:-translate-y-0.5"
                        >
                            <i class="fas fa-sign-in-alt mr-2"></i>Se connecter
                        </button>
                    </form>

                    <!-- Back to Home -->
                    <div class="mt-6 text-center">
                        <a href="/" class="text-teal-600 hover:text-teal-700 text-sm font-medium">
                            <i class="fas fa-arrow-left mr-2"></i>Retour à l'accueil
                        </a>
                    </div>
                </div>

                <!-- Info Text -->
                <div class="mt-6 text-center text-gray-600 text-sm">
                    <p>Besoin d'aide? Contactez le support technique</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
