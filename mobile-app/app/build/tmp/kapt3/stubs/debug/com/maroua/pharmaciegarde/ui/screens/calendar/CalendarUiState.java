package com.maroua.pharmaciegarde.ui.screens.calendar;

import androidx.lifecycle.ViewModel;
import com.maroua.pharmaciegarde.data.model.CalendarViewMode;
import com.maroua.pharmaciegarde.data.model.PharmacySchedule;
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository;
import com.maroua.pharmaciegarde.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u00c6\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\fH\u00d6\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/calendar/CalendarUiState;", "", "viewMode", "Lcom/maroua/pharmaciegarde/data/model/CalendarViewMode;", "selectedDate", "Ljava/util/Date;", "schedules", "", "Lcom/maroua/pharmaciegarde/data/model/PharmacySchedule;", "isLoading", "", "error", "", "(Lcom/maroua/pharmaciegarde/data/model/CalendarViewMode;Ljava/util/Date;Ljava/util/List;ZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getSchedules", "()Ljava/util/List;", "getSelectedDate", "()Ljava/util/Date;", "getViewMode", "()Lcom/maroua/pharmaciegarde/data/model/CalendarViewMode;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class CalendarUiState {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.model.CalendarViewMode viewMode = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> schedules = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    
    public CalendarUiState(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.CalendarViewMode viewMode, @org.jetbrains.annotations.NotNull
    java.util.Date selectedDate, @org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> schedules, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.model.CalendarViewMode getViewMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getSelectedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> getSchedules() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    public CalendarUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.model.CalendarViewMode component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.ui.screens.calendar.CalendarUiState copy(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.CalendarViewMode viewMode, @org.jetbrains.annotations.NotNull
    java.util.Date selectedDate, @org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> schedules, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}