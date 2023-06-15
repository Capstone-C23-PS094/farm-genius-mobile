package com.riyandifirman.farmgenius.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.riyandifirman.farmgenius.network.ApiConfig
import com.riyandifirman.farmgenius.network.responses.RegisterResponse
import com.riyandifirman.farmgenius.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    fun register(context: Context, name: String, email: String, password: String) {
        val token =
            "Bearer " + "JpZCI6Il9JOFJDN3U0enFONEk3OUsiLCJlbWFpbCI6Imh1c2FkYUBnbWFpbC5jb20iLCJpYXQiOjE2ODU4NzcxMTUsImV4cCI6MTY4NTg4MDcxNX0.IaZJBH1B00ZXatE060aVZVEXUwtMiZEGM06sy-U8kOM"
        val client = ApiConfig.getApiService().registerUser(token, name, email, password)

        client.enqueue(object : Callback<RegisterResponse> {

            // Jika berhasil
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
                        val intent = Intent(context, LoginActivity::class.java)
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            // Jika gagal
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}