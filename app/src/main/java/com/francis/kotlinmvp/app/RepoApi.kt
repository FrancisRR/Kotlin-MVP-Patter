package com.francis.kotlinmvp.app

import com.francis.kotlinmvp.data.response.google.autocomplete.AutoCompleteResponse
import com.francis.kotlinmvp.data.response.google.search.GoogleSearchResponse
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {


    @GET(ApiConstant.SEARCHKEY)
    fun getAddress(@Query("query") query: String, @Query("key") key: String): Deferred<GoogleSearchResponse>

    @GET(ApiConstant.SEARCHKEY)
    fun getAddress1(@Query("query") query: String, @Query("key") key: String): Observable<GoogleSearchResponse>?

    @GET(ApiConstant.SEARCHKEY)
    fun getAddress2(@Query("query") query: String, @Query("key") key: String): Call<GoogleSearchResponse>


    @GET(ApiConstant.AUTOCOMPLETE)
    fun autoComplete(@Query("input") input: String, @Query("key") key: String): Observable<AutoCompleteResponse>?


}