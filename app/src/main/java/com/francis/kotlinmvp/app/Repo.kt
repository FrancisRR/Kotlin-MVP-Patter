package com.francis.kotlinmvp.app

import android.util.Log
import com.francis.kotlinmvp.data.response.google.autocomplete.AutoCompleteResponse
import com.francis.kotlinmvp.data.response.google.search.GoogleSearchResponse
import com.francis.kotlinmvp.utils.RxjavaUtils
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback

class Repo(val repoApi: RepoApi) {

    var searchKey: String = "chennai"
    var googleKey: String = "AIzaSyDlWwGHFqX09wrxJREGVqB-GFqCR1oM358"

    //couroutine api call
    fun getValue(): Deferred<GoogleSearchResponse?> {
        return GlobalScope.async {
            val response = repoApi.getAddress(searchKey, googleKey).await()
            return@async response
        }
    }


    //rxjava api call
    fun getSearchRes(): Observable<GoogleSearchResponse>? {
        return repoApi
            ?.getAddress1(searchKey, googleKey)
            ?.compose(RxjavaUtils.applyErrorTransformer())
            ?.map { it }
    }

    fun getAutoComplete(): Observable<AutoCompleteResponse>? {
        return repoApi.autoComplete("Pizza", googleKey)
            ?.compose(RxjavaUtils.applyErrorTransformer())
            ?.map { it }

    }


    //retrofit normal api call
    fun getValue3() {
        val call: Call<GoogleSearchResponse>? = repoApi?.getAddress2(searchKey, googleKey)
        call?.enqueue(object : Callback<GoogleSearchResponse> {
            override fun onResponse(
                call: Call<GoogleSearchResponse>,
                response: retrofit2.Response<GoogleSearchResponse>
            ) {
                if (response.isSuccessful) {
                    val resss = response.body();
                }
            }

            override fun onFailure(call: Call<GoogleSearchResponse>, t: Throwable) {
                Log.e("Fail", t.message)
            }
        })

    }

}

