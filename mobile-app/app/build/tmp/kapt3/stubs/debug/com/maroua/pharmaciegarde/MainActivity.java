package com.maroua.pharmaciegarde;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.Modifier;
import com.maroua.pharmaciegarde.data.local.ThemeMode;
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/maroua/pharmaciegarde/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "userPreferencesManager", "Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;", "getUserPreferencesManager", "()Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;", "setUserPreferencesManager", "(Lcom/maroua/pharmaciegarde/data/local/UserPreferencesManager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject
    public com.maroua.pharmaciegarde.data.local.UserPreferencesManager userPreferencesManager;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.local.UserPreferencesManager getUserPreferencesManager() {
        return null;
    }
    
    public final void setUserPreferencesManager(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.UserPreferencesManager p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}