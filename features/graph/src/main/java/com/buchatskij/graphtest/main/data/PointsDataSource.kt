package com.buchatskij.graphtest.main.data

import com.buchatskij.graphtest.response.Response
import io.reactivex.Single
import javax.inject.Inject

interface PointsDataSource {

    fun getPoints(count: Int): Single<Response<PointsResponse>>
}

class PointsDataSourceImpl @Inject constructor(
    private val pointsApi: PointsApi
) : PointsDataSource {

    override fun getPoints(count: Int): Single<Response<PointsResponse>> =
        pointsApi.getPoints(count)
}