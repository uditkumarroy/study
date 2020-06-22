package com.mvistudy.di

import com.mvistudy.di.auth.AuthFragmentBuildersModule
import com.mvistudy.di.auth.AuthModule
import com.mvistudy.di.auth.AuthScope
import com.mvistudy.di.auth.AuthViewModelModule
import com.mvistudy.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuildersModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

}