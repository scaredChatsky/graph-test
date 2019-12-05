package com.buchatskij.graphtest.main.data

import com.buchatskij.graphtest.domain.Point

data class PointsResponse(val points: Array<Point>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PointsResponse

        if (!points.contentEquals(other.points)) return false

        return true
    }

    override fun hashCode(): Int {
        return points.contentHashCode()
    }
}