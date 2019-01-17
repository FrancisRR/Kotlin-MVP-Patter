package com.francis.kotlinmvp.ui.firstapiactivity

import com.francis.kotlinmvp.app.BaseView
import com.francis.kotlinmvp.data.response.CompainRes
import com.francis.kotlinmvp.data.response.postdetails.PostDetailsResponse

interface FirstApiView : BaseView {
    fun onApiSuccess(response: PostDetailsResponse?)
    fun onZipResponseSuccess(response: CompainRes?)
}