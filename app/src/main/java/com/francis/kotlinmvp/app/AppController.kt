package com.francis.kotlinmvp.app

import android.app.Application
import android.app.ProgressDialog
import com.francis.kotlinmvp.utils.UiUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppController : Application() {

    internal var repo: Repo? = null
    internal var gson: Gson? = null


    override fun onCreate() {
        super.onCreate()
        instance = this
        gson = GsonBuilder().setLenient().serializeNulls().create()
        repo = createAppRepo()
    }


    companion object {
        var instance: AppController? = null
        fun getInstane() = instance
    }

    private fun createAppRepo(): Repo? {
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpCLient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .addInterceptor(httpLoginInterceptor)
            .build()

        val retrofit =
            Retrofit.Builder().baseUrl(ApiConstant.baseUrl)
                .client(okHttpCLient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

        return Repo(retrofit.create(RepoApi::class.java))

    }

    fun showLoading() {

    }

    fun hideLoading() {

    }

}
