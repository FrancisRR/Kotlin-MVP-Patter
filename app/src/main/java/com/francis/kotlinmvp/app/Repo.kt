package com.francis.kotlinmvp.app

import android.util.Log
import com.francis.kotlinmvp.data.response.postdetails.PostDetailsResponse
import com.francis.kotlinmvp.data.response.postlist.PostListResponse
import com.francis.kotlinmvp.utils.RxjavaUtils
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback

class Repo(val repoApi: RepoApi) {


    //rxjava api call
    fun getPostDetails(): Observable<PostDetailsResponse>? {
        return repoApi
            ?.getPostDetails()
            ?.compose(RxjavaUtils.applyErrorTransformer())
            ?.map { it }
    }

    fun getPostList(): Observable<PostDetailsResponse>? {
        return repoApi.getPostList()
            ?.compose(RxjavaUtils.applyErrorTransformer())
            ?.map { it }

    }


    //couroutine api call
    fun getValue(): Deferred<PostDetailsResponse?> {
        return GlobalScope.async {
            val response = repoApi.getPostList1().await()
            return@async response
        }
    }


    //retrofit normal api call
    fun getValue3() {
        val call: Call<PostDetailsResponse>? = repoApi?.getPostList2()
        call?.enqueue(object : Callback<PostDetailsResponse> {
            override fun onResponse(
                call: Call<PostDetailsResponse>,
                response: retrofit2.Response<PostDetailsResponse>
            ) {
                if (response.isSuccessful) {
                    val resss = response.body();
                }
            }

            override fun onFailure(call: Call<PostDetailsResponse>, t: Throwable) {
                Log.e("Fail", t.message)
            }
        })

    }

}

