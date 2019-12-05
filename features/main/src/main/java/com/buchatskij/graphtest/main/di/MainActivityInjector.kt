package com.buchatskij.graphtest.main.di

import com.buchatskij.graphtest.main.ui.MainActivity
import com.buchatskij.graphtest.di.FeatureScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityInjector {

    @FeatureScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivityInjector(): MainActivity
}