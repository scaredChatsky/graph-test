package com.buchatskij.graphtest.di

import androidx.lifecycle.ViewModelProvider
import com.buchatskij.graphtest.router.Router
import com.buchatskij.graphtest.router.RouterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
interface AppModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactoryImpl): ViewModelProvider.Factory

    @Binds
    fun bindRouter(routerImpl: RouterImpl): Router
}