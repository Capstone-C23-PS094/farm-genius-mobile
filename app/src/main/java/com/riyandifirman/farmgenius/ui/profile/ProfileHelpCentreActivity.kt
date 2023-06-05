package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityProfileHelpCentreBinding
import com.riyandifirman.farmgenius.databinding.ActivityProfileSettingBinding

class ProfileHelpCentreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileHelpCentreBinding
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileHelpCentreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = binding.backButton

        // Ketika tombol back di klik
        backButton.setOnClickListener {
            val intent = Intent(this@ProfileHelpCentreActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}