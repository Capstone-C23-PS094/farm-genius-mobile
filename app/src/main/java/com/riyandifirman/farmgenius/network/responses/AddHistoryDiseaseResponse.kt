package com.riyandifirman.farmgenius.network.responses

import com.google.gson.annotations.SerializedName

data class AddHistoryDiseaseResponse(

	@field:SerializedName("resultDetection")
	val resultDetection: String,

	@field:SerializedName("imageUrl")
	val imageUrl: String,

	@field:SerializedName("detectionId")
	val detectionId: Int
)
