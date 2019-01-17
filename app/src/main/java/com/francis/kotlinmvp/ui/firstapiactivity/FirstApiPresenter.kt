package com.francis.kotlinmvp.ui.firstapiactivity

import android.annotation.SuppressLint
import com.francis.kotlinmvp.app.AppbasePresenter
import com.francis.kotlinmvp.data.response.CompainRes
import com.francis.kotlinmvp.data.response.postdetails.PostDetailsResponse
import com.francis.kotlinmvp.data.response.postlist.PostListResponse
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
    fun getUserDetails() {
        view!!.showLoading()
        repo?.getPostDetails()
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
            repo?.getPostDetails(), repo?.getPostList(),
            BiFunction { t1: PostDetailsResponse, t2: PostDetailsResponse ->
                val res = CompainRes()
                res.postDetails = t1
                res.postDetailList = t2
                return@BiFunction res
            }
        ).compose(RxjavaUtils.applyObserverSchedulers())
            .subscribe({ response: CompainRes ->
                view?.onZipResponseSuccess(response)
                view?.hideLoading()
            },
                { throwable: Throwable? ->
                    exceptionHandling(throwable)
                    view?.hideLoading()
                })

    }


}