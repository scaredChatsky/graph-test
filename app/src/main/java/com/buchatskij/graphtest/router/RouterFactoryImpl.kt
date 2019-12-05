package com.buchatskij.graphtest.router

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class RouterFactoryImpl @Inject constructor() : RouterFactory {

    override fun createRouter(activity: AppCompatActivity): Router = RouterImpl(activity)
}