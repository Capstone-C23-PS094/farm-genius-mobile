package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.riyandifirman.farmgenius.databinding.ActivityProfileHelpCentreBinding

class ProfileHelpCentreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileHelpCentreBinding
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileHelpCentreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = binding.backButton

        // Ketika tombol back di klik
        backButton.setOnClickListener {
            val resultIntent = Intent()
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}