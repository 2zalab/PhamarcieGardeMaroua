package com.maroua.pharmaciegarde.ui.screens.settings;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.local.AppLanguage;
import com.maroua.pharmaciegarde.data.local.AppLocaleManager;
import com.maroua.pharmaciegarde.data.local.ThemeMode;
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "userPreferencesManager", "Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;", "appLocaleManager", "Lcom/maroua/pharmaciegarde/data/local/AppLocaleManager;", "(Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;Lcom/maroua/pharmaciegarde/data/local/AppLocaleManager;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/maroua/pharmaciegarde/data/local/UserPreferences;", "Lcom/maroua/pharmaciegarde/ui/screens/settings/SettingsUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateLanguage", "", "language", "Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "updateNotificationsEnabled", "enabled", "", "updateOnDutyNotifications", "updateThemeMode", "themeMode", "Lcom/maroua/pharmaciegarde/data/local/ThemeMode;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.UserPreferencesManager userPreferencesManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.local.AppLocaleManager appLocaleManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.data.local.UserPreferences> uiState = null;
    
    @javax.inject.Inject
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.UserPreferencesManager userPreferencesManager, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLocaleManager appLocaleManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.data.local.UserPreferences> getUiState() {
        return null;
    }
    
    public final void updateThemeMode(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.ThemeMode themeMode) {
    }
    
    public final void updateLanguage(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.AppLanguage language) {
    }
    
    public final void updateNotificationsEnabled(boolean enabled) {
    }
    
    public final void updateOnDutyNotifications(boolean enabled) {
    }
}