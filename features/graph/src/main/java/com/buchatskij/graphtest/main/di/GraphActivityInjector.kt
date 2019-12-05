package com.buchatskij.graphtest.main.di

import com.buchatskij.graphtest.di.FeatureScope
import com.buchatskij.graphtest.main.ui.GraphActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface GraphActivityInjector {

    @FeatureScope
    @ContributesAndroidInjector(modules = [GraphActivityModule::class])
    fun graphActivityInjector(): GraphActivity
}