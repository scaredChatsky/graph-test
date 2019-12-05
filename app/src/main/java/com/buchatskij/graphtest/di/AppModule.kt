package com.buchatskij.graphtest.di

import androidx.lifecycle.ViewModelProvider
import com.buchatskij.graphtest.network.di.NetworkModule
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
interface AppModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactoryImpl): ViewModelProvider.Factory
}