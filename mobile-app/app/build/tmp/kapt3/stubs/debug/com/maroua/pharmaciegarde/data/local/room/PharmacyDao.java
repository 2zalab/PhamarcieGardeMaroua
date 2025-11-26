package com.maroua.pharmaciegarde.data.local.room;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\'J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0017\u001a\u00020\u0018H\'\u00a8\u0006\u0019"}, d2 = {"Lcom/maroua/pharmaciegarde/data/local/room/PharmacyDao;", "", "deleteAllPharmacies", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePharmacy", "pharmacy", "Lcom/maroua/pharmaciegarde/data/local/room/PharmacyEntity;", "(Lcom/maroua/pharmaciegarde/data/local/room/PharmacyEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPharmacies", "Lkotlinx/coroutines/flow/Flow;", "", "getFavoritePharmacies", "ids", "", "getPharmacyById", "pharmacyId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPharmacies", "pharmacies", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPharmacy", "searchPharmacies", "query", "", "app_debug"})
@androidx.room.Dao
public abstract interface PharmacyDao {
    
    @androidx.room.Query(value = "SELECT * FROM pharmacies WHERE isActive = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.maroua.pharmaciegarde.data.local.room.PharmacyEntity>> getAllPharmacies();
    
    @androidx.room.Query(value = "SELECT * FROM pharmacies WHERE id = :pharmacyId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPharmacyById(int pharmacyId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.maroua.pharmaciegarde.data.local.room.PharmacyEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM pharmacies WHERE name LIKE \'%\' || :query || \'%\' OR address LIKE \'%\' || :query || \'%\' OR district LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.maroua.pharmaciegarde.data.local.room.PharmacyEntity>> searchPharmacies(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPharmacies(@org.jetbrains.annotations.NotNull
    java.util.List<com.maroua.pharmaciegarde.data.local.room.PharmacyEntity> pharmacies, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPharmacy(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.room.PharmacyEntity pharmacy, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deletePharmacy(@org.jetbrains.annotations.NotNull
    com.maroua.pharmaciegarde.data.local.room.PharmacyEntity pharmacy, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM pharmacies")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllPharmacies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM pharmacies WHERE id IN (:ids)")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.maroua.pharmaciegarde.data.local.room.PharmacyEntity>> getFavoritePharmacies(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> ids);
}