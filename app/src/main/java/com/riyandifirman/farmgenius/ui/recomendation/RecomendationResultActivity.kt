package com.riyandifirman.farmgenius.ui.recomendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationBinding
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationResultBinding

class RecomendationResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecomendationResultBinding
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendationResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = binding.backButton
        backButton.setOnClickListener {
            val resultIntent = Intent()
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}