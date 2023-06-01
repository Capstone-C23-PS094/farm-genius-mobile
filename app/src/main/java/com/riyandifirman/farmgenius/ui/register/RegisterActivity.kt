package com.riyandifirman.farmgenius.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRegisterBinding
import com.riyandifirman.farmgenius.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var loginHere : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginHere = binding.loginDisini
        loginHere.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}