package com.buchatskij.graphtest.main.domain

import com.buchatskij.graphtest.domain.Point
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.AfterTest

@RunWith(MockitoJUnitRunner::class)
class GetPointsListUseCaseImplTest : TestCase() {

    private val pointsRepository: PointsRepository = mock()

    private val getPointsListUseCase = GetPointsListUseCaseImpl(pointsRepository)

    @AfterTest
    fun after() {
        verifyNoMoreInteractions(pointsRepository)
    }

    @Test
    fun `WHEN getPointsListUseCase invoked EXPECT sorted points`() {
        val points = arrayOf(
            Point(10.0, 10.0),
            Point(5.0, 6.0),
            Point(11.0, 22.0),
            Point(123.0, 1.0),
            Point(-1.0, -100.0)
        )

        val sortedPoints = arrayOf(
            Point(-1.0, -100.0),
            Point(5.0, 6.0),
            Point(10.0, 10.0),
            Point(11.0, 22.0),
            Point(123.0, 1.0)
        )

        whenever(pointsRepository.get(5)).thenReturn(Single.just(points))

        getPointsListUseCase(5).test()
            .assertNoErrors()
            .assertComplete()
            .assertValue{ p ->
                p.contentEquals(sortedPoints)
            }

        verify(pointsRepository).get(5)
    }
}