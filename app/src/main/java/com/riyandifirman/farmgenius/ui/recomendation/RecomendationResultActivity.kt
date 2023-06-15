package com.riyandifirman.farmgenius.ui.recomendation

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationResultBinding

class RecomendationResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecomendationResultBinding
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendationResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menerima data intent dari RecomendationActivity
        val intent = intent
        val name = intent.getStringExtra("name")
        val url = intent.getStringExtra("url")
        val nitrogen = intent.getStringExtra("nitrogen")
        val fosfor = intent.getStringExtra("phosphorous")
        val kalium = intent.getStringExtra("potassium")
        val ph = intent.getStringExtra("ph")
        val temperature = intent.getStringExtra("temperature")
        val humidity = intent.getStringExtra("humidity")
        val rainfall = intent.getStringExtra("rainfall")

        val resultTemperature = binding.resultTemperature
        val resultHumidity = binding.resultHumidity
        val resultPh = binding.resultPh
        val resultRainfall = binding.resultRainfall
        val resultNitrogen = binding.resultNitrogen
        val resultFosfor = binding.resultFosfor
        val resultKalium = binding.resultKalium
        val resultName = binding.tvPlantName
        val resultUrl = binding.ivResultRecomendation

        resultTemperature.text = temperature + " °C"
        resultHumidity.text = humidity + " %"
        resultPh.text = ph + " pH"
        resultRainfall.text = rainfall + " mm"
        resultNitrogen.text = nitrogen + " ppm"
        resultFosfor.text = fosfor + " ppm"
        resultKalium.text = kalium + " ppm"
        resultName.text = name

        Glide.with(this)
            .load(url)
            .into(resultUrl)

        backButton = binding.backButton
        backButton.setOnClickListener {
//            val intent = Intent(this, RecomendationActivity::class.java)
//            startActivity(intent)
            val resultIntent = Intent()
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}