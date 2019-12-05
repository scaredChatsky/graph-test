package com.buchatskij.graphtest.main.domain

import com.buchatskij.graphtest.domain.Point
import io.reactivex.Single

interface PointsRepository {

    fun get(count: Int): Single<Array<Point>>
}