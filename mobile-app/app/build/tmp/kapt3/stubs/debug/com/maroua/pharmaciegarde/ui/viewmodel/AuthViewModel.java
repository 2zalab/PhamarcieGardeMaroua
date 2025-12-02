package com.maroua.pharmaciegarde.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.maroua.pharmaciegarde.data.model.User;
import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/AuthRepository;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthState;", "_currentUser", "Lcom/maroua/pharmaciegarde/data/model/User;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUser", "getCurrentUser", "getGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "isUserSignedIn", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserSignedInFlow", "Lkotlinx/coroutines/flow/Flow;", "refreshUser", "", "resetAuthState", "setError", "message", "", "signInWithGoogle", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "signOut", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.ui.viewmodel.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.viewmodel.AuthState> authState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.data.model.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.data.model.User> currentUser = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.viewmodel.AuthState> getAuthState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.data.model.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isUserSignedInFlow() {
        return null;
    }
    
    public final void signInWithGoogle(@org.jetbrains.annotations.NotNull
    com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
    }
    
    public final void signOut() {
    }
    
    public final void resetAuthState() {
    }
    
    public final void setError(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object isUserSignedIn(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Rafraîchir les informations de l'utilisateur depuis le backend
     * Force un nouvel appel API pour obtenir les dernières données
     */
    public final void refreshUser() {
    }
}