package com.buchatskij.graphtest.main.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buchatskij.graphtest.router.ArgumentedRoute
import com.buchatskij.graphtest.router.Route
import com.buchatskij.graphtest.router.RouteArguments
import com.buchatskij.graphtest.uicommon.SingleLiveEvent
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    val pointsCount = MutableLiveData<String>()
    val route = SingleLiveEvent<ArgumentedRoute>()

    fun handleGo() {
        val pointsCount = pointsCount.value?.toInt() ?: return

        route.value = ArgumentedRoute(Route.GRAPH_SCREEN)
            .apply {
                putInt(RouteArguments.POINTS_COUNT_ARG, pointsCount)
            }
    }
}