package com.mvistudy.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mvistudy.api.auth.network_response.LoginResponse
import com.mvistudy.repository.auth.AuthRepository
import com.mvistudy.utils.GenericApiResponse
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : ViewModel() {

    fun testLogin(): LiveData<GenericApiResponse<LoginResponse>> {
        return authRepository.testtingLoginRequest(
            "mitchelltabian@gmail.com",
            "codingwithmitch1"
        )
    }

}