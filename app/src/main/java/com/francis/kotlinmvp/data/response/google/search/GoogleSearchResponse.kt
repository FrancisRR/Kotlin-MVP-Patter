package com.francis.kotlinmvp.data.response.google.search

import com.google.gson.annotations.SerializedName

data class GoogleSearchResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)