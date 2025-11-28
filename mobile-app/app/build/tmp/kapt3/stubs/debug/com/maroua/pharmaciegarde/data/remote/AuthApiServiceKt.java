package com.maroua.pharmaciegarde.data.remote;

import com.maroua.pharmaciegarde.data.model.User;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u00a8\u0006\b"}, d2 = {"parseDateToTimestamp", "", "dateString", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toUser", "Lcom/maroua/pharmaciegarde/data/model/User;", "Lcom/maroua/pharmaciegarde/data/remote/UserDto;", "app_debug"})
public final class AuthApiServiceKt {
    
    @org.jetbrains.annotations.NotNull
    public static final com.maroua.pharmaciegarde.data.model.User toUser(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.remote.UserDto $this$toUser) {
        return null;
    }
    
    /**
     * Parse une date du backend Laravel en timestamp milliseconds.
     * Supporte les formats:
     * - SQL: "2025-12-28 17:47:37"
     * - ISO 8601: "2025-12-28T17:47:37.000000Z"
     */
    private static final java.lang.Long parseDateToTimestamp(java.lang.String dateString) {
        return null;
    }
}