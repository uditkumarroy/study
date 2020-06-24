package com.mvistudy.ui.auth

import androidx.lifecycle.LiveData
import com.mvistudy.models.AuthToken
import com.mvistudy.repository.auth.AuthRepository
import com.mvistudy.ui.BaseViewModel
import com.mvistudy.ui.DataState
import com.mvistudy.ui.auth.state.AuthStateEvent
import com.mvistudy.ui.auth.state.AuthStateEvent.*
import com.mvistudy.ui.auth.state.AuthViewState
import com.mvistudy.ui.auth.state.LoginFields
import com.mvistudy.ui.auth.state.RegistrationFields
import com.mvistudy.utils.AbsentLiveData
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : BaseViewModel<AuthStateEvent, AuthViewState>() {
    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {
        when (stateEvent) {

            is LoginAttemptEvent -> {
                return AbsentLiveData.create()
            }

            is RegisterAttemptEvent -> {
                return AbsentLiveData.create()
            }

            is CheckPreviousAuthEvent -> {
                return AbsentLiveData.create()
            }


        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }

    fun setRegistrationFields(registrationFields: RegistrationFields) {
        val update = getCurrentViewStateOrNew()
        if (update.registrationFields == registrationFields) {
            return
        }
        update.registrationFields = registrationFields
        _viewState.value = update
    }

    fun setLoginFields(loginFields: LoginFields) {
        val update = getCurrentViewStateOrNew()
        if (update.loginFields == loginFields) {
            return
        }
        update.loginFields = loginFields
        _viewState.value = update
    }

    fun setAuthToken(authToken: AuthToken) {
        val update = getCurrentViewStateOrNew()
        if (update.authToken == authToken) {
            return
        }
        update.authToken = authToken
        _viewState.value = update
    }
}