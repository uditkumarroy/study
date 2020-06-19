package com.mvistudy.persistence;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\'J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/mvistudy/persistence/AccountPropertiesDao;", "", "insertAndReplace", "", "accountProperties", "Lcom/mvistudy/models/AccountProperties;", "insertOrIgnore", "searchByEmail", "email", "", "searchByPk", "pk", "", "updateAccountProperties", "", "username", "app_debug"})
public abstract interface AccountPropertiesDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM account_properties WHERE email = :email")
    public abstract com.mvistudy.models.AccountProperties searchByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM account_properties WHERE pk = :pk")
    public abstract com.mvistudy.models.AccountProperties searchByPk(int pk);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract long insertAndReplace(@org.jetbrains.annotations.NotNull()
    com.mvistudy.models.AccountProperties accountProperties);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract long insertOrIgnore(@org.jetbrains.annotations.NotNull()
    com.mvistudy.models.AccountProperties accountProperties);
    
    @androidx.room.Query(value = "UPDATE account_properties SET email = :email, username = :username WHERE pk = :pk")
    public abstract void updateAccountProperties(int pk, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String username);
}