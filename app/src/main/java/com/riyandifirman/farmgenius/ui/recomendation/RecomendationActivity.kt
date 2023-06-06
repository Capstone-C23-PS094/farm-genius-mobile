package com.riyandifirman.farmgenius.ui.recomendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileAboutDeveloperActivity

class RecomendationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecomendationBinding
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali di klik
        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@RecomendationActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val recomendationButton = binding.recomendationButton
        recomendationButton.setOnClickListener {
            val intent = Intent(this@RecomendationActivity, RecomendationResultActivity::class.java)
            startActivity(intent)
        }
    }
}