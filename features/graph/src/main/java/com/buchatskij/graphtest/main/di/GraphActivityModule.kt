package com.buchatskij.graphtest.main.di

import androidx.lifecycle.ViewModel
import com.buchatskij.graphtest.base.Converter
import com.buchatskij.graphtest.response.Response
import com.buchatskij.graphtest.di.ViewModelKey
import com.buchatskij.graphtest.main.data.*
import com.buchatskij.graphtest.main.domain.GetPointsListUseCase
import com.buchatskij.graphtest.main.domain.GetPointsListUseCaseImpl
import com.buchatskij.graphtest.main.domain.Point
import com.buchatskij.graphtest.main.domain.PointsRepository
import com.buchatskij.graphtest.main.presentation.GraphViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class GraphActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providePointsApi(retrofit: Retrofit): PointsApi =
            retrofit.create(PointsApi::class.java)
    }

    @Binds
    @IntoMap
    @ViewModelKey(GraphViewModel::class)
    abstract fun bindGraphActivityViewModel(graphViewModel: GraphViewModel): ViewModel

    @Binds
    abstract fun bindGetPointsListUseCase(
        getPointsListUseCaseImpl: GetPointsListUseCaseImpl
    ): GetPointsListUseCase

    @Binds
    abstract fun bindPointsRepository(
        pointsRepositoryImpl: PointsRepositoryImpl
    ): PointsRepository

    @Binds
    abstract fun bindPointsDataSource(
        pointsDataSourceImpl: PointsDataSourceImpl
    ): PointsDataSource

    @Binds
    abstract fun bindPointsResponseConverter(
        pointsResponseConverter: PointsResponseConverter
    ): Converter<Response<PointsResponse>, Array<Point>>
}