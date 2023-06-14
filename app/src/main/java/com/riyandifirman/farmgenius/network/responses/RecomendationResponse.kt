package com.riyandifirman.farmgenius.network.responses

import com.google.gson.annotations.SerializedName

data class RecomendationResponse(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
