package com.buchatskij.graphtest.router

import androidx.appcompat.app.AppCompatActivity

interface RouterFactory {

    fun createRouter(activity: AppCompatActivity): Router
}