# Pharmacie de Garde Maroua - Backend API

API REST Laravel pour l'application mobile des pharmacies de garde à Maroua.

## 🚀 Installation

### Prérequis

- PHP >= 8.1
- Composer
- MySQL ou MariaDB
- Extension PHP: PDO, OpenSSL, Mbstring, Tokenizer, XML, Ctype, JSON

### Configuration

1. **Cloner le projet et installer les dépendances**

```bash
cd backend
composer install
```

2. **Configurer l'environnement**

**Option A : Utiliser le fichier de développement (Démarrage rapide)**
```bash
copy .env.development .env
```
Le fichier `.env.development` contient déjà toutes les valeurs par défaut et une clé APP_KEY générée.

**Option B : Créer depuis le template**
```bash
copy .env.example .env
php artisan key:generate
```

3. **Configurer la base de données**

Modifier le fichier `.env` avec vos informations de base de données:

```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=pharmacie_garde
DB_USERNAME=root
DB_PASSWORD=votre_mot_de_passe
```

4. **Créer la base de données**

```bash
mysql -u root -p
CREATE DATABASE pharmacie_garde CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
exit;
```

5. **Exécuter les migrations et seeders**

```bash
php artisan migrate --seed
```

6. **Lancer le serveur de développement**

```bash
php artisan serve
```

L'API sera accessible sur `http://localhost:8000`

## 📚 Documentation API

### Endpoints disponibles

#### 1. Obtenir toutes les pharmacies

```http
GET /api/pharmacies
```

**Paramètres optionnels:**
- `search` - Rechercher par nom, adresse ou quartier
- `district` - Filtrer par quartier

**Réponse:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "name": "Pharmacie du Centre",
      "address": "Avenue de la Réunification, Centre-ville",
      "phone": "+237 699 123 456",
      "phone_secondary": "+237 677 123 456",
      "latitude": 10.5905,
      "longitude": 14.3159,
      "image_url": null,
      "description": "Pharmacie moderne...",
      "city": "Maroua",
      "district": "Centre-ville",
      "has_parking": true,
      "has_wheelchair_access": true,
      "is_24_hours": false,
      "is_on_duty_today": true,
      "current_schedule": { ... }
    }
  ]
}
```

#### 2. Pharmacies de garde actuellement

```http
GET /api/pharmacies/on-duty
```

Retourne uniquement les pharmacies qui sont de garde aujourd'hui.

#### 3. Pharmacies à proximité

```http
GET /api/pharmacies/nearby?latitude=10.5905&longitude=14.3159&radius=5
```

**Paramètres requis:**
- `latitude` - Latitude de la position
- `longitude` - Longitude de la position

**Paramètre optionnel:**
- `radius` - Rayon de recherche en km (défaut: 10)

#### 4. Détails d'une pharmacie

```http
GET /api/pharmacies/{id}
```

Retourne les détails complets d'une pharmacie incluant tous ses horaires de garde.

## 🗂️ Structure de la base de données

### Table `pharmacies`

| Champ | Type | Description |
|-------|------|-------------|
| id | bigint | Identifiant unique |
| name | varchar | Nom de la pharmacie |
| address | varchar | Adresse complète |
| phone | varchar | Numéro de téléphone principal |
| phone_secondary | varchar | Numéro de téléphone secondaire |
| latitude | decimal | Latitude GPS |
| longitude | decimal | Longitude GPS |
| image_url | varchar | URL de l'image |
| description | text | Description |
| city | varchar | Ville (Maroua) |
| district | varchar | Quartier |
| has_parking | boolean | Dispose d'un parking |
| has_wheelchair_access | boolean | Accessible aux PMR |
| is_24_hours | boolean | Ouvert 24h/24 |
| is_active | boolean | Pharmacie active |

### Table `schedules`

| Champ | Type | Description |
|-------|------|-------------|
| id | bigint | Identifiant unique |
| pharmacy_id | bigint | ID de la pharmacie |
| start_date | date | Date de début de garde |
| end_date | date | Date de fin de garde |
| start_time | time | Heure de début |
| end_time | time | Heure de fin |
| is_on_duty | boolean | En service |
| notes | text | Notes additionnelles |

## 🛠️ Commandes utiles

```bash
# Réinitialiser la base de données
php artisan migrate:fresh --seed

# Créer un nouveau contrôleur
php artisan make:controller Api/NomController

# Créer un nouveau modèle avec migration
php artisan make:model NomModele -m

# Vider le cache
php artisan cache:clear
php artisan config:clear
php artisan route:clear
```

## 📱 CORS

Pour permettre l'accès depuis l'application mobile, CORS est configuré pour accepter toutes les origines en développement. En production, configurez les origines autorisées dans `config/cors.php`.

## 🔐 Sécurité

- Utilisez HTTPS en production
- Configurez les variables d'environnement sensibles
- Activez Laravel Sanctum pour l'authentification API si nécessaire

## 🐛 Dépannage

### Erreur "Session store not set on request"

**Solution :**
1. Assurez-vous que le fichier `.env` existe dans le dossier `backend/`
2. Vérifiez que la variable `APP_KEY` est définie dans `.env`
3. Si le problème persiste, exécutez :
```bash
php artisan key:generate
php artisan config:clear
php artisan cache:clear
```

### Erreur de connexion à la base de données

1. Vérifiez que MySQL/MariaDB est démarré
2. Vérifiez les identifiants dans le fichier `.env`
3. Assurez-vous que la base de données `pharmacie_garde` existe

### Composer install échoue

```bash
# Mettre à jour Composer
composer self-update

# Nettoyer le cache
composer clear-cache

# Réinstaller
composer install --no-cache
```

### Permissions sur storage/ et bootstrap/cache/

**Sur Windows :**
Les permissions sont généralement automatiques.

**Sur Linux/Mac :**
```bash
chmod -R 775 storage bootstrap/cache
chown -R www-data:www-data storage bootstrap/cache
```

## 📝 License

MIT License - Libre d'utilisation pour le projet Pharmacie de Garde Maroua
