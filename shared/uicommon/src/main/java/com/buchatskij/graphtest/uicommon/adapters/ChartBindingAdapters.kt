package com.buchatskij.graphtest.uicommon.adapters

import android.graphics.Color
import androidx.databinding.BindingAdapter
import com.buchatskij.graphtest.domain.Point
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@BindingAdapter("lineChartData")
fun LineChart.setData(points: Array<Point>) {
    val entries = points.map { Entry(it.x.toFloat(), it.y.toFloat()) }
    data = LineData(LineDataSet(entries, "").apply {
        color = Color.RED
        lineWidth = 3f
        setCircleColor(Color.BLUE)
        valueTextSize = 14f
        circleRadius = 3f
        mode = LineDataSet.Mode.HORIZONTAL_BEZIER
    })
    invalidate()
}