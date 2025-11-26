# Configuration de l'authentification Google avec Laravel

## 1. Installation des dépendances

```bash
cd backend
composer require google/apiclient
composer require laravel/sanctum
```

## 2. Configuration de Google OAuth

### Obtenir les identifiants Google:

1. Allez sur [Google Cloud Console](https://console.cloud.google.com/)
2. Créez ou sélectionnez votre projet
3. Activez l'API "Google+ API"
4. Créez des identifiants OAuth 2.0
   - Type: Application Android
   - Nom du package: `com.maroua.pharmaciegarde`
   - Empreinte SHA-1 de signature

### Obtenir l'empreinte SHA-1:

```bash
cd mobile-app
./gradlew signingReport
```

### Configuration dans `.env`:

```env
GOOGLE_CLIENT_ID=votre_client_id_google.apps.googleusercontent.com
```

## 3. Migration de la base de données

```bash
php artisan migrate
```

Cela créera:
- Les champs dans `users`: `google_id`, `avatar`, `is_subscribed`, `subscription_type`, `subscription_expires_at`
- La table `favorites` pour les favoris utilisateurs

## 4. Configuration de Laravel Sanctum

Sanctum est déjà inclus avec Laravel. Assurez-vous que dans `config/sanctum.php`:

```php
'stateful' => explode(',', env('SANCTUM_STATEFUL_DOMAINS', sprintf(
    '%s%s',
    'localhost,localhost:3000,127.0.0.1,127.0.0.1:8000,::1',
    env('APP_URL') ? ','.parse_url(env('APP_URL'), PHP_URL_HOST) : ''
))),
```

## 5. Endpoints API créés

### Authentification (Public)
- `POST /api/auth/google` - Authentification avec Google ID token

### Authentification (Protégé)
- `GET /api/auth/me` - Informations utilisateur
- `POST /api/auth/logout` - Déconnexion

### Favoris (Protégé)
- `GET /api/favorites` - Liste des favoris
- `POST /api/favorites` - Ajouter un favori (body: `pharmacy_id`)
- `DELETE /api/favorites/{pharmacyId}` - Retirer un favori
- `GET /api/favorites/{pharmacyId}/check` - Vérifier si favori

## 6. Format des requêtes authentifiées

Toutes les requêtes protégées doivent inclure le header:
```
Authorization: Bearer {token}
```

Le token est retourné lors de l'authentification Google.

## 7. Exemple de flux d'authentification

### Côté Android:
1. L'utilisateur se connecte avec Google
2. Android obtient le `id_token` de Google
3. Android envoie le token à `POST /api/auth/google`

### Côté Laravel:
1. Vérifie le token avec Google
2. Crée ou met à jour l'utilisateur
3. Retourne un token Sanctum + info utilisateur

### Stockage Android:
- Sauvegarder le token Sanctum dans DataStore
- L'inclure dans toutes les requêtes API

## 8. Modèle User (structure)

```php
User {
    id: integer
    google_id: string (unique)
    name: string
    email: string
    avatar: string (nullable)
    is_subscribed: boolean
    subscription_type: enum('free', 'monthly', 'annual')
    subscription_expires_at: timestamp (nullable)
}
```

## 9. Modèle Favorite (structure)

```php
Favorite {
    id: integer
    user_id: integer (foreign key)
    pharmacy_id: integer (foreign key)
    created_at: timestamp
    updated_at: timestamp
}
```

## 10. Tests avec Postman/curl

### Authentification:
```bash
curl -X POST http://localhost:8000/api/auth/google \
  -H "Content-Type: application/json" \
  -d '{"id_token": "google_id_token_here"}'
```

### Ajouter un favori:
```bash
curl -X POST http://localhost:8000/api/favorites \
  -H "Authorization: Bearer your_token_here" \
  -H "Content-Type: application/json" \
  -d '{"pharmacy_id": 1}'
```
