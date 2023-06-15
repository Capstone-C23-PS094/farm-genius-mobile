package com.riyandifirman.farmgenius.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.riyandifirman.farmgenius.databinding.ActivitySplashScreenBinding
import com.riyandifirman.farmgenius.ui.login.LoginActivity
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.util.Preferences

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var myPreferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreferences = Preferences(this)

        // cek status login dari preferences
        if (myPreferences.getStatusLogin()) {
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Animasi
        val image = binding.splashScreenIcon
        image.alpha = 0f
        // Durasi animasi
        image.animate().setDuration(2000).alpha(1f).withEndAction {
            // Intent
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // Animasi
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}