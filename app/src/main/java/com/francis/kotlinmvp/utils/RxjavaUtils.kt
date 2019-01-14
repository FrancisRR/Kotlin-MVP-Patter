package com.francis.kotlinmvp.utils

import io.reactivex.CompletableTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


object RxjavaUtils {


    fun <T> applyObserverSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyNewObservableScheduler(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable -> observable.subscribeOn(Schedulers.newThread()) }
    }

    fun applyCompletableSchedulers(): CompletableTransformer {
        return CompletableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyErrorTransformer(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.onErrorResumeNext(Function { throwable ->
                try {
                    if (throwable is ConnectException || throwable is UnknownHostException) {
                        if (!NetworkUtils.isNetworkConnected()) {
                            Observable.error(RuntimeException("No internet connection..."))
                        } else {
                            Observable.error(RuntimeException("Unknown Host Exception..."))
                        }

                    } else if (throwable is SocketTimeoutException) {
                        Observable.error(RuntimeException("Slow internet connection..."))
                    } else {
                        Observable.error(throwable)
                    }

                } catch (e: Exception) {
                    Observable.error(throwable)
                }

            })
        }
    }

}

