package com.maroua.pharmaciegarde.data.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/maroua/pharmaciegarde/data/local/AppLocaleManager;", "", "context", "Landroid/content/Context;", "userPreferencesManager", "Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;", "(Landroid/content/Context;Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;)V", "applyLanguage", "", "language", "Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "(Lcom/maroua/pharmaciegarde/data/local/AppLanguage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyPersistedLocale", "getCurrentLanguage", "", "app_debug"})
public final class AppLocaleManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.UserPreferencesManager userPreferencesManager = null;
    
    @javax.inject.Inject
    public AppLocaleManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.UserPreferencesManager userPreferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object applyLanguage(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLanguage language, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void applyPersistedLocale() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentLanguage() {
        return null;
    }
}