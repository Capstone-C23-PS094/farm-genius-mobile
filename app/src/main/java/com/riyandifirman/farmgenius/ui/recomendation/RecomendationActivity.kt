package com.riyandifirman.farmgenius.ui.recomendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileAboutDeveloperActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileSettingActivity

class RecomendationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecomendationBinding
    private lateinit var backButton: ImageView
    private lateinit var temperature: EditText
    private lateinit var humidity: EditText
    private lateinit var ph: EditText
    private lateinit var rainfall: EditText
    private lateinit var nitrogen: EditText
    private lateinit var fosfor: EditText
    private lateinit var kalium: EditText
    private lateinit var recomendationButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binding
        temperature = binding.editTextTemperature
        humidity = binding.editTextHumidity
        ph = binding.editTextPh
        rainfall = binding.editTextRainfall
        nitrogen = binding.editTextNitrogen
        fosfor = binding.editTextFosfor
        kalium = binding.editTextKalium
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

        // listener untuk kolom ph Tanah
        ph.addTextChangedListener(object : TextWatcher {
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

        // listener untuk kolom curah hujan
        rainfall.addTextChangedListener(object : TextWatcher {
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

        // listener untuk kolom nitrogen
        nitrogen.addTextChangedListener(object : TextWatcher {
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

        // listener untuk kolom fosfor
        fosfor.addTextChangedListener(object : TextWatcher {
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

        // listener untuk kolom kalium
        kalium.addTextChangedListener(object : TextWatcher {
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
        val recomendationResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                // TODO: Tambahkan proses untuk menerima data dari RecomendationResultActivity
            }
        }
        recomendationButton.setOnClickListener {
            val intent = Intent(this@RecomendationActivity, RecomendationResultActivity::class.java)
            recomendationResultLauncher.launch(intent)
        }
    }

    // fungsi untuk mengatur button register
    private fun setMyButtonEnable() {
        val temperature = temperature.text
        val humidity = humidity.text
        val area = ph.text
        val rainfall = rainfall.text
        val nitrogen = nitrogen.text
        val fosfor = fosfor.text
        val kalium = kalium.text
        recomendationButton.isEnabled = (temperature != null && temperature.toString()
            .isNotEmpty()) && (humidity != null && humidity.toString()
            .isNotEmpty()) && (area != null && area.toString().isNotEmpty()) && (rainfall != null && rainfall.toString().isNotEmpty()) && (nitrogen != null && nitrogen.toString().isNotEmpty()) && (fosfor != null && fosfor.toString().isNotEmpty()) && (kalium != null && kalium.toString().isNotEmpty())
    }
}