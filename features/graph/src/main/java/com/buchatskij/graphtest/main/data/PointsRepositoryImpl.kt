package com.buchatskij.graphtest.main.data

import com.buchatskij.graphtest.base.Converter
import com.buchatskij.graphtest.response.Response
import com.buchatskij.graphtest.main.domain.Point
import com.buchatskij.graphtest.main.domain.PointsRepository
import io.reactivex.Single
import javax.inject.Inject

class PointsRepositoryImpl @Inject constructor(
    private val pointsDataSource: PointsDataSource,
    private val converter: Converter<Response<PointsResponse>, Array<Point>>
) : PointsRepository {

    override fun get(count: Int): Single<Array<Point>> =
        pointsDataSource.getPoints(count)
            .map(converter::invoke)
}