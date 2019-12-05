package com.buchatskij.graphtest.di

import androidx.lifecycle.ViewModelProvider
import com.buchatskij.graphtest.router.RouterFactory
import com.buchatskij.graphtest.router.RouterFactoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
interface AppModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactoryImpl): ViewModelProvider.Factory

    @Binds
    fun bindRouterFactory(routerFactory: RouterFactoryImpl): RouterFactory
}