package com.riyandifirman.farmgenius.network

import com.riyandifirman.farmgenius.network.responses.LoginResponse
import com.riyandifirman.farmgenius.network.responses.RecomendationResponse
import com.riyandifirman.farmgenius.network.responses.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    // fungsi untuk mengirimkan data saat register
    @POST("register")
    @FormUrlEncoded
    fun registerUser(
        @Header("Authorization") Bearer: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    // fungsi untuk mengirimkan data saat login
    @POST("login")
    @FormUrlEncoded
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    // fungsi untuk mengirimkan data recomendation
    @POST("crop-recommendations")
    @FormUrlEncoded
    fun getRecomendation(
        @Field("nitrogen") nitrogen: Int,
        @Field("phosphorous") phosphorous: Int,
        @Field("potassium") potassium: Int,
        @Field("temperature") temperature: Int,
        @Field("humidity") humidity: Int,
        @Field("ph") ph: Int,
        @Field("rainfall") rainfall: Int
    ): Call<RecomendationResponse>
}