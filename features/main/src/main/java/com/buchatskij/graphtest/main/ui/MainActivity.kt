package com.buchatskij.graphtest.main.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.buchatskij.graphtest.main.R
import com.buchatskij.graphtest.main.databinding.ActivityMainBinding
import com.buchatskij.graphtest.main.presentation.MainActivityViewModel
import com.buchatskij.graphtest.root.utils.injectViewModel
import com.buchatskij.graphtest.uicommon.BaseActivity

class MainActivity : BaseActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        injectViewModel<MainActivityViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.viewModel = viewModel
        }

        initHandlers()
    }

    private fun initHandlers() {
        viewModel.goEvent.observe(this, Observer {
            // TODO go to points activity
        })
    }
}