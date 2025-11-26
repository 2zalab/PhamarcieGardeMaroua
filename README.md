# 💊 Pharmacie de Garde Maroua

Application mobile complète pour trouver les pharmacies de garde à Maroua, Cameroun. Le projet comprend un backend Laravel robuste et une application mobile Android moderne développée avec Jetpack Compose.

## 🌟 Présentation

Ce projet vise à faciliter l'accès aux pharmacies de garde pour les habitants de Maroua. Il permet de :
- Trouver rapidement les pharmacies de garde actuelles
- Localiser les pharmacies sur une carte interactive
- Obtenir les informations de contact et itinéraires
- Rechercher des pharmacies par nom, adresse ou quartier

## 📦 Structure du projet

```
PhamarcieGarde/
├── backend/              # API REST Laravel
│   ├── app/
│   │   ├── Models/      # Modèles Eloquent
│   │   └── Http/Controllers/Api/
│   ├── database/
│   │   ├── migrations/  # Migrations de BDD
│   │   └── seeders/     # Données de test
│   └── routes/api.php   # Routes API
│
└── mobile-app/          # Application Android Jetpack Compose
    ├── app/
    │   └── src/main/
    │       ├── java/com/maroua/pharmaciegarde/
    │       │   ├── data/      # Modèles et Repository
    │       │   ├── di/        # Dependency Injection
    │       │   └── ui/        # Interface utilisateur
    │       └── res/           # Ressources Android
    └── build.gradle.kts
```

## 🚀 Démarrage rapide

### Backend Laravel

```bash
cd backend
composer install
cp .env.example .env
php artisan key:generate

# Configurer la BDD dans .env
php artisan migrate --seed
php artisan serve
```

L'API sera disponible sur `http://localhost:8000`

### Application Mobile

```bash
cd mobile-app
# Ouvrir dans Android Studio
# Configurer Google Maps API Key dans secrets.properties
# Sync & Run
```

## 🎯 Fonctionnalités principales

### Backend (Laravel)
- ✅ API REST complète
- ✅ Gestion des pharmacies et horaires de garde
- ✅ Recherche et filtrage
- ✅ Calcul de distance géographique
- ✅ Seeders avec données de test pour Maroua
- ✅ Documentation API complète

### Application Mobile (Android)
- ✅ UI moderne avec Material Design 3
- ✅ Architecture MVVM propre
- ✅ Navigation fluide entre écrans
- ✅ Intégration Google Maps
- ✅ Géolocalisation
- ✅ Recherche en temps réel
- ✅ Appel direct et itinéraire GPS
- ✅ Thème vert pharmacy

## 📱 Captures d'écran

L'application offre :
- 🏠 **Écran d'accueil** : Pharmacies de garde et liste complète
- 🔍 **Recherche** : Recherche intelligente et filtres
- 🗺️ **Carte** : Visualisation interactive avec marqueurs
- 📄 **Détails** : Informations complètes et actions rapides

## 🛠️ Technologies

### Backend
- Laravel 10
- PHP 8.1+
- MySQL/MariaDB
- RESTful API

### Mobile
- Kotlin
- Jetpack Compose
- Material Design 3
- Hilt (DI)
- Retrofit
- Coroutines & Flow
- Google Maps
- MVVM Architecture

## 📚 Documentation

- [Documentation Backend](./backend/README.md)
- [Documentation Mobile](./mobile-app/README.md)

## 🔗 API Endpoints

```
GET  /api/pharmacies              # Toutes les pharmacies
GET  /api/pharmacies/on-duty      # Pharmacies de garde
GET  /api/pharmacies/nearby       # Pharmacies à proximité
GET  /api/pharmacies/{id}         # Détails d'une pharmacie
```

## 🌍 Données incluses

Le projet inclut des données de test pour 8 pharmacies de Maroua dans différents quartiers :
- Centre-ville
- Domayo
- Dougoy
- Pitoaré
- Hardé
- Founangué
- Bamaré

Chaque pharmacie comprend :
- Coordonnées GPS précises
- Numéros de téléphone
- Horaires de garde
- Services (parking, accessibilité PMR, ouverture 24h)

## ⚙️ Configuration

### Backend
1. Configurer `.env` avec les paramètres de base de données
2. Exécuter les migrations et seeders
3. Lancer le serveur Laravel

### Mobile
1. Obtenir une clé API Google Maps
2. Configurer `secrets.properties`
3. Ajuster l'URL du backend dans `NetworkModule.kt`
4. Compiler et exécuter

## 🧪 Tests

### Backend
```bash
php artisan test
```

### Mobile
```bash
./gradlew test
./gradlew connectedAndroidTest
```

## 📈 Améliorations futures

- [ ] Panel d'administration web
- [ ] Notifications push pour les changements de garde
- [ ] Mode hors ligne avec cache
- [ ] Système d'évaluation des pharmacies
- [ ] Support multilingue (Français, Anglais, Fulfuldé)
- [ ] Application iOS
- [ ] Intégration avec d'autres villes du Cameroun
- [ ] API publique pour développeurs tiers

## 🤝 Contribution

Les contributions sont les bienvenues ! Voir [CONTRIBUTING.md](./CONTRIBUTING.md) pour les détails.

## 📄 License

MIT License - Voir [LICENSE](./LICENSE) pour plus de détails

## 👨‍💻 Développement

Ce projet a été créé pour servir la communauté de Maroua et faciliter l'accès aux soins de santé d'urgence.

### Auteur
Projet développé avec ❤️ pour les habitants de Maroua

### Support
Pour toute question ou problème, ouvrez une issue sur GitHub.

---

## 🙏 Remerciements

Merci à :
- La communauté Laravel
- L'équipe Android et Jetpack Compose
- Les pharmacies de Maroua pour leur service

---

**Made with ❤️ in Cameroon 🇨🇲**
