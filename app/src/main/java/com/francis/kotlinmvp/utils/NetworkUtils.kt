package com.francis.kotlinmvp.utils

import android.content.Context
import android.net.ConnectivityManager
import com.francis.kotlinmvp.app.AppController

object NetworkUtils {

    fun isNetworkConnected(): Boolean {
        val context: Context? = AppController.instance
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }


}