# Pharmacie de Garde Maroua - Application Mobile

Application mobile Android moderne développée avec Jetpack Compose pour trouver les pharmacies de garde à Maroua, Cameroun.

## 🎨 Fonctionnalités

- ✅ **Liste des pharmacies** : Affichage de toutes les pharmacies avec informations détaillées
- ✅ **Pharmacies de garde** : Identification instantanée des pharmacies de garde actuelles
- ✅ **Recherche intelligente** : Recherche par nom, adresse ou quartier
- ✅ **Carte interactive** : Visualisation sur Google Maps avec marqueurs
- ✅ **Géolocalisation** : Pharmacies à proximité de votre position
- ✅ **Détails complets** : Informations de contact, horaires, services et accessibilité
- ✅ **Appel direct** : Bouton d'appel intégré
- ✅ **Itinéraire GPS** : Navigation vers la pharmacie sélectionnée
- ✅ **UI moderne** : Material Design 3 avec thème vert pharmacy

## 📱 Captures d'écran

L'application offre une interface utilisateur moderne et intuitive avec :
- Écran d'accueil avec pharmacies de garde en priorité
- Recherche en temps réel
- Carte interactive avec marqueurs
- Pages de détails riches en informations
- Animations fluides et transitions élégantes

## 🛠️ Technologies utilisées

- **Jetpack Compose** : UI moderne et déclarative
- **Material Design 3** : Design system moderne
- **Hilt** : Injection de dépendances
- **Retrofit** : Client HTTP pour l'API REST
- **Coroutines & Flow** : Programmation asynchrone
- **Navigation Compose** : Navigation entre écrans
- **Google Maps Compose** : Intégration Google Maps
- **Coil** : Chargement d'images
- **MVVM Architecture** : Architecture propre et maintenable

## 🚀 Installation

### Prérequis

- Android Studio Hedgehog ou supérieur
- JDK 17
- Android SDK 24+ (Android 7.0+)
- Clé API Google Maps

### Configuration

1. **Cloner le projet**

```bash
git clone <repository-url>
cd PhamarcieGarde/mobile-app
```

2. **Configurer Google Maps**

Obtenez une clé API Google Maps :
- Visitez https://console.cloud.google.com/
- Créez un nouveau projet ou utilisez un existant
- Activez "Maps SDK for Android"
- Créez une clé API

Modifiez le fichier `secrets.properties` :
```properties
MAPS_API_KEY=votre_cle_api_google_maps
```

3. **Configurer l'URL du backend**

Dans `app/src/main/java/com/maroua/pharmaciegarde/di/NetworkModule.kt`, modifiez l'URL selon votre environnement :

```kotlin
// Pour l'émulateur Android Studio
private const val BASE_URL = "http://10.0.2.2:8000/api/"

// Pour un appareil physique, remplacez par l'IP de votre PC
private const val BASE_URL = "http://192.168.1.X:8000/api/"
```

4. **Synchroniser et compiler**

```bash
# Dans Android Studio
File > Sync Project with Gradle Files
Build > Make Project
```

5. **Lancer l'application**

- Connectez un appareil Android ou démarrez un émulateur
- Cliquez sur Run (▶️) dans Android Studio

## 📁 Structure du projet

```
app/
├── src/main/java/com/maroua/pharmaciegarde/
│   ├── data/
│   │   ├── model/           # Modèles de données (Pharmacy, Schedule)
│   │   ├── remote/          # API Service (Retrofit)
│   │   └── repository/      # Repository pattern
│   ├── di/                  # Dependency Injection (Hilt)
│   ├── ui/
│   │   ├── components/      # Composables réutilisables
│   │   ├── navigation/      # Navigation graph
│   │   ├── screens/         # Écrans de l'app
│   │   │   ├── home/        # Écran d'accueil
│   │   │   ├── details/     # Détails d'une pharmacie
│   │   │   ├── search/      # Recherche
│   │   │   └── map/         # Carte interactive
│   │   ├── theme/           # Thème Material Design 3
│   │   └── viewmodel/       # ViewModels
│   ├── MainActivity.kt      # Activité principale
│   └── PharmacieGardeApplication.kt
└── AndroidManifest.xml
```

## 🏗️ Architecture

L'application suit une **architecture MVVM (Model-View-ViewModel)** avec :

- **Model** : Modèles de données et Repository pour l'accès aux données
- **View** : Composables Jetpack Compose
- **ViewModel** : Gestion de l'état et logique métier

### Flux de données

```
UI (Composable)
    ↓
ViewModel (State Management)
    ↓
Repository (Business Logic)
    ↓
API Service (Network Calls)
    ↓
Backend Laravel
```

## 🎨 Thème et Design

L'application utilise un **thème vert** inspiré des pharmacies avec :
- Couleur principale : Vert pharmacy (#00796B)
- Couleur secondaire : Gris-vert (#004D40)
- Material Design 3 pour une UI moderne
- Animations et transitions fluides
- Support du mode sombre (en développement)

## 🔐 Permissions

L'application nécessite les permissions suivantes :

- `INTERNET` : Communication avec l'API backend
- `ACCESS_FINE_LOCATION` : Géolocalisation précise
- `ACCESS_COARSE_LOCATION` : Géolocalisation approximative
- `CALL_PHONE` : Appel direct des pharmacies

## 📲 Fonctionnalités détaillées

### Écran d'accueil
- Section hero avec gradient
- Liste des pharmacies de garde
- Liste de toutes les pharmacies
- Badges visuels pour les services (24h, parking, PMR)

### Recherche
- Recherche en temps réel
- Filtrage par nom, adresse, quartier
- Résultats instantanés

### Carte
- Marqueurs pour chaque pharmacie
- Carte interactive Google Maps
- Centrage sur la position de l'utilisateur
- Sélection de pharmacie depuis la carte

### Détails
- Informations complètes
- Appel direct
- Itinéraire GPS
- Horaires de garde
- Services et accessibilité

## 🧪 Tests

```bash
# Tests unitaires
./gradlew test

# Tests d'instrumentation
./gradlew connectedAndroidTest
```

## 📦 Build de production

```bash
# Build APK
./gradlew assembleRelease

# Build App Bundle
./gradlew bundleRelease
```

Les fichiers générés seront dans :
- APK : `app/build/outputs/apk/release/`
- AAB : `app/build/outputs/bundle/release/`

## 🚧 Améliorations futures

- [ ] Mode sombre complet
- [ ] Notifications pour les pharmacies de garde
- [ ] Favoris et historique
- [ ] Partage de localisation de pharmacie
- [ ] Support multilingue (Français, Anglais)
- [ ] Filtres avancés
- [ ] Évaluations et commentaires
- [ ] Cache hors ligne

## 🤝 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Fork le projet
2. Créez une branche (`git checkout -b feature/AmazingFeature`)
3. Commit vos changements (`git commit -m 'Add AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

## 📄 License

MIT License - Libre d'utilisation pour le projet Pharmacie de Garde Maroua

## 👥 Contact

Projet développé pour faciliter l'accès aux pharmacies de garde à Maroua, Cameroun.

---

**Fait avec ❤️ et Jetpack Compose**
