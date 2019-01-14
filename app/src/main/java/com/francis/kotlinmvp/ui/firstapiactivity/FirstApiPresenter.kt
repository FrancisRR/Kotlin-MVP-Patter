package com.francis.kotlinmvp.ui.firstapiactivity

import android.annotation.SuppressLint
import com.francis.kotlinmvp.app.AppbasePresenter
import com.francis.kotlinmvp.data.response.CompainRes
import com.francis.kotlinmvp.data.response.google.autocomplete.AutoCompleteResponse
import com.francis.kotlinmvp.data.response.google.search.GoogleSearchResponse
import com.francis.kotlinmvp.utils.RxjavaUtils
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

class FirstApiPresenter : AppbasePresenter<FirstApiView>() {

    internal var view: FirstApiView? = null

    override fun setView(view: FirstApiView) {
        super.setView(view)
        this.view = view
    }

    @SuppressLint("CheckResult")
    fun getSearchResponse() {
        view!!.showLoading()
        repo?.getSearchRes()
            ?.compose(RxjavaUtils.applyObserverSchedulers())
            ?.subscribe({ response ->
                view?.onApiSuccess(response)
                view?.hideLoading()
            }, { throwable: Throwable? ->
                view?.hideLoading()
                exceptionHandling(throwable)
            }
            )
    }

    @SuppressLint("CheckResult")
    fun zipOperator() {
        view?.showLoading()
        Observable.zip(
            repo?.getSearchRes(), repo?.getAutoComplete(),
            BiFunction { t1: GoogleSearchResponse, t2: AutoCompleteResponse ->
                val res = CompainRes()
                res.searchResponse = t1
                res.autoCompleResponse = t2
                return@BiFunction res
            }
        ).compose(RxjavaUtils.applyObserverSchedulers())
            .subscribe({ response ->
                view?.onZipResponseSuccess(response)
                view?.hideLoading()
            },
                { throwable: Throwable? ->
                    exceptionHandling(throwable)
                    view?.hideLoading()
                })

    }


}