package com.maroua.pharmaciegarde.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maroua.pharmaciegarde.ui.screens.auth.LoginScreen
import com.maroua.pharmaciegarde.ui.screens.main.MainScreen
import com.maroua.pharmaciegarde.ui.screens.splash.SplashScreen
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel

sealed class RootDestination(val route: String) {
    object Splash : RootDestination("splash")
    object Login : RootDestination("login")
    object Main : RootDestination("main")
}

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    // Observer l'état de connexion en temps réel
    val isUserSignedIn by authViewModel.isUserSignedInFlow().collectAsState(initial = false)

    NavHost(
        navController = navController,
        startDestination = RootDestination.Splash.route
    ) {
        // Splash Screen
        composable(RootDestination.Splash.route) {
            SplashScreen(
                onTimeout = {
                    // Après délai, vérifier si l'utilisateur est connecté
                    if (isUserSignedIn) {
                        navController.navigate(RootDestination.Main.route) {
                            popUpTo(RootDestination.Splash.route) { inclusive = true }
                        }
                    } else {
                        navController.navigate(RootDestination.Login.route) {
                            popUpTo(RootDestination.Splash.route) { inclusive = true }
                        }
                    }
                }
            )
        }

        // Login Screen
        composable(RootDestination.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(RootDestination.Main.route) {
                        popUpTo(RootDestination.Login.route) { inclusive = true }
                    }
                },
                onContinueAsGuest = {
                    navController.navigate(RootDestination.Main.route) {
                        popUpTo(RootDestination.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // Main Screen (avec BottomNav)
        composable(RootDestination.Main.route) {
            MainScreen()
        }
    }
}
