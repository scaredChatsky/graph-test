package com.buchatskij.graphtest.main.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buchatskij.graphtest.uicommon.SingleLiveEvent
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    val pointsCount = MutableLiveData<String>()
    val goEvent = SingleLiveEvent<Unit>()

    fun handleGo() {
        goEvent.call()
    }
}