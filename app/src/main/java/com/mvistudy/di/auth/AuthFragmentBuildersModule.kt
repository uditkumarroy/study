package com.mvistudy.di.auth


import com.mvistudy.ui.auth.ForgotPasswordFragment
import com.mvistudy.ui.auth.LauncherFragment
import com.mvistudy.ui.auth.LoginFragment
import com.mvistudy.ui.auth.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AuthFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector()
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector()
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector()
    abstract fun contributeForgotPasswordFragment(): ForgotPasswordFragment

}