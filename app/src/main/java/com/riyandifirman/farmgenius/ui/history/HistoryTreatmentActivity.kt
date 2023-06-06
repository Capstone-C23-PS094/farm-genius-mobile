package com.riyandifirman.farmgenius.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityHistoryTreatmentBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity

class HistoryTreatmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHistoryTreatmentBinding
    private lateinit var backButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryTreatmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@HistoryTreatmentActivity, HistoryResultDetectionActivity::class.java)
            startActivity(intent)
        }

        val homepageButton = binding.homepageButton
        homepageButton.setOnClickListener {
            val intent = Intent(this@HistoryTreatmentActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}