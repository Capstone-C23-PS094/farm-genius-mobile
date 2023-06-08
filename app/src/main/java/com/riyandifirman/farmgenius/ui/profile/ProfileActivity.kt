 package com.riyandifirman.farmgenius.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityProfileBinding
import com.riyandifirman.farmgenius.ui.login.LoginActivity
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.ui.register.RegisterActivity
import com.riyandifirman.farmgenius.util.Preferences
import com.riyandifirman.farmgenius.viewmodel.MainViewModel
import com.riyandifirman.farmgenius.viewmodel.ProfileViewModel

 class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var backButton: ImageView
    private lateinit var settingProfile: View
    private lateinit var helpCentre: View
    private lateinit var termsConditions: View
    private lateinit var privacyPolicy: View
    private lateinit var aboutDeveloper: View
    private lateinit var logout: View
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView
    private lateinit var myPreferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreferences = Preferences(this)
        userName = binding.tvNama
        userEmail = binding.tvEmail
        settingProfile = binding.lihatLebihProfil
        helpCentre = binding.lihatLebihBantuan
        termsConditions = binding.lihatLebihSk
        privacyPolicy = binding.lihatLebihPrivasi
        aboutDeveloper = binding.lihatLebihPengembang
        logout = binding.lihatLebihKeluar

        // Inisialisasi ViewModel
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.init(this)

        viewModel.name.observe(this) { name ->
            userName.text = name
        }

        viewModel.email.observe(this) { email ->
            userEmail.text = email
        }

        // Tombol kembali di klik
        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(intent)
        }

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

        logout.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            with(alertDialogBuilder) {
                setTitle("Keluar")
                setMessage("Apakah anda yakin ingin keluar?")
                setPositiveButton("Ya") { dialog, which ->
                    myPreferences.clearUserToken()
                    myPreferences.clearUserLogin()
                    myPreferences.clearUserData()
                    myPreferences.setStatusLogin(false)
                    val intent = Intent(this@ProfileActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
                setNegativeButton("Tidak") { dialog, which ->
                    dialog.cancel()
                }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }
    }
}