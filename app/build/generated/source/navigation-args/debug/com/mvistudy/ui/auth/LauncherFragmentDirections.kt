package com.mvistudy.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.mvistudy.R

class LauncherFragmentDirections private constructor() {
    companion object {
        fun actionLauncherFragmentToLoginFragment(): NavDirections =
                ActionOnlyNavDirections(R.id.action_launcherFragment_to_loginFragment)

        fun actionLauncherFragmentToRegisterFragment(): NavDirections =
                ActionOnlyNavDirections(R.id.action_launcherFragment_to_registerFragment)

        fun actionLauncherFragmentToForgotPasswordFragment(): NavDirections =
                ActionOnlyNavDirections(R.id.action_launcherFragment_to_forgotPasswordFragment)
    }
}
