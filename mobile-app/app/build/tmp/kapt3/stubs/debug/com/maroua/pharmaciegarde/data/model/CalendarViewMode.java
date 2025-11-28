package com.maroua.pharmaciegarde.data.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlinx.parcelize.Parcelize;

/**
 * Enum pour les modes d'affichage du calendrier
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/maroua/pharmaciegarde/data/model/CalendarViewMode;", "", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "app_debug"})
public enum CalendarViewMode {
    /*public static final*/ DAY /* = new DAY() */,
    /*public static final*/ WEEK /* = new WEEK() */,
    /*public static final*/ MONTH /* = new MONTH() */;
    
    CalendarViewMode() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.maroua.pharmaciegarde.data.model.CalendarViewMode> getEntries() {
        return null;
    }
}