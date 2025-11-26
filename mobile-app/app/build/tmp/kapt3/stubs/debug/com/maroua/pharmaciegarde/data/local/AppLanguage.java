package com.maroua.pharmaciegarde.data.local;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.*;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/maroua/pharmaciegarde/data/local/AppLanguage;", "", "(Ljava/lang/String;I)V", "FRENCH", "ENGLISH", "app_debug"})
public enum AppLanguage {
    /*public static final*/ FRENCH /* = new FRENCH() */,
    /*public static final*/ ENGLISH /* = new ENGLISH() */;
    
    AppLanguage() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.maroua.pharmaciegarde.data.local.AppLanguage> getEntries() {
        return null;
    }
}