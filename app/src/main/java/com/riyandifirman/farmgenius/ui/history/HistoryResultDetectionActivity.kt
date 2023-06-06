package com.riyandifirman.farmgenius.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityHistoryResultDetectionBinding

class HistoryResultDetectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryResultDetectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryResultDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val seeTreatment = binding.lihatButton
        seeTreatment.setOnClickListener {
            val intent = Intent(this@HistoryResultDetectionActivity, HistoryTreatmentActivity::class.java)
            startActivity(intent)
        }
    }
}