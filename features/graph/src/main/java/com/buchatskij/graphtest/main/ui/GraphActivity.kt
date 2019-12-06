package com.buchatskij.graphtest.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.buchatskij.graphtest.graph.R
import com.buchatskij.graphtest.graph.databinding.ActivityGraphBinding
import com.buchatskij.graphtest.main.presentation.GraphViewModel
import com.buchatskij.graphtest.main.ui.list.GraphAdapter
import com.buchatskij.graphtest.uicommon.BaseActivity
import com.buchatskij.graphtest.utils.injectViewModel

class GraphActivity : BaseActivity() {

    companion object {

        private const val EXTRA_POINT_COUNT = "EXTRA_POINT_COUNT"

        fun start(activity: AppCompatActivity, pointsCount: Int) {
            val intent = Intent(activity, GraphActivity::class.java)
                .apply {
                    putExtra(EXTRA_POINT_COUNT, pointsCount)
                }

            activity.startActivity(intent)
        }
    }

    private val adapter = GraphAdapter()

    private val viewModel: GraphViewModel by lazy {
        injectViewModel<GraphViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initHandlers()

        DataBindingUtil.setContentView<ActivityGraphBinding>(this, R.layout.activity_graph).also {
            it.activityGraphList.adapter = adapter

            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        viewModel.setPointsCount(intent.getIntExtra(EXTRA_POINT_COUNT, 0))
    }

    private fun initHandlers() {
        var exit = true
        viewModel.errorMessage.observe(::getLifecycle) {
            AlertDialog.Builder(this)
                .setTitle(it)
                .setOnDismissListener {
                    if (!exit) {
                        exit = true
                        return@setOnDismissListener
                    }
                    onBackPressed()
                }
                .setNegativeButton(R.string.cancel) { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton(R.string.retry) { _, _ ->
                    exit = false
                    viewModel.retry()
                }.show()
        }

        viewModel.points.observe(this, Observer {
            adapter.items = it
        })
    }
}