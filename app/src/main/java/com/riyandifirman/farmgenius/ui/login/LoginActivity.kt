package com.riyandifirman.farmgenius.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.databinding.ActivityLoginBinding
import com.riyandifirman.farmgenius.ui.register.RegisterActivity
import com.riyandifirman.farmgenius.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var registerHere: TextView
    private lateinit var loginButton: AppCompatButton
    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binding
        email = binding.editTextEmail
        password = binding.editTextPassword
        loginButton = binding.loginButton

        // Inisialisasi ViewModel
        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.init(this@LoginActivity)

        // Ketika tombol login diklik
        loginButton.setOnClickListener {
            viewModel.login(
                this@LoginActivity,
                email.text.toString(),
                password.text.toString()
            )
        }

        // Navigasi ke halaman register
        registerHere = binding.daftarDisini
        registerHere.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
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

        // listener untuk kolom password
        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s != null && s.length >= 8) setMyButtonEnable() else loginButton.isEnabled =
                    false
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })
    }

    private fun setMyButtonEnable() {
        val email = email.text
        val password = password.text
        loginButton.isEnabled = (email != null && email.toString()
            .isNotEmpty()) && (password != null && password.toString()
            .isNotEmpty())
    }
}