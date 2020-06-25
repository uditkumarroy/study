package com.mvistudy.di.cogzi

import androidx.lifecycle.ViewModel
import com.mvistudy.di.ViewModelKey
import com.mvistudy.ui.cognizant.CognizantViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CognizantViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CognizantViewModel::class)
    abstract fun bindCognizantViewModel(cognizantViewModel: CognizantViewModel): ViewModel

}