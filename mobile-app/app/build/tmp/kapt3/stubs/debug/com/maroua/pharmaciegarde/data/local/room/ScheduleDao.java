package com.maroua.pharmaciegarde.data.local.room;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/maroua/pharmaciegarde/data/local/room/ScheduleDao;", "", "deleteSchedulesForPharmacy", "", "pharmacyId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedulesForPharmacy", "", "Lcom/maroua/pharmaciegarde/data/local/room/ScheduleEntity;", "insertSchedules", "schedules", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface ScheduleDao {
    
    @androidx.room.Query(value = "SELECT * FROM schedules WHERE pharmacyId = :pharmacyId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSchedulesForPharmacy(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.maroua.pharmaciegarde.data.local.room.ScheduleEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertSchedules(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.local.room.ScheduleEntity> schedules, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM schedules WHERE pharmacyId = :pharmacyId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteSchedulesForPharmacy(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}