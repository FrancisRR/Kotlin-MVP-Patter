package com.francis.kotlinmvp.data.response

import com.francis.kotlinmvp.data.response.google.autocomplete.AutoCompleteResponse
import com.francis.kotlinmvp.data.response.google.search.GoogleSearchResponse

class CompainRes {

    var autoCompleResponse: AutoCompleteResponse? = null
    var searchResponse: GoogleSearchResponse? = null
}