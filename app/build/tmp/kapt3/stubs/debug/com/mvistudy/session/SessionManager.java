package com.mvistudy.session;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/mvistudy/session/SessionManager;", "", "authTokenDao", "Lcom/mvistudy/persistence/AuthTokenDao;", "application", "Landroid/app/Application;", "(Lcom/mvistudy/persistence/AuthTokenDao;Landroid/app/Application;)V", "TAG", "", "_cachedToken", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mvistudy/models/AuthToken;", "getApplication", "()Landroid/app/Application;", "getAuthTokenDao", "()Lcom/mvistudy/persistence/AuthTokenDao;", "cachedToken", "Landroidx/lifecycle/LiveData;", "getCachedToken", "()Landroidx/lifecycle/LiveData;", "isConnectedToTheInternet", "", "login", "", "newValue", "logout", "setValue", "app_debug"})
@javax.inject.Singleton()
public final class SessionManager {
    private final java.lang.String TAG = "AppDebug";
    private final androidx.lifecycle.MutableLiveData<com.mvistudy.models.AuthToken> _cachedToken = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mvistudy.persistence.AuthTokenDao authTokenDao = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application application = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.mvistudy.models.AuthToken> getCachedToken() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    com.mvistudy.models.AuthToken newValue) {
    }
    
    public final void logout() {
    }
    
    public final void setValue(@org.jetbrains.annotations.Nullable()
    com.mvistudy.models.AuthToken newValue) {
    }
    
    public final boolean isConnectedToTheInternet() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mvistudy.persistence.AuthTokenDao getAuthTokenDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getApplication() {
        return null;
    }
    
    @javax.inject.Inject()
    public SessionManager(@org.jetbrains.annotations.NotNull()
    com.mvistudy.persistence.AuthTokenDao authTokenDao, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
}