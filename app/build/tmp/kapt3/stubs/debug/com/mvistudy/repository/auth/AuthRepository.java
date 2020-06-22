package com.mvistudy.repository.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/mvistudy/repository/auth/AuthRepository;", "", "authTokenDao", "Lcom/mvistudy/persistence/AuthTokenDao;", "accountPropertiesDao", "Lcom/mvistudy/persistence/AccountPropertiesDao;", "openAuthApiService", "Lcom/mvistudy/api/auth/OpenAuthApiService;", "sessionManager", "Lcom/mvistudy/session/SessionManager;", "(Lcom/mvistudy/persistence/AuthTokenDao;Lcom/mvistudy/persistence/AccountPropertiesDao;Lcom/mvistudy/api/auth/OpenAuthApiService;Lcom/mvistudy/session/SessionManager;)V", "getAccountPropertiesDao", "()Lcom/mvistudy/persistence/AccountPropertiesDao;", "getAuthTokenDao", "()Lcom/mvistudy/persistence/AuthTokenDao;", "getOpenAuthApiService", "()Lcom/mvistudy/api/auth/OpenAuthApiService;", "getSessionManager", "()Lcom/mvistudy/session/SessionManager;", "testtingLoginRequest", "Landroidx/lifecycle/LiveData;", "Lcom/mvistudy/utils/GenericApiResponse;", "Lcom/mvistudy/api/auth/network_response/LoginResponse;", "email", "", "password", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mvistudy.persistence.AuthTokenDao authTokenDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mvistudy.persistence.AccountPropertiesDao accountPropertiesDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mvistudy.api.auth.OpenAuthApiService openAuthApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mvistudy.session.SessionManager sessionManager = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.mvistudy.utils.GenericApiResponse<com.mvistudy.api.auth.network_response.LoginResponse>> testtingLoginRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mvistudy.persistence.AuthTokenDao getAuthTokenDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mvistudy.persistence.AccountPropertiesDao getAccountPropertiesDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mvistudy.api.auth.OpenAuthApiService getOpenAuthApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mvistudy.session.SessionManager getSessionManager() {
        return null;
    }
    
    @javax.inject.Inject()
    public AuthRepository(@org.jetbrains.annotations.NotNull()
    com.mvistudy.persistence.AuthTokenDao authTokenDao, @org.jetbrains.annotations.NotNull()
    com.mvistudy.persistence.AccountPropertiesDao accountPropertiesDao, @org.jetbrains.annotations.NotNull()
    com.mvistudy.api.auth.OpenAuthApiService openAuthApiService, @org.jetbrains.annotations.NotNull()
    com.mvistudy.session.SessionManager sessionManager) {
        super();
    }
}