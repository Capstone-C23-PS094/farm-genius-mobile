package com.riyandifirman.farmgenius.ui.detection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityDetectionBinding
import com.riyandifirman.farmgenius.databinding.ActivityDetectionResultBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity

class DetectionResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetectionResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val treatmentButton = binding.treatmentButton
        treatmentButton.setOnClickListener {
            val intent = Intent(this@DetectionResultActivity, DetectionTreatmentActivity::class.java)
            startActivity(intent)
        }

        val homeButton = binding.homeButton
        homeButton.setOnClickListener {
            val intent = Intent(this@DetectionResultActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@DetectionResultActivity, MainActivity::class.java)
        startActivity(intent)
    }
}