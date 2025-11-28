package com.maroua.pharmaciegarde.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.maroua.pharmaciegarde.ui.screens.home.HomeScreen
import com.maroua.pharmaciegarde.ui.screens.details.PharmacyDetailsScreen
import com.maroua.pharmaciegarde.ui.screens.map.MapScreen
import com.maroua.pharmaciegarde.ui.screens.search.SearchScreen
import com.maroua.pharmaciegarde.ui.screens.subscription.SubscriptionScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Map : Screen("map")
    object Search : Screen("search")
    object Subscription : Screen("subscription")
    object Details : Screen("details/{pharmacyId}") {
        fun createRoute(pharmacyId: Int) = "details/$pharmacyId"
    }
}

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onPharmacyClick = { pharmacy ->
                    navController.navigate(Screen.Details.createRoute(pharmacy.id))
                },
                onMapClick = {
                    navController.navigate(Screen.Map.route)
                },
                onSearchClick = {
                    navController.navigate(Screen.Search.route)
                }
            )
        }

        composable(Screen.Map.route) {
            MapScreen(
                onPharmacyClick = { pharmacy ->
                    navController.navigate(Screen.Details.createRoute(pharmacy.id))
                },
                onBackClick = {
                    navController.popBackStack()
                },
                onUpgradeClick = {
                    navController.navigate(Screen.Subscription.route)
                }
            )
        }

        composable(Screen.Subscription.route) {
            SubscriptionScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Search.route) {
            SearchScreen(
                onPharmacyClick = { pharmacy ->
                    navController.navigate(Screen.Details.createRoute(pharmacy.id))
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.Details.route,
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
    }
}
