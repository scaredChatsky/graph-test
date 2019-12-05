package com.buchatskij.graphtest.main.di

import androidx.lifecycle.ViewModel
import com.buchatskij.graphtest.main.presentation.MainActivityViewModel
import com.buchatskij.graphtest.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    protected abstract fun mainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

}