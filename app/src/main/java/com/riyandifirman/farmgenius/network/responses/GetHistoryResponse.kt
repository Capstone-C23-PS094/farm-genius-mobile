package com.riyandifirman.farmgenius.network.responses

import com.google.gson.annotations.SerializedName

data class GetHistoryResponse(

    @field:SerializedName("GetHistoryResponse")
    val getHistoryResponse: List<GetHistoryResponseItem>
)

data class GetHistoryResponseItem(

    @field:SerializedName("fileName")
    val fileName: String,

    @field:SerializedName("detectionResult")
    val detectionResult: String,

    @field:SerializedName("detectionDate")
    val detectionDate: String,

    @field:SerializedName("imageUrl")
    val imageUrl: String,

    @field:SerializedName("detection_id")
    val detectionId: Int
)
