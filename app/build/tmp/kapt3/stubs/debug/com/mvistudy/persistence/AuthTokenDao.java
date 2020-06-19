package com.mvistudy.persistence;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/mvistudy/persistence/AuthTokenDao;", "", "insert", "", "authToken", "Lcom/mvistudy/models/AuthToken;", "(Lcom/mvistudy/models/AuthToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nullifyToken", "", "pk", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchByPk", "app_debug"})
public abstract interface AuthTokenDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.mvistudy.models.AuthToken authToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE auth_token SET token = null WHERE account_pk = :pk")
    public abstract java.lang.Object nullifyToken(int pk, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM auth_token WHERE account_pk = :pk")
    public abstract java.lang.Object searchByPk(int pk, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mvistudy.models.AuthToken> p1);
}