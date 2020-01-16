package com.buchatskij.graphtest.main.presentation

import com.buchatskij.graphtest.domain.Point
import com.buchatskij.graphtest.main.BaseTestCase
import com.buchatskij.graphtest.main.domain.GetPointsListUseCase
import com.buchatskij.graphtest.uicommon.UiState
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import org.junit.Assert.assertArrayEquals
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class GraphViewModelTest : BaseTestCase() {

    private val getPointsListUseCase: GetPointsListUseCase = mock()

    private val viewModel = GraphViewModel(getPointsListUseCase)

    private val points = arrayOf(Point(1.0, 2.0), Point(5.0, 7.0))

    @BeforeTest
    fun before() {
        whenever(getPointsListUseCase(2)).thenReturn(Single.just(points))
    }

    @AfterTest
    fun after() {
        verifyNoMoreInteractions(getPointsListUseCase)
    }

    @Test
    fun `WHEN viewmodel initialized EXPECT viewmodel has expected state`() {
        assertArrayEquals(arrayOf<Point>(), viewModel.points.value)
        assertEquals(UiState.PROGRESS, viewModel.uiState.value)
    }

    @Test
    fun `WHEN setPointsCount EXPECT points updated`() {
        viewModel.setPointsCount(2)

        verify(getPointsListUseCase).invoke(2)

        assertEquals(UiState.CONTENT, viewModel.uiState.value)
        assertEquals(points, viewModel.points.value)
    }

    @Test
    fun `WHEN getPointsListUseCase return error EXPECT error state`() {
        whenever(getPointsListUseCase(2)).thenReturn(Single.error(Exception()))

        viewModel.setPointsCount(2)

        verify(getPointsListUseCase).invoke(2)

        assertEquals(UiState.FAIL, viewModel.uiState.value)
        assertArrayEquals(emptyArray(), viewModel.points.value)
    }

    @Test
    fun `WHEN call retry EXPECT points updated`() {
        whenever(getPointsListUseCase(2)).thenReturn(Single.error(Exception()))

        viewModel.setPointsCount(2)

        verify(getPointsListUseCase).invoke(2)

        assertEquals(UiState.FAIL, viewModel.uiState.value)
        assertArrayEquals(emptyArray(), viewModel.points.value)

        whenever(getPointsListUseCase(2)).thenReturn(Single.just(points))

        viewModel.retry()

        assertEquals(UiState.CONTENT, viewModel.uiState.value)
        assertArrayEquals(points, viewModel.points.value)

        verify(getPointsListUseCase, times(2)).invoke(2)
    }
}