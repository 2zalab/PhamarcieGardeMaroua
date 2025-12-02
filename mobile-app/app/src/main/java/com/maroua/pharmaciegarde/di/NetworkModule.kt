package com.maroua.pharmaciegarde.di

import com.maroua.pharmaciegarde.data.local.TokenManager
import com.maroua.pharmaciegarde.data.remote.AuthApiService
import com.maroua.pharmaciegarde.data.remote.AuthInterceptor
import com.maroua.pharmaciegarde.data.remote.FavoritesApiService
import com.maroua.pharmaciegarde.data.remote.PharmacyApiService
import com.maroua.pharmaciegarde.data.remote.RatingApiService
import com.maroua.pharmaciegarde.data.remote.SubscriptionApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Changez cette URL par l'adresse de votre serveur Laravel
    // Pour l'émulateur Android: 10.0.2.2
    // Pour un appareil physique: utilisez l'IP de votre machine
    private const val BASE_URL = "http://172.20.10.4:8000/api/"

    @Provides
    @Singleton
    fun provideAuthInterceptor(tokenManager: TokenManager): AuthInterceptor {
        return AuthInterceptor(tokenManager)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor) // Ajoute le token automatiquement
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePharmacyApiService(retrofit: Retrofit): PharmacyApiService {
        return retrofit.create(PharmacyApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFavoritesApiService(retrofit: Retrofit): FavoritesApiService {
        return retrofit.create(FavoritesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSubscriptionApiService(retrofit: Retrofit): SubscriptionApiService {
        return retrofit.create(SubscriptionApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRatingApiService(retrofit: Retrofit): RatingApiService {
        return retrofit.create(RatingApiService::class.java)
    }
}
