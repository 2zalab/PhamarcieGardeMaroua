package com.maroua.pharmaciegarde.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Réponse de paiement CamPay (données)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003Jz\u0010\'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006."}, d2 = {"Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentData;", "", "paymentId", "", "reference", "", "externalReference", "ussdCode", "operator", "amount", "currency", "description", "status", "message", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()I", "getCurrency", "()Ljava/lang/String;", "getDescription", "getExternalReference", "getMessage", "getOperator", "getPaymentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReference", "getStatus", "getUssdCode", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/maroua/pharmaciegarde/data/model/CamPayPaymentData;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class CamPayPaymentData {
    @com.google.gson.annotations.SerializedName(value = "payment_id")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer paymentId = null;
    @com.google.gson.annotations.SerializedName(value = "reference")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String reference = null;
    @com.google.gson.annotations.SerializedName(value = "external_reference")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String externalReference = null;
    @com.google.gson.annotations.SerializedName(value = "ussd_code")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String ussdCode = null;
    @com.google.gson.annotations.SerializedName(value = "operator")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String operator = null;
    @com.google.gson.annotations.SerializedName(value = "amount")
    private final int amount = 0;
    @com.google.gson.annotations.SerializedName(value = "currency")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String currency = null;
    @com.google.gson.annotations.SerializedName(value = "description")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @com.google.gson.annotations.SerializedName(value = "status")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String status = null;
    @com.google.gson.annotations.SerializedName(value = "message")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String message = null;
    
    public CamPayPaymentData(@org.jetbrains.annotations.Nullable
    java.lang.Integer paymentId, @org.jetbrains.annotations.NotNull
    java.lang.String reference, @org.jetbrains.annotations.NotNull
    java.lang.String externalReference, @org.jetbrains.annotations.Nullable
    java.lang.String ussdCode, @org.jetbrains.annotations.Nullable
    java.lang.String operator, int amount, @org.jetbrains.annotations.NotNull
    java.lang.String currency, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.Nullable
    java.lang.String message) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getPaymentId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getExternalReference() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUssdCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOperator() {
        return null;
    }
    
    public final int getAmount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.maroua.pharmaciegarde.data.model.CamPayPaymentData copy(@org.jetbrains.annotations.Nullable
    java.lang.Integer paymentId, @org.jetbrains.annotations.NotNull
    java.lang.String reference, @org.jetbrains.annotations.NotNull
    java.lang.String externalReference, @org.jetbrains.annotations.Nullable
    java.lang.String ussdCode, @org.jetbrains.annotations.Nullable
    java.lang.String operator, int amount, @org.jetbrains.annotations.NotNull
    java.lang.String currency, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.Nullable
    java.lang.String message) {
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