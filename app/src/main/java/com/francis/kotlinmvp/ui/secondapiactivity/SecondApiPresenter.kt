package com.francis.kotlinmvp.ui.secondapiactivity

import com.francis.kotlinmvp.app.AppbasePresenter
import kotlinx.coroutines.runBlocking

class SecondApiPresenter : AppbasePresenter<SecondApiView>() {

    internal var view: SecondApiView? = null

    override fun setView(view: SecondApiView) {
        super.setView(view)
        this.view = view
    }


    fun coroutineApi() {
        runBlocking { coroutineApiCall() }
    }

    suspend fun coroutineApiCall() {
        repo?.getValue()?.await()

    }


}