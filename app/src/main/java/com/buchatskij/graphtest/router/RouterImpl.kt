package com.buchatskij.graphtest.router

import androidx.appcompat.app.AppCompatActivity
import com.buchatskij.graphtest.main.ui.GraphActivity
import javax.inject.Inject

class RouterImpl @Inject constructor(private val activity: AppCompatActivity) : Router {

    override fun route(argumentedRoute: ArgumentedRoute) {
        when (argumentedRoute.route) {
            Route.GRAPH_SCREEN -> openGraphScreen(argumentedRoute)
        }
    }

    private fun openGraphScreen(route: ArgumentedRoute) {
        GraphActivity.start(activity, route.getInt(RouteArguments.POINTS_COUNT_ARG))
    }
}