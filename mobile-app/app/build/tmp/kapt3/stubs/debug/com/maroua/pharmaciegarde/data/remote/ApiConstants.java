package com.maroua.pharmaciegarde.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/maroua/pharmaciegarde/data/remote/ApiConstants;", "", "()V", "BASE_URL_DEVICE", "", "BASE_URL_EMULATOR", "BASE_URL_PRODUCTION", "app_debug"})
public final class ApiConstants {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL_EMULATOR = "http://10.0.2.2:8000/api/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL_DEVICE = "http://192.168.1.X:8000/api/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL_PRODUCTION = "https://votre-domaine.com/api/";
    @org.jetbrains.annotations.NotNull
    public static final com.maroua.pharmaciegarde.data.remote.ApiConstants INSTANCE = null;
    
    private ApiConstants() {
        super();
    }
}