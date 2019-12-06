package com.buchatskij.graphtest.main.presentation

import androidx.lifecycle.MutableLiveData
import com.buchatskij.graphtest.base.BaseViewModel
import com.buchatskij.graphtest.domain.Point
import com.buchatskij.graphtest.main.domain.GetPointsListUseCase
import com.buchatskij.graphtest.uicommon.SingleLiveEvent
import com.buchatskij.graphtest.uicommon.UiState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GraphViewModel @Inject constructor(
    private val getPointsListUseCase: GetPointsListUseCase
) : BaseViewModel() {

    val points = MutableLiveData<Array<Point>>(emptyArray())
    val errorMessage = SingleLiveEvent<String>()

    val uiState = MutableLiveData<UiState>(UiState.PROGRESS)

    fun setPointsCount(pointsCount: Int) {
        updatePoints(pointsCount)
    }

    private fun updatePoints(pointsCount: Int) {
        uiState.value = UiState.PROGRESS
        disposables.add(
            getPointsListUseCase(pointsCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(::handlePoints, ::handleError)
        )
    }

    private fun handlePoints(points: Array<Point>) {
        this.points.value = points
        uiState.value = UiState.CONTENT
    }

    private fun handleError(throwable: Throwable) {
        uiState.value = UiState.FAIL
        errorMessage.value = throwable.message
    }
}