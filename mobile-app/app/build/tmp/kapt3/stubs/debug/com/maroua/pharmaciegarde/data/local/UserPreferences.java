package com.maroua.pharmaciegarde.data.local;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.*;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/maroua/pharmaciegarde/data/local/UserPreferences;", "", "themeMode", "Lcom/maroua/pharmaciegarde/data/local/ThemeMode;", "language", "Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "notificationsEnabled", "", "onDutyNotificationsEnabled", "(Lcom/maroua/pharmaciegarde/data/local/ThemeMode;Lcom/maroua/pharmaciegarde/data/local/AppLanguage;ZZ)V", "getLanguage", "()Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "getNotificationsEnabled", "()Z", "getOnDutyNotificationsEnabled", "getThemeMode", "()Lcom/maroua/pharmaciegarde/data/local/ThemeMode;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class UserPreferences {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.ThemeMode themeMode = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.AppLanguage language = null;
    private final boolean notificationsEnabled = false;
    private final boolean onDutyNotificationsEnabled = false;
    
    public UserPreferences(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.ThemeMode themeMode, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLanguage language, boolean notificationsEnabled, boolean onDutyNotificationsEnabled) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.ThemeMode getThemeMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.AppLanguage getLanguage() {
        return null;
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    public final boolean getOnDutyNotificationsEnabled() {
        return false;
    }
    
    public UserPreferences() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.ThemeMode component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.AppLanguage component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.UserPreferences copy(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.ThemeMode themeMode, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLanguage language, boolean notificationsEnabled, boolean onDutyNotificationsEnabled) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}