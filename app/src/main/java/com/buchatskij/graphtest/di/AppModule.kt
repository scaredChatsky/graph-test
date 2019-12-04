package com.buchatskij.graphtest.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactoryImpl): ViewModelProvider.Factory
}