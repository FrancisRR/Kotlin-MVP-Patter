package com.francis.kotlinmvp.data.response.first

import com.google.gson.annotations.SerializedName

data class FirstApiItem(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("pantone_value")
	val pantoneValue: String? = null
)