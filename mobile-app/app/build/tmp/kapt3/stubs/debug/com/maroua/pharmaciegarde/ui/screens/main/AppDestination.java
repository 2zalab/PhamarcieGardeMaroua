package com.maroua.pharmaciegarde.ui.screens.main;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import com.maroua.pharmaciegarde.data.model.Pharmacy;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Details", "Login", "Map", "Search", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Details;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Login;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Map;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Search;", "app_debug"})
public abstract class AppDestination {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private AppDestination(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Details;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination;", "()V", "createRoute", "", "pharmacyId", "", "app_debug"})
    public static final class Details extends com.maroua.pharmaciegarde.ui.screens.main.AppDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.AppDestination.Details INSTANCE = null;
        
        private Details() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(int pharmacyId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Login;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination;", "()V", "app_debug"})
    public static final class Login extends com.maroua.pharmaciegarde.ui.screens.main.AppDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.AppDestination.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Map;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination;", "()V", "app_debug"})
    public static final class Map extends com.maroua.pharmaciegarde.ui.screens.main.AppDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.AppDestination.Map INSTANCE = null;
        
        private Map() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination$Search;", "Lcom/maroua/pharmaciegarde/ui/screens/main/AppDestination;", "()V", "app_debug"})
    public static final class Search extends com.maroua.pharmaciegarde.ui.screens.main.AppDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.screens.main.AppDestination.Search INSTANCE = null;
        
        private Search() {
        }
    }
}