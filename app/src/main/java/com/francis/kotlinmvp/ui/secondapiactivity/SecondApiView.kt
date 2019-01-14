package com.francis.kotlinmvp.ui.secondapiactivity

import com.francis.kotlinmvp.app.BaseView
import com.francis.kotlinmvp.data.response.first.FirstApiResponse

interface SecondApiView : BaseView {
    fun onApiSuccess(response: FirstApiResponse?)
}