package com.maroua.pharmaciegarde.ui.navigation;

import androidx.compose.runtime.Composable;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Calendar", "Details", "Home", "Map", "Search", "Subscription", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Calendar;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Details;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Home;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Map;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Search;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Subscription;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Calendar;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Calendar extends com.maroua.pharmaciegarde.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.Screen.Calendar INSTANCE = null;
        
        private Calendar() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Details;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "()V", "createRoute", "", "pharmacyId", "", "app_debug"})
    public static final class Details extends com.maroua.pharmaciegarde.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.Screen.Details INSTANCE = null;
        
        private Details() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(int pharmacyId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Home;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.maroua.pharmaciegarde.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Map;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Map extends com.maroua.pharmaciegarde.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.Screen.Map INSTANCE = null;
        
        private Map() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Search;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Search extends com.maroua.pharmaciegarde.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.Screen.Search INSTANCE = null;
        
        private Search() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/Screen$Subscription;", "Lcom/maroua/pharmaciegarde/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Subscription extends com.maroua.pharmaciegarde.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.Screen.Subscription INSTANCE = null;
        
        private Subscription() {
        }
    }
}