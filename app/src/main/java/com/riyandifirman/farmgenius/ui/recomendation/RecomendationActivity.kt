package com.riyandifirman.farmgenius.ui.recomendation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityRecomendationBinding
import com.riyandifirman.farmgenius.network.ApiConfig
import com.riyandifirman.farmgenius.network.responses.RecomendationResponse
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileAboutDeveloperActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileSettingActivity
import com.riyandifirman.farmgenius.viewmodel.ProfileViewModel
import com.riyandifirman.farmgenius.viewmodel.RegisterViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        recomendationButton.setOnClickListener {
            showRecomendation(
                nitrogen.text.toString().toInt(),
                fosfor.text.toString().toInt(),
                kalium.text.toString().toInt(),
                temperature.text.toString().toInt(),
                humidity.text.toString().toInt(),
                ph.text.toString().toInt(),
                rainfall.text.toString().toInt()
            )
        }

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

    // fungsi untuk menampilkan hasil rekomendasi
    private fun showRecomendation(nitrogen: Int, phosphorous: Int, potassium: Int, temperature: Int, humidity: Int, ph: Int, rainfall: Int) {
        val client = ApiConfig.getApiServiceRecomendation().getRecomendation(nitrogen, phosphorous, potassium, temperature, humidity, ph, rainfall)

        client.enqueue(object : Callback<RecomendationResponse> {
            override fun onResponse(
                call: Call<RecomendationResponse>,
                response: Response<RecomendationResponse>
            ) {
                if (response.isSuccessful) {
                    val recomendationResponse = response.body()
                    val recomendation = recomendationResponse
                    val intent = Intent(this@RecomendationActivity, RecomendationResultActivity::class.java)
                    if (recomendation != null) {
                        intent.putExtra("name", recomendation.name)
                        intent.putExtra("url", recomendation.url)
                        intent.putExtra("nitrogen", nitrogen.toString())
                        intent.putExtra("phosphorous", phosphorous.toString())
                        intent.putExtra("potassium", potassium.toString())
                        intent.putExtra("temperature", temperature.toString())
                        intent.putExtra("humidity", humidity.toString())
                        intent.putExtra("ph", ph.toString())
                        intent.putExtra("rainfall", rainfall.toString())
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@RecomendationActivity, "Gagal mendapatkan rekomendasi karena ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RecomendationResponse>, t: Throwable) {
                Toast.makeText(this@RecomendationActivity, "Gagal mendapatkan rekomendasi", Toast.LENGTH_SHORT).show()
            }
        })
    }
}