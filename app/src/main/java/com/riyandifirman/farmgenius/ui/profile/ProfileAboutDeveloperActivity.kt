package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityProfileAboutDeveloperBinding

class ProfileAboutDeveloperActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileAboutDeveloperBinding
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileAboutDeveloperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@ProfileAboutDeveloperActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}