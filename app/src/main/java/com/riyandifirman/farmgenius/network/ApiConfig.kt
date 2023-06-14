package com.riyandifirman.farmgenius.network

import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            // membuat interceptor
            val authInterceptor = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }

            // membuat client baru dengan interceptor yang sudah dibuat
            val client = OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build()

            // membuat retrofit baru dengan client yang sudah dibuat dan base url farm genius api
            val retrofit = Retrofit.Builder()
                .baseUrl("https://farm-genius.et.r.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }

        fun getApiServiceRecomendation(): ApiService {
            // membuat interceptor
            val authInterceptor = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }

            // membuat client baru dengan interceptor yang sudah dibuat
            val client = OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build()

            // membuat retrofit baru dengan client yang sudah dibuat dan base url recomendation api
            val retrofit = Retrofit.Builder()
                .baseUrl("https://model-api-z26hwrcy4q-uc.a.run.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}