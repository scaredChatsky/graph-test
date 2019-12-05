package com.buchatskij.graphtest.main.domain

import io.reactivex.Single

interface PointsRepository {

    fun get(count: Int): Single<Array<Point>>
}