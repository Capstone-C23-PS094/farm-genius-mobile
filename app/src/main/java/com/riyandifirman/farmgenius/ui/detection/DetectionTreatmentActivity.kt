package com.riyandifirman.farmgenius.ui.detection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityDetectionTreatmentBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity

class DetectionTreatmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetectionTreatmentBinding
    private lateinit var backButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionTreatmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeButton = binding.homepageButton
        homeButton.setOnClickListener {
            val intent = Intent(this@DetectionTreatmentActivity, MainActivity::class.java)
            startActivity(intent)
        }

        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@DetectionTreatmentActivity, DetectionResultActivity::class.java)
            startActivity(intent)
        }
    }
}