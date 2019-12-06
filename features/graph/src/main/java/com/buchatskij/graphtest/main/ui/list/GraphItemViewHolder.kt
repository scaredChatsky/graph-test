package com.buchatskij.graphtest.main.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.buchatskij.graphtest.domain.Point
import com.buchatskij.graphtest.graph.databinding.GraphItemBinding

class GraphItemViewHolder(
    private val graphItemBinding: GraphItemBinding
) : RecyclerView.ViewHolder(graphItemBinding.root) {

    fun bind(points: Array<Point>) {
        graphItemBinding.points = points
    }
}