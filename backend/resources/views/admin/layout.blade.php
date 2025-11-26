<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>@yield('title', 'Admin') - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <nav class="bg-teal-700 text-white shadow-lg">
        <div class="container mx-auto px-4 py-4">
            <div class="flex items-center justify-between">
                <h1 class="text-2xl font-bold">
                    <a href="{{ route('admin.dashboard') }}">💊 Pharmacie de Garde - Admin</a>
                </h1>
                <div class="flex space-x-4">
                    <a href="{{ route('admin.dashboard') }}" class="hover:text-teal-200">Tableau de bord</a>
                    <a href="{{ route('admin.pharmacies') }}" class="hover:text-teal-200">Pharmacies</a>
                    <a href="{{ route('admin.schedules') }}" class="hover:text-teal-200">Horaires</a>
                    <a href="{{ route('admin.ratings') }}" class="hover:text-teal-200">Évaluations</a>
                    <a href="/" target="_blank" class="hover:text-teal-200">API</a>
                </div>
            </div>
        </div>
    </nav>

    <main class="container mx-auto px-4 py-8">
        @if(session('success'))
            <div class="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded mb-4">
                {{ session('success') }}
            </div>
        @endif

        @if(session('error'))
            <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
                {{ session('error') }}
            </div>
        @endif

        @yield('content')
    </main>

    <footer class="bg-gray-800 text-white text-center py-4 mt-12">
        <p>&copy; {{ date('Y') }} Pharmacie de Garde Maroua - Panel d'administration</p>
    </footer>
</body>
</html>
