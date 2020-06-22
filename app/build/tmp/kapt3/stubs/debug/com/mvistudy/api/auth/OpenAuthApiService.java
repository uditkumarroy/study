package com.mvistudy.api.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\'J<\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H\'\u00a8\u0006\r"}, d2 = {"Lcom/mvistudy/api/auth/OpenAuthApiService;", "", "login", "Landroidx/lifecycle/LiveData;", "Lcom/mvistudy/utils/GenericApiResponse;", "Lcom/mvistudy/api/auth/network_response/LoginResponse;", "email", "", "password", "register", "Lcom/mvistudy/api/auth/network_response/RegistrationResponse;", "username", "password2", "app_debug"})
public abstract interface OpenAuthApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.POST(value = "account/login")
    public abstract androidx.lifecycle.LiveData<com.mvistudy.utils.GenericApiResponse<com.mvistudy.api.auth.network_response.LoginResponse>> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.POST(value = "account/register")
    public abstract androidx.lifecycle.LiveData<com.mvistudy.utils.GenericApiResponse<com.mvistudy.api.auth.network_response.RegistrationResponse>> register(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password2")
    java.lang.String password2);
}