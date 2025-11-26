package com.maroua.pharmaciegarde.data.repository;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.maroua.pharmaciegarde.R;
import com.maroua.pharmaciegarde.data.local.TokenManager;
import com.maroua.pharmaciegarde.data.model.User;
import com.maroua.pharmaciegarde.data.remote.AuthApiService;
import com.maroua.pharmaciegarde.data.remote.GoogleAuthRequest;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "", "context", "Landroid/content/Context;", "authApiService", "Lcom/maroua/pharmaciegarde/data/remote/AuthApiService;", "tokenManager", "Lcom/maroua/pharmaciegarde/data/local/TokenManager;", "(Landroid/content/Context;Lcom/maroua/pharmaciegarde/data/remote/AuthApiService;Lcom/maroua/pharmaciegarde/data/local/TokenManager;)V", "getCurrentUser", "Lkotlinx/coroutines/flow/Flow;", "Lcom/maroua/pharmaciegarde/data/model/User;", "getGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "isUserSignedIn", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserSignedInFlow", "signInWithGoogle", "Lkotlin/Result;", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "signInWithGoogle-gIAlu-s", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.remote.AuthApiService authApiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.TokenManager tokenManager = null;
    
    @javax.inject.Inject
    public AuthRepository(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.AuthApiService authApiService, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.TokenManager tokenManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    /**
     * Déconnexion
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object signOut(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Récupérer l'utilisateur courant depuis Laravel
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.maroua.pharmaciegarde.data.model.User> getCurrentUser() {
        return null;
    }
    
    /**
     * Vérifier si l'utilisateur est connecté
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object isUserSignedIn(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Observer l'état de connexion de l'utilisateur
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isUserSignedInFlow() {
        return null;
    }
}