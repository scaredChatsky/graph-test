package com.buchatskij.graphtest.main.ui

import com.buchatskij.graphtest.main.presentation.MainActivityViewModel
import com.buchatskij.graphtest.root.ui.BaseActivity
import com.buchatskij.graphtest.root.utils.injectViewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        injectViewModel<MainActivityViewModel>(viewModelFactory)
    }
}