package com.mvistudy.repository.auth

import com.mvistudy.api.auth.OpenAuthApiService
import com.mvistudy.persistence.AccountPropertiesDao
import com.mvistudy.persistence.AuthTokenDao
import com.mvistudy.session.SessionManager

class AuthRepository constructor(
    val authTokenDao: AuthTokenDao, val accountPropertiesDao: AccountPropertiesDao
    , val openAuthApiService: OpenAuthApiService, val sessionManager: SessionManager
)