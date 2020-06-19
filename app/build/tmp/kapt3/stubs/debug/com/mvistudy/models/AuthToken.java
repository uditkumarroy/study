package com.mvistudy.models;

import java.lang.System;

@androidx.room.Entity(tableName = "auth_token", foreignKeys = {@androidx.room.ForeignKey(entity = com.mvistudy.models.AccountProperties.class, childColumns = {"account_pk"}, onDelete = 5, parentColumns = {"pk"})})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/mvistudy/models/AuthToken;", "", "account_pk", "", "token", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getAccount_pk", "()Ljava/lang/Integer;", "setAccount_pk", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/mvistudy/models/AuthToken;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class AuthToken {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "account_pk")
    @androidx.room.PrimaryKey()
    private java.lang.Integer account_pk;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "token")
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "token")
    private java.lang.String token;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAccount_pk() {
        return null;
    }
    
    public final void setAccount_pk(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public AuthToken(@org.jetbrains.annotations.Nullable()
    java.lang.Integer account_pk, @org.jetbrains.annotations.Nullable()
    java.lang.String token) {
        super();
    }
    
    public AuthToken() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mvistudy.models.AuthToken copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer account_pk, @org.jetbrains.annotations.Nullable()
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}