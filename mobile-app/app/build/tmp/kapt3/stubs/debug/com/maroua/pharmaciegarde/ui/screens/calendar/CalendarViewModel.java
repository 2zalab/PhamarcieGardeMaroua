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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/maroua/pharmaciegarde/ui/screens/calendar/CalendarViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;", "(Lcom/maroua/pharmaciegarde/data/repository/PharmacyRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/maroua/pharmaciegarde/ui/screens/calendar/CalendarUiState;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dayNameFormat", "displayDateFormat", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getFormattedDate", "", "date", "Ljava/util/Date;", "goToToday", "", "loadSchedulesForCurrentDate", "loadSchedulesForDay", "loadSchedulesForMonth", "loadSchedulesForWeek", "navigateDay", "forward", "", "navigateMonth", "navigateWeek", "retry", "selectDate", "setViewMode", "mode", "Lcom/maroua/pharmaciegarde/data/model/CalendarViewMode;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class CalendarViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.maroua.pharmaciegarde.data.repository.PharmacyRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.maroua.pharmaciegarde.ui.screens.calendar.CalendarUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.screens.calendar.CalendarUiState> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final java.text.SimpleDateFormat dateFormat = null;
    @org.jetbrains.annotations.NotNull
    private final java.text.SimpleDateFormat displayDateFormat = null;
    @org.jetbrains.annotations.NotNull
    private final java.text.SimpleDateFormat dayNameFormat = null;
    
    @javax.inject.Inject
    public CalendarViewModel(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.repository.PharmacyRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.maroua.pharmaciegarde.ui.screens.calendar.CalendarUiState> getUiState() {
        return null;
    }
    
    /**
     * Change le mode d'affichage (jour/semaine/mois)
     */
    public final void setViewMode(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.CalendarViewMode mode) {
    }
    
    /**
     * Change la date sélectionnée
     */
    public final void selectDate(@org.jetbrains.annotations.NotNull
    java.util.Date date) {
    }
    
    /**
     * Navigue au jour précédent/suivant
     */
    public final void navigateDay(boolean forward) {
    }
    
    /**
     * Navigue à la semaine précédente/suivante
     */
    public final void navigateWeek(boolean forward) {
    }
    
    /**
     * Navigue au mois précédent/suivant
     */
    public final void navigateMonth(boolean forward) {
    }
    
    /**
     * Retourne à aujourd'hui
     */
    public final void goToToday() {
    }
    
    private final void loadSchedulesForCurrentDate() {
    }
    
    /**
     * Charge les pharmacies de garde pour un jour
     */
    private final void loadSchedulesForDay(java.util.Date date) {
    }
    
    /**
     * Charge les pharmacies de garde pour une semaine
     */
    private final void loadSchedulesForWeek(java.util.Date date) {
    }
    
    /**
     * Charge les pharmacies de garde pour un mois
     */
    private final void loadSchedulesForMonth(java.util.Date date) {
    }
    
    public final void retry() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedDate(@org.jetbrains.annotations.NotNull
    java.util.Date date) {
        return null;
    }
}