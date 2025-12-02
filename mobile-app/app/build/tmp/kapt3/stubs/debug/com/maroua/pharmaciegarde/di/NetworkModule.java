package com.maroua.pharmaciegarde.di;

import com.maroua.pharmaciegarde.data.local.TokenManager;
import com.maroua.pharmaciegarde.data.remote.AuthApiService;
import com.maroua.pharmaciegarde.data.remote.AuthInterceptor;
import com.maroua.pharmaciegarde.data.remote.FavoritesApiService;
import com.maroua.pharmaciegarde.data.remote.PharmacyApiService;
import com.maroua.pharmaciegarde.data.remote.RatingApiService;
import com.maroua.pharmaciegarde.data.remote.SubscriptionApiService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/maroua/pharmaciegarde/di/NetworkModule;", "", "()V", "BASE_URL", "", "provideAuthApiService", "Lcom/maroua/pharmaciegarde/data/remote/AuthApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideAuthInterceptor", "Lcom/maroua/pharmaciegarde/data/remote/AuthInterceptor;", "tokenManager", "Lcom/maroua/pharmaciegarde/data/local/TokenManager;", "provideFavoritesApiService", "Lcom/maroua/pharmaciegarde/data/remote/FavoritesApiService;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "authInterceptor", "providePharmacyApiService", "Lcom/maroua/pharmaciegarde/data/remote/PharmacyApiService;", "provideRatingApiService", "Lcom/maroua/pharmaciegarde/data/remote/RatingApiService;", "provideRetrofit", "okHttpClient", "provideSubscriptionApiService", "Lcom/maroua/pharmaciegarde/data/remote/SubscriptionApiService;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "http://172.20.10.4:8000/api/";
    @org.jetbrains.annotations.NotNull
    public static final com.maroua.pharmaciegarde.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.remote.AuthInterceptor provideAuthInterceptor(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.TokenManager tokenManager) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.AuthInterceptor authInterceptor) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.remote.PharmacyApiService providePharmacyApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.remote.AuthApiService provideAuthApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.remote.FavoritesApiService provideFavoritesApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.remote.SubscriptionApiService provideSubscriptionApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.remote.RatingApiService provideRatingApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
}