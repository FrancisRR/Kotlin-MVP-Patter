package com.francis.kotlinmvp.data.response.google.search

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("formatted_address")
	val formattedAddress: String? = null,

	@field:SerializedName("place_id")
	val placeId: String? = null
)