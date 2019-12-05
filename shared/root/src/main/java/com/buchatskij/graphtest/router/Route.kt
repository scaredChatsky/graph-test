package com.buchatskij.graphtest.router

enum class Route {

    GRAPH_SCREEN;
}

object RouteArguments {

    const val POINTS_COUNT_ARG = "POINTS_COUNT_ARG"
}

class ArgumentedRoute(val route: Route) {

    private val params: MutableMap<String, Any> = HashMap()

    fun putInt(key: String, value: Int) {
        params[key] = value
    }

    fun getInt(key: String): Int = params[key] as Int
}