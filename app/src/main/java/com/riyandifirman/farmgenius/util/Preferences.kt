package com.riyandifirman.farmgenius.util

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    val login = "login"
    val myPref = "myPref"
    val myToken = "userToken"
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

    // fungsi untuk menyimpan semua data user
    fun saveUserData(userId: String, userName: String, userEmail: String) {
        myPreferences.edit().putString("userId", userId).apply()
        myPreferences.edit().putString("userName", userName).apply()
        myPreferences.edit().putString("userEmail", userEmail).apply()
    }

    // fungsi untuk menghapus semua data user
    fun clearUserData() {
        myPreferences.edit().remove("userId").apply()
        myPreferences.edit().remove("userName").apply()
        myPreferences.edit().remove("userEmail").apply()
    }

    // fungsi untuk mendapatkan data user id
    fun getUserId(): String? {
        return myPreferences.getString("userId", " ")
    }

    // fungsi untuk mendapatkan data user name
    fun getUserName(): String? {
        return myPreferences.getString("userName", " ")
    }

    // fungsi untuk mendapatkan data user email
    fun getUserEmail(): String? {
        return myPreferences.getString("userEmail", " ")
    }
}