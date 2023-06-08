package com.riyandifirman.farmgenius.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityMainBinding
import com.riyandifirman.farmgenius.network.responses.Data
import com.riyandifirman.farmgenius.network.responses.LoginResponse
import com.riyandifirman.farmgenius.network.responses.RegisterResponse
import com.riyandifirman.farmgenius.ui.detection.DetectionActivity
import com.riyandifirman.farmgenius.ui.history.HistoryActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileActivity
import com.riyandifirman.farmgenius.ui.recomendation.RecomendationActivity
import com.riyandifirman.farmgenius.util.Preferences
import com.riyandifirman.farmgenius.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var helloName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("CEK_DATA", "")

        helloName = binding.helloUser

        // Inisialisasi ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.init(this)

        viewModel.name.observe(this) { name ->
             helloName.text = "Halo, $name!"
        }

        // Set button listener
        val profileButton = binding.rectangleProfile
        profileButton.setOnClickListener{
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val recomendationButton = binding.cariButton
        recomendationButton.setOnClickListener{
            val intent = Intent(this@MainActivity, RecomendationActivity::class.java)
            startActivity(intent)
        }

        val historyButton = binding.lihatLebih
        historyButton.setOnClickListener{
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        val detectionButton = binding.fab
        detectionButton.setOnClickListener{
            val intent = Intent(this@MainActivity, DetectionActivity::class.java)
            startActivity(intent)
        }
    }

    // Exit app when back button pressed
    override fun onBackPressed() {
        finishAffinity()
    }
}