package com.riyandifirman.farmgenius.ui.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}