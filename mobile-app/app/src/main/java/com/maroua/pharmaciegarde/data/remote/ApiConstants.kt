package com.maroua.pharmaciegarde.data.remote

object ApiConstants {
    // Pour l'émulateur Android Studio
    const val BASE_URL_EMULATOR = "http://10.0.2.2:8000/api/"

    // Pour un appareil physique sur le même réseau
    // Remplacer par l'adresse IP de votre ordinateur
    const val BASE_URL_DEVICE = "http://192.168.1.X:8000/api/"

    // Pour la production
    const val BASE_URL_PRODUCTION = "https://votre-domaine.com/api/"
}
