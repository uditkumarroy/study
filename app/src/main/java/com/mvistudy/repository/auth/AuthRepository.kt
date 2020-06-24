package com.mvistudy.repository.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import com.mvistudy.api.auth.OpenAuthApiService
import com.mvistudy.models.AuthToken
import com.mvistudy.persistence.AccountPropertiesDao
import com.mvistudy.persistence.AuthTokenDao
import com.mvistudy.session.SessionManager
import com.mvistudy.ui.DataState
import com.mvistudy.ui.auth.state.AuthViewState
import com.mvistudy.utils.ApiSuccessResponse
import javax.inject.Inject


class AuthRepository
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val openApiAuthService: OpenAuthApiService,
    val sessionManager: SessionManager
) {

    fun attemptLogin(email: String, password: String): LiveData<DataState<AuthViewState>> {
        return openApiAuthService.login(email, password)
            .switchMap { response ->
                object : LiveData<DataState<AuthViewState>>() {
                    override fun onActive() {
                        super.onActive()
                        when (response) {
                            is ApiSuccessResponse -> {
                                value = DataState.data(
                                    AuthViewState(
                                        authToken = AuthToken(response.body.pk, response.body.token)
                                    ),
                                    response = null
                                )
                            }

                        }
                    }
                }
            }
    }


    fun attemptRegistration(
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): LiveData<DataState<AuthViewState>> {
        return openApiAuthService.register(email, username, password, confirmPassword)
            .switchMap { response ->
                object : LiveData<DataState<AuthViewState>>() {
                    override fun onActive() {
                        super.onActive()
                        when (response) {
                            is ApiSuccessResponse -> {
                                value = DataState.data(
                                    AuthViewState(
                                        authToken = AuthToken(response.body.pk, response.body.token)
                                    ),
                                    response = null
                                )
                            }

                        }
                    }
                }
            }
    }

}