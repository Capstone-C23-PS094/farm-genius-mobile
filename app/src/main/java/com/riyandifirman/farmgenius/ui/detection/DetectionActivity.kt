package com.riyandifirman.farmgenius.ui.detection

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.databinding.ActivityDetectionBinding
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.util.uriToFile
import com.riyandifirman.farmgenius.viewmodel.MainViewModel
import java.io.File

class DetectionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetectionBinding
    private lateinit var backButton : ImageView
    private lateinit var currentPhotoPath: String
    private var getFile: File? = null

    // fungsi untuk menangani hasil dari request permission
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(this, "Tidak mendapatkan izin!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // fungsi untuk memeriksa apakah semua permission sudah diberikan
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memeriksa apakah semua permission sudah diberikan
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        backButton = binding.backButton
        val galleryButton = binding.galleryButton
        val camera = binding.cameraButton

        // Tombol kembali di klik
        backButton.setOnClickListener {
            val intent = Intent(this@DetectionActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // Tombol galeri di klik
        galleryButton.setOnClickListener {
            openGallery()
        }

        // Tombol kamera di klik
        camera.setOnClickListener {
//            openCamera()
        }

        // Tombol deteksi di klik
        val detectButton = binding.detectionButton
        detectButton.setOnClickListener {
//            detect()
        }
    }

    // fungsi untuk menangani hasil dari pemilihan gambar dari galeri
    private val launcherIntentGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = uriToFile(selectedImg, this)
            getFile = myFile

            binding.ivResultImage.setImageURI(selectedImg)
        }
    }

    // fungsi untuk membuka galeri dan memilih gambar
    private fun openGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Pilih gambar")
        launcherIntentGallery.launch(chooser)
    }

    // companion object untuk menyimpan properti dan konstanta yang digunakan di activity ini
    companion object {
        const val CAMERA_X_RESULT = 200

        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}