package com.buchatskij.graphtest.main.domain

import com.buchatskij.graphtest.domain.Point
import io.reactivex.Single
import javax.inject.Inject

interface GetPointsListUseCase {

    operator fun invoke(count: Int): Single<Array<Point>>
}

class GetPointsListUseCaseImpl @Inject constructor(
    private val pointsRepository: PointsRepository
) : GetPointsListUseCase {

    override fun invoke(count: Int): Single<Array<Point>> =
        pointsRepository.get(count)
            .map {
                it.sortBy { point -> point.x }
                return@map it
            }
}