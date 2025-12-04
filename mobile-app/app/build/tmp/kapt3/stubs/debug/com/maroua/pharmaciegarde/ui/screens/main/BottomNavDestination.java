package com.maroua.pharmaciegarde.ui.screens.main;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import com.maroua.pharmaciegarde.R;
import com.maroua.pharmaciegarde.data.model.Pharmacy;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0004\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination;", "", "route", "", "titleResId", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;ILandroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getRoute", "()Ljava/lang/String;", "getTitleResId", "()I", "AllPharmacies", "Favorites", "Home", "Settings", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$AllPharmacies;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$Favorites;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$Home;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$Settings;", "app_debug"})
public abstract class BottomNavDestination {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    private final int titleResId = 0;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    
    private BottomNavDestination(java.lang.String route, int titleResId, androidx.compose.ui.graphics.vector.ImageVector icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    public final int getTitleResId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$AllPharmacies;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination;", "()V", "app_debug"})
    public static final class AllPharmacies extends com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination.AllPharmacies INSTANCE = null;
        
        private AllPharmacies() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$Favorites;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination;", "()V", "app_debug"})
    public static final class Favorites extends com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination.Favorites INSTANCE = null;
        
        private Favorites() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$Home;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination;", "()V", "app_debug"})
    public static final class Home extends com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination$Settings;", "Lcom/maroua/pharmaciegarde/ui/screens/main/BottomNavDestination;", "()V", "app_debug"})
    public static final class Settings extends com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.BottomNavDestination.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
}