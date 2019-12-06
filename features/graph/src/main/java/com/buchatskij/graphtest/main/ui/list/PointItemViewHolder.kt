package com.buchatskij.graphtest.main.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.buchatskij.graphtest.domain.Point
import com.buchatskij.graphtest.graph.databinding.PointItemBinding

class PointItemViewHolder(
    private val pointItemBinding: PointItemBinding
) : RecyclerView.ViewHolder(pointItemBinding.root) {

    fun bind(point: Point) {
        pointItemBinding.point = point
    }
}