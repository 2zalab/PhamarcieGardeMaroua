# Configuration Google Sign-In (Sans Firebase)

Cette application utilise **Google Sign-In** directement avec **Google Cloud Console** (pas Firebase) pour l'authentification, avec Laravel comme backend.

## 📋 Prérequis

1. Compte Google Cloud Console
2. Backend Laravel configuré avec l'API Google Auth (voir `backend/SETUP_AUTH.md`)

## 🔧 Configuration

### Étape 1: Créer les OAuth 2.0 Client IDs dans Google Cloud Console

1. Allez sur [Google Cloud Console](https://console.cloud.google.com/)
2. Sélectionnez ou créez votre projet
3. Menu **APIs & Services** → **Credentials**
4. Cliquez **+ CREATE CREDENTIALS** → **OAuth client ID**

### Étape 2: Créer le Client ID Android

1. **Application type**: Android
2. **Name**: Pharmacie de Garde Android
3. **Package name**: `com.maroua.pharmaciegarde`
4. **SHA-1 certificate fingerprint**:
   ```bash
   # Debug (pour développement)
   keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android

   # Production (pour release)
   keytool -list -v -keystore /path/to/your/release.keystore -alias your_alias
   ```
5. Cliquez **CREATE**

### Étape 3: Créer le Client ID Web (IMPORTANT !)

1. **Application type**: Web application
2. **Name**: Pharmacie de Garde Web
3. **Authorized redirect URIs**: `http://localhost` (ou votre domaine backend)
4. Cliquez **CREATE**
5. **COPIEZ le Client ID Web** (format: `xxxxx-xxxxx.apps.googleusercontent.com`)

### Étape 4: Configurer l'Application Android

#### A. Mettre à jour `strings.xml`

Ouvrez `app/src/main/res/values/strings.xml` et remplacez:

```xml
<string name="default_web_client_id" translatable="false">YOUR_WEB_CLIENT_ID_HERE</string>
```

Par votre **vrai Client ID Web** copié à l'étape 3:

```xml
<string name="default_web_client_id" translatable="false">123456789-abcdefgh.apps.googleusercontent.com</string>
```

⚠️ **IMPORTANT**: Utilisez le **Client ID Web**, PAS le Client ID Android !

#### B. Vérifier le package name

Dans `app/build.gradle.kts`, vérifiez:

```kotlin
defaultConfig {
    applicationId = "com.maroua.pharmaciegarde"
    // ...
}
```

### Étape 5: Configurer le Backend Laravel

1. Copiez le même **Client ID Web** dans votre fichier `.env` Laravel:

```env
GOOGLE_CLIENT_ID=123456789-abcdefgh.apps.googleusercontent.com
```

2. Suivez les instructions dans `backend/SETUP_AUTH.md` pour le reste

## 🔄 Flux d'Authentification

```
1. User clique "Se connecter avec Google" sur Android
   ↓
2. Android ouvre Google Sign-In avec requestIdToken(WEB_CLIENT_ID)
   ↓
3. Google retourne un ID Token
   ↓
4. Android envoie l'ID Token à Laravel: POST /api/auth/google
   ↓
5. Laravel vérifie le token avec Google API
   ↓
6. Laravel crée/met à jour l'utilisateur en DB
   ↓
7. Laravel retourne un JWT token à Android
   ↓
8. Android stocke le JWT dans DataStore
   ↓
9. Android utilise le JWT pour toutes les requêtes futures
```

## ✅ Vérification

Pour vérifier que tout fonctionne:

1. **Lancez l'application Android**
2. Sur le SplashScreen → LoginScreen apparaît
3. Cliquez sur **"Se connecter avec Google"**
4. Sélectionnez votre compte Google
5. Si tout est correct:
   - Vous êtes redirigé vers MainScreen
   - Message "Welcome [Votre Nom]" apparaît en haut de HomeScreen
   - Vous pouvez ajouter des favoris

## 🐛 Dépannage

### Erreur: "Sign in failed" ou "Error 10"
- **Cause**: SHA-1 fingerprint incorrect ou manquant
- **Solution**: Vérifiez que vous avez ajouté le bon SHA-1 dans Google Cloud Console

### Erreur: "ID Token is null"
- **Cause**: Client ID Web incorrect dans strings.xml
- **Solution**: Assurez-vous d'utiliser le **Client ID Web**, pas Android

### Erreur: "Server error: 401"
- **Cause**: Le backend Laravel ne peut pas vérifier le token
- **Solution**:
  - Vérifiez que `GOOGLE_CLIENT_ID` est correct dans `.env`
  - Vérifiez que `google/apiclient` est installé: `composer require google/apiclient`

### Erreur: "default_web_client_id not found"
- **Cause**: Le string n'existe pas dans strings.xml
- **Solution**: Ajoutez le string comme indiqué à l'étape 4

## 📝 Notes Importantes

1. **Pas besoin de Firebase** - Cette configuration utilise uniquement Google Cloud Console
2. **Pas besoin de google-services.json** - Tout est configuré manuellement
3. **Client ID Web vs Android**:
   - Le **Client ID Android** permet à l'app d'accéder à Google Sign-In
   - Le **Client ID Web** permet au backend de vérifier les tokens
4. **Mode Debug vs Release**: En production, ajoutez aussi le SHA-1 de votre keystore de release

## 🔐 Sécurité

- Ne committez JAMAIS vos Client IDs dans un repo public
- Utilisez des variables d'environnement ou des secrets GitHub
- Ajoutez `strings.xml` à `.gitignore` si nécessaire (créez un `strings.xml.example`)

## 📚 Ressources

- [Google Sign-In for Android](https://developers.google.com/identity/sign-in/android/start)
- [Authenticate with a backend server](https://developers.google.com/identity/sign-in/android/backend-auth)
- [Google OAuth 2.0](https://developers.google.com/identity/protocols/oauth2)
