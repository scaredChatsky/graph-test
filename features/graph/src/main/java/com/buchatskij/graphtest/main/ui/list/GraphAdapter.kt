package com.buchatskij.graphtest.main.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buchatskij.graphtest.domain.Point
import com.buchatskij.graphtest.graph.R
import com.buchatskij.graphtest.graph.databinding.GraphItemBinding
import com.buchatskij.graphtest.graph.databinding.PointItemBinding

enum class ViewType {
    HEADER,
    ITEM,
    GRAPH
}

class GraphAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: Array<Point> = emptyArray()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewType.HEADER.ordinal ->
                HeaderViewHolder(inflater.inflate(R.layout.header_item, parent, false))
            ViewType.GRAPH.ordinal ->
                GraphItemViewHolder(GraphItemBinding.inflate(inflater, parent, false))
            else -> PointItemViewHolder(PointItemBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = items.size + 2

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> ViewType.HEADER.ordinal
            items.size + 1 -> ViewType.GRAPH.ordinal
            else -> ViewType.ITEM.ordinal
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PointItemViewHolder -> holder.bind(items[position - 1])
            is GraphItemViewHolder -> holder.bind(items)
        }
    }


}