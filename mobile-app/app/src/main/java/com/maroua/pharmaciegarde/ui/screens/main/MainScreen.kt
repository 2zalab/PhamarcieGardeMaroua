package com.maroua.pharmaciegarde.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.ui.screens.allpharmacies.AllPharmaciesScreen
import com.maroua.pharmaciegarde.ui.screens.auth.LoginScreen
import com.maroua.pharmaciegarde.ui.screens.details.PharmacyDetailsScreen
import com.maroua.pharmaciegarde.ui.screens.favorites.FavoritesScreen
import com.maroua.pharmaciegarde.ui.screens.home.HomeScreen
import com.maroua.pharmaciegarde.ui.screens.map.MapScreen
import com.maroua.pharmaciegarde.ui.screens.search.SearchScreen
import com.maroua.pharmaciegarde.ui.screens.settings.SettingsScreen
import androidx.hilt.navigation.compose.hiltViewModel

// Destinations de la BottomNavigationBar
sealed class BottomNavDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavDestination("home", "Accueil", Icons.Default.Home)
    object AllPharmacies : BottomNavDestination("all_pharmacies", "Pharmacies", Icons.Default.LocalPharmacy)
    object Favorites : BottomNavDestination("favorites", "Favoris", Icons.Default.Favorite)
    object Settings : BottomNavDestination("settings", "Paramètres", Icons.Default.Settings)
}

// Autres destinations (hors bottom nav)
sealed class AppDestination(val route: String) {
    object Login : AppDestination("login")
    object Map : AppDestination("map")
    object Search : AppDestination("search")
    object Details : AppDestination("details/{pharmacyId}") {
        fun createRoute(pharmacyId: Int) = "details/$pharmacyId"
    }
}

@Composable
fun MainScreen(
    authViewModel: com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentUser by authViewModel.currentUser.collectAsState()

    // Liste des destinations de la bottom bar
    val bottomNavDestinations = listOf(
        BottomNavDestination.Home,
        BottomNavDestination.AllPharmacies,
        BottomNavDestination.Favorites,
        BottomNavDestination.Settings
    )

    // Détermine si la bottom bar doit être affichée
    val showBottomBar = currentDestination?.route in bottomNavDestinations.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    bottomNavDestinations.forEach { destination ->
                        val selected = currentDestination?.hierarchy?.any {
                            it.route == destination.route
                        } == true

                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = destination.icon,
                                    contentDescription = destination.title
                                )
                            },
                            label = { Text(destination.title) },
                            selected = selected,
                            onClick = {
                                // Si l'utilisateur n'est pas connecté et qu'il essaie d'accéder aux favoris
                                if (destination == BottomNavDestination.Favorites && currentUser == null) {
                                    navController.navigate(AppDestination.Login.route)
                                } else {
                                    navController.navigate(destination.route) {
                                        // Pop to start destination pour éviter l'accumulation
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Éviter plusieurs copies de la même destination
                                        launchSingleTop = true
                                        // Actualiser la page à chaque clic (pas de restoreState)
                                        restoreState = false
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavDestination.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            // Home Screen
            composable(BottomNavDestination.Home.route) {
                HomeScreen(
                    onPharmacyClick = { pharmacy ->
                        navController.navigate(AppDestination.Details.createRoute(pharmacy.id))
                    },
                    onMapClick = {
                        navController.navigate(AppDestination.Map.route)
                    },
                    onSearchClick = {
                        navController.navigate(AppDestination.Search.route)
                    },
                    currentUserName = currentUser?.name
                )
            }

            // All Pharmacies Screen
            composable(BottomNavDestination.AllPharmacies.route) {
                AllPharmaciesScreen(
                    onPharmacyClick = { pharmacy ->
                        navController.navigate(AppDestination.Details.createRoute(pharmacy.id))
                    },
                    onSearchClick = {
                        navController.navigate(AppDestination.Search.route)
                    }
                )
            }

            // Favorites Screen
            composable(BottomNavDestination.Favorites.route) {
                FavoritesScreen(
                    onPharmacyClick = { pharmacy ->
                        navController.navigate(AppDestination.Details.createRoute(pharmacy.id))
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            // Settings Screen
            composable(BottomNavDestination.Settings.route) {
                SettingsScreen(
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onLoginClick = {
                        navController.navigate(AppDestination.Login.route)
                    }
                )
            }

            // Map Screen (pas dans bottom nav - accessible depuis Home)
            composable(AppDestination.Map.route) {
                MapScreen(
                    onPharmacyClick = { pharmacy ->
                        navController.navigate(AppDestination.Details.createRoute(pharmacy.id))
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            // Search Screen (pas dans bottom nav)
            composable(AppDestination.Search.route) {
                SearchScreen(
                    onPharmacyClick = { pharmacy ->
                        navController.navigate(AppDestination.Details.createRoute(pharmacy.id))
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            // Details Screen (pas dans bottom nav)
            composable(
                route = AppDestination.Details.route,
                arguments = listOf(navArgument("pharmacyId") { type = NavType.IntType })
            ) { backStackEntry ->
                val pharmacyId = backStackEntry.arguments?.getInt("pharmacyId") ?: return@composable
                PharmacyDetailsScreen(
                    pharmacyId = pharmacyId,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            // Login Screen
            composable(AppDestination.Login.route) {
                LoginScreen(
                    onLoginSuccess = {
                        // Navigate back to where they came from or home
                        navController.popBackStack()
                    },
                    onContinueAsGuest = {
                        // Retour à l'écran précédent
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
