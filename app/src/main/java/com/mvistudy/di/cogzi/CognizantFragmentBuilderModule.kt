package com.mvistudy.di.cogzi

import com.mvistudy.ui.cognizant.CognizantPostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CognizantFragmentBuilderModule {

    @ContributesAndroidInjector()
    abstract fun contributeCognizantPostFragment(): CognizantPostFragment

}