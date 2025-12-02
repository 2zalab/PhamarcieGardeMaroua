package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.model.User;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * API Service pour l'authentification avec Laravel
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/AuthApiService;", "", "getUserInfo", "Lretrofit2/Response;", "Lcom/maroua/pharmaciegarde/data/remote/UserInfoResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "googleAuth", "Lcom/maroua/pharmaciegarde/data/remote/GoogleAuthResponse;", "request", "Lcom/maroua/pharmaciegarde/data/remote/GoogleAuthRequest;", "(Lcom/maroua/pharmaciegarde/data/remote/GoogleAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "Lcom/maroua/pharmaciegarde/data/remote/LogoutResponse;", "app_debug"})
public abstract interface AuthApiService {
    
    @retrofit2.http.POST(value = "auth/google")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object googleAuth(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.GoogleAuthRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.GoogleAuthResponse>> $completion);
    
    @retrofit2.http.GET(value = "auth/me")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.UserInfoResponse>> $completion);
    
    @retrofit2.http.POST(value = "auth/logout")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.maroua.pharmaciegarde.data.remote.LogoutResponse>> $completion);
}