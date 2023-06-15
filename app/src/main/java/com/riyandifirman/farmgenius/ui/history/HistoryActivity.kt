package com.riyandifirman.farmgenius.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riyandifirman.farmgenius.R
import com.riyandifirman.farmgenius.adapter.DetectDiseaseHistoryAdapter
import com.riyandifirman.farmgenius.databinding.ActivityHistoryBinding
import com.riyandifirman.farmgenius.network.ApiConfig
import com.riyandifirman.farmgenius.network.responses.GetHistoryResponse
import com.riyandifirman.farmgenius.network.responses.GetHistoryResponseItem
import com.riyandifirman.farmgenius.ui.main.MainActivity
import com.riyandifirman.farmgenius.ui.profile.ProfileSettingActivity
import com.riyandifirman.farmgenius.util.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var backButton: ImageView
    private lateinit var myPreferences: Preferences
    private lateinit var historyResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreferences = Preferences(this)
        setupRecyclerView()

        // Tombol kembali di klik
        backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this@HistoryActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // Activity result launcher
        historyResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                // Refresh activity
            }
        }
    }

    private fun setupRecyclerView() {
        // Mendapatkan data list dari API
        val token = "Bearer " + myPreferences.getUserToken()
        val client = ApiConfig.getApiService().getHistoryDisease(token)
        client.enqueue(object : Callback<List<GetHistoryResponseItem>> {
            override fun onResponse(
                call: Call<List<GetHistoryResponseItem>>,
                response: Response<List<GetHistoryResponseItem>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val detectDiseaseItems = responseBody as List<GetHistoryResponseItem>
                    val sortedList = detectDiseaseItems.sortedByDescending { it.detectionDate }
                    val detectAdapter = DetectDiseaseHistoryAdapter(
                        sortedList,
                        object : DetectDiseaseHistoryAdapter.OnAdapterClickListener {
                            override fun onItemClicked(detectDisease: GetHistoryResponseItem) {
                                val intent = Intent(this@HistoryActivity, HistoryResultDetectionActivity::class.java)
                                intent.putExtra("result_name", detectDisease.detectionResult)
                                intent.putExtra("result_image", detectDisease.imageUrl)
                                intent.putExtra("result_date", detectDisease.detectionDate)
                                historyResultLauncher.launch(intent)
                            }
                        })

                    binding.rvDeteksi.apply {
                        layoutManager = LinearLayoutManager(this@HistoryActivity)
                        adapter = detectAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<GetHistoryResponseItem>>, t: Throwable) {
                Toast.makeText(this@HistoryActivity, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show()
            }

        })
    }
}