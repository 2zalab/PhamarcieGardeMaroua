package com.maroua.pharmaciegarde.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager
import com.maroua.pharmaciegarde.ui.screens.auth.LoginScreen
import com.maroua.pharmaciegarde.ui.screens.main.MainScreen
import com.maroua.pharmaciegarde.ui.screens.onboarding.OnboardingScreen
import com.maroua.pharmaciegarde.ui.screens.splash.SplashScreen
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class RootDestination(val route: String) {
    object Splash : RootDestination("splash")
    object Onboarding : RootDestination("onboarding")
    object Login : RootDestination("login")
    object Main : RootDestination("main")
}

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel = hiltViewModel(),
    userPreferencesManager: UserPreferencesManager
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    // Observer l'état de connexion en temps réel
    val isUserSignedIn by authViewModel.isUserSignedInFlow().collectAsState(initial = false)

    // Observer les préférences utilisateur
    val userPreferences by userPreferencesManager.userPreferencesFlow.collectAsState(
        initial = com.maroua.pharmaciegarde.data.local.UserPreferences()
    )

    NavHost(
        navController = navController,
        startDestination = RootDestination.Splash.route
    ) {
        // Splash Screen
        composable(RootDestination.Splash.route) {
            SplashScreen(
                onTimeout = {
                    // Vérifier si l'utilisateur a complété l'onboarding
                    if (!userPreferences.hasCompletedOnboarding) {
                        navController.navigate(RootDestination.Onboarding.route) {
                            popUpTo(RootDestination.Splash.route) { inclusive = true }
                        }
                    } else if (isUserSignedIn) {
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

        // Onboarding Screen
        composable(RootDestination.Onboarding.route) {
            OnboardingScreen(
                onFinished = {
                    // Marquer l'onboarding comme complété
                    scope.launch {
                        userPreferencesManager.setOnboardingCompleted()
                    }
                    // Naviguer vers Login ou Main selon l'état de connexion
                    if (isUserSignedIn) {
                        navController.navigate(RootDestination.Main.route) {
                            popUpTo(RootDestination.Onboarding.route) { inclusive = true }
                        }
                    } else {
                        navController.navigate(RootDestination.Login.route) {
                            popUpTo(RootDestination.Onboarding.route) { inclusive = true }
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
