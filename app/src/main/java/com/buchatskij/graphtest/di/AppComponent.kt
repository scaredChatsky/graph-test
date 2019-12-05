package com.buchatskij.graphtest.di

import android.content.Context
import com.buchatskij.graphtest.App
import com.buchatskij.graphtest.main.di.GraphActivityInjector
import com.buchatskij.graphtest.main.di.MainActivityInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityInjector::class,
        GraphActivityInjector::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}