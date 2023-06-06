package com.riyandifirman.farmgenius.ui.detection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityDetectionBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity

class DetectionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetectionBinding
    private lateinit var backButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali di klik
        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@DetectionActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val detectButton = binding.detectionButton
        detectButton.setOnClickListener {
            val intent = Intent(this@DetectionActivity, DetectionResultActivity::class.java)
            startActivity(intent)
        }
    }
}