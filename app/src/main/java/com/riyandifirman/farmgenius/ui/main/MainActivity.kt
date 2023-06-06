package com.riyandifirman.farmgenius.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityMainBinding
import com.riyandifirman.farmgenius.ui.detection.DetectionActivity
import com.riyandifirman.farmgenius.ui.history.HistoryActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileActivity
import com.riyandifirman.farmgenius.ui.recomendation.RecomendationActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileButton = binding.rectangleProfile
        profileButton.setOnClickListener{
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val recomendationButton = binding.cariButton
        recomendationButton.setOnClickListener{
            val intent = Intent(this@MainActivity, RecomendationActivity::class.java)
            startActivity(intent)
        }

        val historyButton = binding.lihatLebih
        historyButton.setOnClickListener{
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        val detectionButton = binding.fab
        detectionButton.setOnClickListener{
            val intent = Intent(this@MainActivity, DetectionActivity::class.java)
            startActivity(intent)
        }
    }

    // Exit app when back button pressed
    override fun onBackPressed() {
        finishAffinity()
    }
}