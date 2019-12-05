package com.buchatskij.graphtest.main.presentation

import androidx.lifecycle.MutableLiveData
import com.buchatskij.graphtest.base.BaseViewModel
import com.buchatskij.graphtest.main.domain.GetPointsListUseCase
import com.buchatskij.graphtest.domain.Point
import com.buchatskij.graphtest.uicommon.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GraphViewModel @Inject constructor(
    private val getPointsListUseCase: GetPointsListUseCase
) : BaseViewModel() {

    val points = MutableLiveData<Array<Point>>(emptyArray())
    val errorMessage = SingleLiveEvent<String>()

    fun setPointsCount(pointsCount: Int) {
        updatePoints(pointsCount)
    }

    private fun updatePoints(pointsCount: Int) {
        disposables.add(
            getPointsListUseCase(pointsCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(::handlePoints, ::handleError)
        )
    }

    private fun handlePoints(points: Array<Point>) {
        this.points.value = points
    }

    private fun handleError(throwable: Throwable) {
        errorMessage.value = throwable.message
    }
}