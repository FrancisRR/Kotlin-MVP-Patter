package com.francis.kotlinmvp.app

interface BasePresenter<V> {

    fun setView(view: V)
}