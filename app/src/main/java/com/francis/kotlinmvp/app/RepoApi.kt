package com.francis.kotlinmvp.app

import com.francis.kotlinmvp.data.response.postdetails.PostDetailsResponse
import com.francis.kotlinmvp.data.response.postlist.PostListResponse
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface RepoApi {

    @GET("todos/1")
    fun getPostDetails(): Observable<PostDetailsResponse>?

    @GET("todos/1")
    fun getPostList(): Observable<PostDetailsResponse>?


    @GET("todos/1")
    fun getPostList1(): Deferred<PostDetailsResponse>

    @GET("todos/1")
    fun getPostList2(): Call<PostDetailsResponse>


}