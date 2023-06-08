package com.riyandifirman.farmgenius.viewmodel

import android.content.Context
import android.content.Intent
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riyandifirman.farmgenius.network.responses.Data
import com.riyandifirman.farmgenius.network.responses.LoginResponse
import com.riyandifirman.farmgenius.network.responses.RegisterResponse
import com.riyandifirman.farmgenius.ui.login.LoginActivity
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.util.Preferences

class MainViewModel : ViewModel() {

    private lateinit var myPreferences : Preferences

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _id = MutableLiveData<String>()
    val id: LiveData<String> get() = _id

    fun init(context: Context) {
        myPreferences = Preferences(context)

        _id.value = myPreferences.getUserId()
        _name.value = myPreferences.getUserName()
        _email.value = myPreferences.getUserEmail()
    }
}