package com.riyandifirman.farmgenius.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRegisterBinding
import com.riyandifirman.farmgenius.ui.login.LoginActivity
import com.riyandifirman.farmgenius.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var loginHere : TextView
    private lateinit var registerButton : AppCompatButton
    private lateinit var name : EditText
    private lateinit var email : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binding
        name = binding.editTextNama
        email = binding.editTextEmail
        password = binding.editTextPassword
        registerButton = binding.registerButton

        // Inisialisasi ViewModel
        val viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // Ketika tombol register diklik
        registerButton.setOnClickListener {
            viewModel.register (
                this@RegisterActivity,
                name.text.toString(),
                email.text.toString(),
                password.text.toString())
        }

        // Navigasi ke halaman login
        loginHere = binding.loginDisini
        loginHere.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        setMyButtonEnable()

        // listener untuk kolom email
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        // listener untuk kolom nama
        name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        // listener untuk kolom password
        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s != null && s.length >= 8) setMyButtonEnable() else registerButton.isEnabled =
                    false
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })
    }

    // fungsi untuk mengatur button register
    private fun setMyButtonEnable() {
        val name = name.text
        val email = email.text
        val password = password.text
        registerButton.isEnabled = (email != null && email.toString()
            .isNotEmpty()) && (password != null && password.toString()
            .isNotEmpty()) && (name != null && name.toString().isNotEmpty())
    }
}