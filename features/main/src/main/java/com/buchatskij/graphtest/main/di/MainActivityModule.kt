package com.buchatskij.graphtest.main.di

import com.buchatskij.graphtest.main.Test
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideGson(): Test = Test()

}