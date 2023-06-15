package com.riyandifirman.farmgenius.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.lifecycle.ViewModel
import com.riyandifirman.farmgenius.network.ApiConfig
import com.riyandifirman.farmgenius.network.responses.LoginResponse
import com.riyandifirman.farmgenius.ui.login.LoginActivity
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.util.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private lateinit var myPreferences: Preferences

    fun init(context: Context) {
        myPreferences = Preferences(context)

        if (myPreferences.getStatusLogin()) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            finishAffinity(context as LoginActivity)
        }
    }

    fun login(context: Context, email: String, password: String) {

        val client = ApiConfig.getApiService().loginUser(email, password)

        client.enqueue(object : Callback<LoginResponse> {
            // Jika berhasil
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val body = response.body()
                if (body != null) {
                    myPreferences.saveUserToken(body.accessToken)
                    myPreferences.setStatusLogin(true)
                    myPreferences.saveUserData(body.userId, body.name, body.email)
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                    finishAffinity(context as LoginActivity)
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }

            // Jika gagal
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
}