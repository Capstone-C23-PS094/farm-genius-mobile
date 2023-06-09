package com.riyandifirman.farmgenius.ui.recomendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileAboutDeveloperActivity

class RecomendationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecomendationBinding
    private lateinit var backButton: ImageView
    private lateinit var temperature: EditText
    private lateinit var humidity: EditText
    private lateinit var area: EditText
    private lateinit var recomendationButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binding
        temperature = binding.editTextTemperature
        humidity = binding.editTextHumidity
        area = binding.editTextHectare
        recomendationButton = binding.recomendationButton

        setMyButtonEnable()

        // listener untuk kolom suhu
        temperature.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        // listener untuk kolom kelembapan
        humidity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        // listener untuk kolom area
        area.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        // Tombol kembali di klik
        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@RecomendationActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val recomendationButton = binding.recomendationButton
        recomendationButton.setOnClickListener {
            val intent = Intent(this@RecomendationActivity, RecomendationResultActivity::class.java)
            startActivity(intent)
        }
    }

    // fungsi untuk mengatur button register
    private fun setMyButtonEnable() {
        val temperature = temperature.text
        val humidity = humidity.text
        val area = area.text
        recomendationButton.isEnabled = (temperature != null && temperature.toString()
            .isNotEmpty()) && (humidity != null && humidity.toString()
            .isNotEmpty()) && (area != null && area.toString().isNotEmpty())
    }
}