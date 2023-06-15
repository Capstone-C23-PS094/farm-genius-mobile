package com.riyandifirman.farmgenius.network.responses

import com.google.gson.annotations.SerializedName

data class DiseaseDetectResponse(

	@field:SerializedName("image_url")
	val imageUrl: String,

	@field:SerializedName("predictions")
	val predictions: List<PredictionsItem>
)

data class PredictionsItem(

	@field:SerializedName("disease")
	val disease: Disease,

	@field:SerializedName("percentage")
	val percentage: Any
)

data class Disease(

	@field:SerializedName("solutions")
	val solutions: String,

	@field:SerializedName("name")
	val name: String
)
