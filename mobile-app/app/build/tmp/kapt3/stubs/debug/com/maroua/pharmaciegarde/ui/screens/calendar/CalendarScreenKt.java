package com.maroua.pharmaciegarde.ui.screens.calendar;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.maroua.pharmaciegarde.data.model.CalendarViewMode;
import com.maroua.pharmaciegarde.data.model.Pharmacy;
import com.maroua.pharmaciegarde.data.model.PharmacySchedule;
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel;
import com.maroua.pharmaciegarde.util.SubscriptionChecker;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a@\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0003H\u0007\u001a$\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a$\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a*\u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0013H\u0007\u001a\u001e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\b\u0010\u001f\u001a\u00020\u0001H\u0007\u001a*\u0010 \u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001e\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u001e\u0010$\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0016\u0010%\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a8\u0010&\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010,\u001a\u00020-H\u0007\u001a$\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a*\u00102\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u00a8\u00063"}, d2 = {"CalendarScreen", "", "onPharmacyClick", "Lkotlin/Function1;", "Lcom/maroua/pharmaciegarde/data/model/Pharmacy;", "onBackClick", "Lkotlin/Function0;", "onUpgradeClick", "viewModel", "Lcom/maroua/pharmaciegarde/ui/screens/calendar/CalendarViewModel;", "authViewModel", "Lcom/maroua/pharmaciegarde/ui/viewmodel/AuthViewModel;", "DateNavigationBar", "uiState", "Lcom/maroua/pharmaciegarde/ui/screens/calendar/CalendarUiState;", "onPrevious", "onNext", "getFormattedDate", "Ljava/util/Date;", "", "DayScheduleCard", "schedule", "Lcom/maroua/pharmaciegarde/data/model/PharmacySchedule;", "DayScheduleCompactCard", "DayView", "schedules", "", "EmptyState", "message", "ErrorView", "onRetry", "LoadingIndicator", "MonthView", "PharmacyCalendarCard", "pharmacy", "onClick", "PharmacyListItem", "PremiumLockedCalendarScreen", "ViewModeButton", "text", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "isSelected", "", "modifier", "Landroidx/compose/ui/Modifier;", "ViewModeSelector", "selectedMode", "Lcom/maroua/pharmaciegarde/data/model/CalendarViewMode;", "onModeSelected", "WeekView", "app_debug"})
public final class CalendarScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void CalendarScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpgradeClick, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.screens.calendar.CalendarViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PremiumLockedCalendarScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpgradeClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ViewModeSelector(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.CalendarViewMode selectedMode, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.CalendarViewMode, kotlin.Unit> onModeSelected) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ViewModeButton(@org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.vector.ImageVector icon, boolean isSelected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DateNavigationBar(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.ui.screens.calendar.CalendarUiState uiState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPrevious, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNext, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.Date, java.lang.String> getFormattedDate) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DayView(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> schedules, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void WeekView(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> schedules, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MonthView(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.model.PharmacySchedule> schedules, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DayScheduleCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.PharmacySchedule schedule, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DayScheduleCompactCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.PharmacySchedule schedule, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.maroua.pharmaciegarde.data.model.Pharmacy, kotlin.Unit> onPharmacyClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PharmacyCalendarCard(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Pharmacy pharmacy, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PharmacyListItem(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.model.Pharmacy pharmacy, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LoadingIndicator() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ErrorView(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void EmptyState(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
}