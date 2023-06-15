package com.riyandifirman.farmgenius.ui.detection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.riyandifirman.farmgenius.databinding.ActivityDetectionResultBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity

class DetectionResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetectionResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultTitle = binding.tvResultTitle
        val resultImage = binding.ivResultImage
        val resultTreatment = binding.tvResultTreatment
        val resultPercentage = binding.tvResultPercentage

        val intent = intent
        val diseaseName = intent.getStringExtra("disease_name")
        val diseasePercentage = intent.getStringExtra("disease_percentage")

        // Mengubah format percentage dari 0.123456 menjadi 12%
        val diseasePercentageDouble = diseasePercentage
        val diseasePercentageInt = (diseasePercentageDouble!!.toDouble() * 100).toInt()
        val diseasePercentageFix = diseasePercentageInt.toString()

        val diseaseSolution = intent.getStringExtra("disease_solution")
        val diseaseImage = intent.getStringExtra("url_image")

        resultTitle.text = "Terindikasi terkena " + diseaseName
        resultPercentage.text = diseasePercentageFix + "%"
        resultTreatment.text = diseaseSolution
        Glide.with(this)
            .load(diseaseImage)
            .into(resultImage)

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