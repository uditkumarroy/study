package com.mvistudy.di

import com.mvistudy.di.auth.AuthFragmentBuildersModule
import com.mvistudy.di.auth.AuthModule
import com.mvistudy.di.auth.AuthScope
import com.mvistudy.di.auth.AuthViewModelModule
import com.mvistudy.di.cogzi.CognizantFragmentBuilderModule
import com.mvistudy.di.cogzi.CognizantModule
import com.mvistudy.di.cogzi.CognizantViewModelModule
import com.mvistudy.di.cogzi.CogziScope
import com.mvistudy.ui.auth.AuthActivity
import com.mvistudy.ui.cognizant.CognizantActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuildersModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @CogziScope
    @ContributesAndroidInjector(
        modules = [CognizantModule::class, CognizantFragmentBuilderModule::class, CognizantViewModelModule::class]
    )
    abstract fun contributeCognizantActivity(): CognizantActivity

}