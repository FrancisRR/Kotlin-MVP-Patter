package com.francis.kotlinmvp.app

import android.util.Log

abstract class AppbasePresenter<V : BaseView> : BasePresenter<V> {

    private var view: V? = null
    internal var appController: AppController? = null
    internal var repo: Repo? = null

    override fun setView(view: V) {
        this.view = view
        appController = AppController.instance
        repo = appController!!.repo

    }

    internal fun exceptionHandling(throwable: Throwable?) {
        Log.e("Api Failed", throwable?.message);
    }


}