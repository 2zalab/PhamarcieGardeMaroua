<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>@yield('title', 'Admin') - Pharmacie de Garde Maroua</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-100">
    <div class="flex h-screen overflow-hidden">
        <!-- Sidebar -->
        <aside id="sidebar" class="bg-gradient-to-b from-teal-700 to-green-700 text-white w-64 fixed inset-y-0 left-0 transform transition-transform duration-200 ease-in-out z-30">
            <!-- Logo -->
            <div class="flex items-center justify-center h-20 border-b border-teal-600">
                <div class="flex items-center space-x-3">
                    <div class="bg-white rounded-xl p-2">
                        <i class="fas fa-pills text-2xl text-teal-600"></i>
                    </div>
                    <div>
                        <h1 class="text-xl font-bold">Pharmacie Garde</h1>
                        <p class="text-xs text-teal-200">Administration</p>
                    </div>
                </div>
            </div>

            <!-- Navigation -->
            <nav class="mt-6 px-4">
                <a href="{{ route('admin.dashboard') }}" class="flex items-center px-4 py-3 mb-2 rounded-lg {{ request()->routeIs('admin.dashboard') ? 'bg-white text-teal-700' : 'text-white hover:bg-teal-600' }} transition">
                    <i class="fas fa-chart-line w-6"></i>
                    <span class="ml-3">Tableau de bord</span>
                </a>

                <a href="{{ route('admin.pharmacies') }}" class="flex items-center px-4 py-3 mb-2 rounded-lg {{ request()->routeIs('admin.pharmacies*') ? 'bg-white text-teal-700' : 'text-white hover:bg-teal-600' }} transition">
                    <i class="fas fa-hospital w-6"></i>
                    <span class="ml-3">Pharmacies</span>
                </a>

                <a href="{{ route('admin.schedules') }}" class="flex items-center px-4 py-3 mb-2 rounded-lg {{ request()->routeIs('admin.schedules*') ? 'bg-white text-teal-700' : 'text-white hover:bg-teal-600' }} transition">
                    <i class="fas fa-calendar-alt w-6"></i>
                    <span class="ml-3">Horaires</span>
                </a>

                <a href="{{ route('admin.ratings') }}" class="flex items-center px-4 py-3 mb-2 rounded-lg {{ request()->routeIs('admin.ratings*') ? 'bg-white text-teal-700' : 'text-white hover:bg-teal-600' }} transition">
                    <i class="fas fa-star w-6"></i>
                    <span class="ml-3">Évaluations</span>
                </a>

                <div class="border-t border-teal-600 my-4"></div>

                <a href="/api-docs" target="_blank" class="flex items-center px-4 py-3 mb-2 rounded-lg text-white hover:bg-teal-600 transition">
                    <i class="fas fa-book w-6"></i>
                    <span class="ml-3">Documentation API</span>
                </a>

                <a href="/" target="_blank" class="flex items-center px-4 py-3 mb-2 rounded-lg text-white hover:bg-teal-600 transition">
                    <i class="fas fa-globe w-6"></i>
                    <span class="ml-3">Site Public</span>
                </a>
            </nav>

            <!-- User Section -->
            <div class="absolute bottom-0 w-64 p-4 bg-teal-800 border-t border-teal-600">
                <div class="flex items-center mb-3">
                    <div class="bg-white rounded-full p-2">
                        <i class="fas fa-user text-teal-700"></i>
                    </div>
                    <div class="ml-3">
                        <p class="text-sm font-semibold">{{ session('admin_name', 'Admin') }}</p>
                        <p class="text-xs text-teal-200">{{ session('admin_email', '') }}</p>
                    </div>
                </div>
                <form action="{{ route('admin.logout') }}" method="POST">
                    @csrf
                    <button type="submit" class="w-full flex items-center justify-center px-4 py-2 bg-red-600 hover:bg-red-700 rounded-lg transition">
                        <i class="fas fa-sign-out-alt mr-2"></i>
                        <span>Déconnexion</span>
                    </button>
                </form>
            </div>
        </aside>

        <!-- Main Content -->
        <div class="flex-1 flex flex-col overflow-hidden ml-64">
            <!-- Top Bar -->
            <header class="bg-white shadow-sm h-20 flex items-center justify-between px-6">
                <div class="flex items-center">
                    <button onclick="toggleSidebar()" class="mr-4 text-gray-600 hover:text-gray-800">
                        <i class="fas fa-bars text-xl"></i>
                    </button>
                    <h2 class="text-2xl font-semibold text-gray-800">@yield('page-title', 'Dashboard')</h2>
                </div>
                
                <div class="flex items-center space-x-4">
                    <span class="text-gray-600 text-sm">
                        <i class="far fa-clock mr-2"></i>{{ date('d/m/Y H:i') }}
                    </span>
                </div>
            </header>

            <!-- Content Area -->
            <main class="flex-1 overflow-x-hidden overflow-y-auto bg-gray-100 p-6">
                <!-- Flash Messages -->
                @if(session('success'))
                    <div class="mb-6 bg-green-50 border-l-4 border-green-500 p-4 rounded-r-lg shadow-sm">
                        <div class="flex items-center">
                            <i class="fas fa-check-circle text-green-500 text-xl mr-3"></i>
                            <p class="text-green-700">{{ session('success') }}</p>
                        </div>
                    </div>
                @endif

                @if(session('error'))
                    <div class="mb-6 bg-red-50 border-l-4 border-red-500 p-4 rounded-r-lg shadow-sm">
                        <div class="flex items-center">
                            <i class="fas fa-exclamation-circle text-red-500 text-xl mr-3"></i>
                            <p class="text-red-700">{{ session('error') }}</p>
                        </div>
                    </div>
                @endif

                @yield('content')
            </main>
        </div>
    </div>

    <script>
        function toggleSidebar() {
            const sidebar = document.getElementById('sidebar');
            sidebar.classList.toggle('-translate-x-full');
        }
    </script>
</body>
</html>
