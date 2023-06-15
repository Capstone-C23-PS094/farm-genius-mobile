package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.databinding.ActivityProfileSettingBinding
import com.riyandifirman.farmgenius.viewmodel.ProfileSettingViewModel

class ProfileSettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileSettingBinding
    private lateinit var backButton: ImageView
    private lateinit var viewModel: ProfileSettingViewModel
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = binding.backButton
        userName = binding.editTextNama
        userEmail = binding.editTextEmail

        // Inisialisasi ViewModel
        viewModel = ViewModelProvider(this).get(ProfileSettingViewModel::class.java)
        viewModel.init(this)

        viewModel.name.observe(this) { name ->
            userName.text = name
        }

        viewModel.email.observe(this) { email ->
            userEmail.text = email
        }

        // Ketika tombol back di klik
        backButton.setOnClickListener {
            val resultIntent = Intent()
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}