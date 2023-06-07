package com.riyandifirman.farmgenius.network.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("accessToken")
	val accessToken: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("refreshToken")
	val refreshToken: String
)
