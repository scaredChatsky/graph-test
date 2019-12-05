package com.buchatskij.graphtest.main.di

import androidx.lifecycle.ViewModel
import com.buchatskij.graphtest.di.ViewModelKey
import com.buchatskij.graphtest.main.presentation.GraphViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GraphActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(GraphViewModel::class)
    protected abstract fun graphActivityViewModel(graphViewModel: GraphViewModel): ViewModel

}