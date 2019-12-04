package com.buchatskij.graphtest.di

import android.app.Application
import com.buchatskij.graphtest.App
import com.buchatskij.graphtest.main.di.MainActivityInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityInjector::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}