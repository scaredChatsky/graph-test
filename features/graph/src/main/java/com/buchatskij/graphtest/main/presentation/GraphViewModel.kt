package com.buchatskij.graphtest.main.presentation

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class GraphViewModel @Inject constructor() : ViewModel() {

    fun setPointsCount(pointsCount: Int) {
        updatePoints(pointsCount)
    }

    private fun updatePoints(pointsCount: Int) {
        // todo update
    }

}