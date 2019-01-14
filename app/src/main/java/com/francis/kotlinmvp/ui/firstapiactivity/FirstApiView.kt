package com.francis.kotlinmvp.ui.firstapiactivity

import com.francis.kotlinmvp.app.BaseView
import com.francis.kotlinmvp.data.response.CompainRes
import com.francis.kotlinmvp.data.response.google.search.GoogleSearchResponse

interface FirstApiView : BaseView {
    fun onApiSuccess(response: GoogleSearchResponse?)
    fun onZipResponseSuccess(response: CompainRes?)
}