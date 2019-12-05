package com.buchatskij.graphtest.main.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.buchatskij.graphtest.main.R
import com.buchatskij.graphtest.main.databinding.ActivityMainBinding
import com.buchatskij.graphtest.main.presentation.MainActivityViewModel
import com.buchatskij.graphtest.router.RouterFactory
import com.buchatskij.graphtest.uicommon.BaseActivity
import com.buchatskij.graphtest.utils.injectViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        injectViewModel<MainActivityViewModel>(viewModelFactory)
    }

    @Inject
    lateinit var routerFactory: RouterFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.viewModel = viewModel
        }

        initHandlers()
    }

    private fun initHandlers() {
        val router = routerFactory.createRouter(this)
        viewModel.route.observe(this, Observer {
            router.route(it)
        })
    }
}