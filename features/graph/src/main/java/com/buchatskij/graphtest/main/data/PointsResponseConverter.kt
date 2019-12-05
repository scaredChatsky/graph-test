package com.buchatskij.graphtest.main.data

import com.buchatskij.graphtest.base.Converter
import com.buchatskij.graphtest.response.Response
import com.buchatskij.graphtest.domain.Point
import javax.inject.Inject

class PointsResponseConverter @Inject constructor() :
    Converter<Response<PointsResponse>, Array<Point>> {

    override fun invoke(from: Response<PointsResponse>): Array<Point> =
        from.response?.points ?: emptyArray()
}