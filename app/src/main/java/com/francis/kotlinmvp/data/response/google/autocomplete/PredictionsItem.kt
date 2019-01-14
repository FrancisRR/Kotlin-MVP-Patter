package com.francis.kotlinmvp.data.response.google.autocomplete

import com.google.gson.annotations.SerializedName

data class PredictionsItem(

	@field:SerializedName("description")
	val description: String? = null
)