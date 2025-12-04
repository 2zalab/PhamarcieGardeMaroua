package com.maroua.pharmaciegarde.data.local;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.*;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/maroua/pharmaciegarde/data/local/UserPreferences;", "", "themeMode", "Lcom/maroua/pharmaciegarde/data/local/ThemeMode;", "language", "Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "notificationsEnabled", "", "onDutyNotificationsEnabled", "hasCompletedOnboarding", "(Lcom/maroua/pharmaciegarde/data/local/ThemeMode;Lcom/maroua/pharmaciegarde/data/local/AppLanguage;ZZZ)V", "getHasCompletedOnboarding", "()Z", "getLanguage", "()Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "getNotificationsEnabled", "getOnDutyNotificationsEnabled", "getThemeMode", "()Lcom/maroua/pharmaciegarde/data/local/ThemeMode;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class UserPreferences {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.ThemeMode themeMode = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.AppLanguage language = null;
    private final boolean notificationsEnabled = false;
    private final boolean onDutyNotificationsEnabled = false;
    private final boolean hasCompletedOnboarding = false;
    
    public UserPreferences(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.ThemeMode themeMode, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLanguage language, boolean notificationsEnabled, boolean onDutyNotificationsEnabled, boolean hasCompletedOnboarding) {
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
    
    public final boolean getHasCompletedOnboarding() {
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
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.UserPreferences copy(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.ThemeMode themeMode, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLanguage language, boolean notificationsEnabled, boolean onDutyNotificationsEnabled, boolean hasCompletedOnboarding) {
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