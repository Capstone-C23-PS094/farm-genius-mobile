package com.riyandifirman.farmgenius.util

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    val login = "login"
    val myPref = "myPref"
    val myToken = "Bearer"
    val myPreferences: SharedPreferences

    init {
        myPreferences = context.getSharedPreferences(myPref, Context.MODE_PRIVATE)
    }

    // Fungsi untuk menyimpan data login
    fun setStatusLogin(status: Boolean) {
        myPreferences.edit().putBoolean(login, status).apply()
    }

    // Fungsi untuk mendapatkan data login
    fun getStatusLogin(): Boolean {
        return myPreferences.getBoolean(login, false)
    }

    // Fungsi untuk menyimpan data token
    fun saveUserToken(token: String) {
        myPreferences.edit().putString(myToken, token).apply()
    }

    // Fungsi untuk mendapatkan data token
    fun getUserToken(): String? {
        return myPreferences.getString(myToken, " ")
    }

    // fungsi untuk menghapus data token
    fun clearUserToken() {
        myPreferences.edit().remove(myToken).apply()
    }

    // fungsi untuk menghapus data login
    fun clearUserLogin() {
        myPreferences.edit().remove(login).apply()
    }
}