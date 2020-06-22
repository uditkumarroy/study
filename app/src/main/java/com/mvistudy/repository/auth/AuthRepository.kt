package com.mvistudy.repository.auth

import androidx.lifecycle.LiveData
import com.mvistudy.api.auth.OpenAuthApiService
import com.mvistudy.api.auth.network_response.LoginResponse
import com.mvistudy.persistence.AccountPropertiesDao
import com.mvistudy.persistence.AuthTokenDao
import com.mvistudy.session.SessionManager
import com.mvistudy.utils.GenericApiResponse
import javax.inject.Inject


class AuthRepository @Inject constructor(
    val authTokenDao: AuthTokenDao, val accountPropertiesDao: AccountPropertiesDao
    , val openAuthApiService: OpenAuthApiService, val sessionManager: SessionManager
) {
    fun testtingLoginRequest(
        email: String,
        password: String
    ): LiveData<GenericApiResponse<LoginResponse>> {
        return openAuthApiService.login(email, password)
    }
}