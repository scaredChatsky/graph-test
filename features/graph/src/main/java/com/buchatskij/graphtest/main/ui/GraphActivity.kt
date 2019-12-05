package com.buchatskij.graphtest.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.buchatskij.graphtest.graph.R
import com.buchatskij.graphtest.graph.databinding.ActivityGraphBinding
import com.buchatskij.graphtest.main.presentation.GraphViewModel
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

    private val viewModel: GraphViewModel by lazy {
        injectViewModel<GraphViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityGraphBinding>(this, R.layout.activity_graph).also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        viewModel.setPointsCount(intent.getIntExtra(EXTRA_POINT_COUNT, 0))

        initHandlers()
    }

    private fun initHandlers() {
        viewModel.errorMessage.observe(::getLifecycle) {
            AlertDialog.Builder(this)
                .setTitle(it)
                .setOnDismissListener { onBackPressed() }
                .setPositiveButton(R.string.ok) { _, _ ->
                    onBackPressed()
                }.show()
        }
    }
}