package com.maroua.pharmaciegarde.ui.navigation;

import androidx.compose.runtime.Composable;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Login", "Main", "Splash", "Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination$Login;", "Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination$Main;", "Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination$Splash;", "app_debug"})
public abstract class RootDestination {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private RootDestination(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination$Login;", "Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination;", "()V", "app_debug"})
    public static final class Login extends com.maroua.pharmaciegarde.ui.navigation.RootDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.RootDestination.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination$Main;", "Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination;", "()V", "app_debug"})
    public static final class Main extends com.maroua.pharmaciegarde.ui.navigation.RootDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.RootDestination.Main INSTANCE = null;
        
        private Main() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination$Splash;", "Lcom/maroua/pharmaciegarde/ui/navigation/RootDestination;", "()V", "app_debug"})
    public static final class Splash extends com.maroua.pharmaciegarde.ui.navigation.RootDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.maroua.pharmaciegarde.ui.navigation.RootDestination.Splash INSTANCE = null;
        
        private Splash() {
        }
    }
}