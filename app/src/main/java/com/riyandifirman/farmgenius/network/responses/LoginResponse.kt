package com.riyandifirman.farmgenius.network.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("user_id")
    val userId: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("accessToken")
    val accessToken: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("refreshToken")
    val refreshToken: String
)
