package com.riyandifirman.farmgenius.ui.detection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityDetectionBinding

class DetectionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detectButton = binding.detectionButton
        detectButton.setOnClickListener {
            val intent = Intent(this@DetectionActivity, DetectionResultActivity::class.java)
            startActivity(intent)
        }
    }
}