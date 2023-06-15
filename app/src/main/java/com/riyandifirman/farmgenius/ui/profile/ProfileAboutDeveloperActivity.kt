package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
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
            val resultIntent = Intent()
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}