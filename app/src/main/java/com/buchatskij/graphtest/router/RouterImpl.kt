package com.buchatskij.graphtest.router

import android.content.Context
import javax.inject.Inject

class RouterImpl @Inject constructor(private val context: Context) : Router {

    override fun route(argumentedRoute: ArgumentedRoute) {
        when (argumentedRoute.route) {
            Route.POINTS_SCREEN -> openPointsScreen(argumentedRoute)
        }
    }

    private fun openPointsScreen(route: ArgumentedRoute) {
        // todo launch points activity
    }
}