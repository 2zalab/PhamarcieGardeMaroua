package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.local.TokenManager;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Intercepteur pour ajouter automatiquement le token Bearer aux requêtes
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/AuthInterceptor;", "Lokhttp3/Interceptor;", "tokenManager", "Lcom/maroua/pharmaciegarde/data/local/TokenManager;", "(Lcom/maroua/pharmaciegarde/data/local/TokenManager;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
public final class AuthInterceptor implements okhttp3.Interceptor {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.TokenManager tokenManager = null;
    
    public AuthInterceptor(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.TokenManager tokenManager) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
}