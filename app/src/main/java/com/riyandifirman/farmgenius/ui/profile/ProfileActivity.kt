 package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityProfileBinding
import com.riyandifirman.farmgenius.ui.register.RegisterActivity

 class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var settingProfile: View
    private lateinit var helpCentre: View
    private lateinit var termsConditions: View
    private lateinit var privacyPolicy: View
    private lateinit var aboutDeveloper: View
    private lateinit var logout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingProfile = binding.lihatLebihProfil
        helpCentre = binding.lihatLebihBantuan
        termsConditions = binding.lihatLebihSk
        privacyPolicy = binding.lihatLebihPrivasi
        aboutDeveloper = binding.lihatLebihPengembang
        logout = binding.lihatLebihKeluar

        // Tombol > di klik
        settingProfile.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ProfileSettingActivity::class.java)
            startActivity(intent)
        }

        helpCentre.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ProfileHelpCentreActivity::class.java)
            startActivity(intent)
        }

        termsConditions.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ProfileTermsConditionsActivity::class.java)
            startActivity(intent)
        }

        privacyPolicy.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ProfilePrivacyPolicyActivity::class.java)
            startActivity(intent)
        }

        aboutDeveloper.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ProfileAboutDeveloperActivity::class.java)
            startActivity(intent)
        }
//
//        logout.setOnClickListener {
//            val intent = Intent(this@ProfileActivity, ProfileLogoutActivity::class.java)
//            startActivity(intent)
//        }
    }

     override fun onBackPressed() {
         finishAffinity()
     }
}