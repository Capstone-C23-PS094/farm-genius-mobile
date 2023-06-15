package com.riyandifirman.farmgenius.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riyandifirman.farmgenius.databinding.CardDetectionMainBinding
import com.riyandifirman.farmgenius.network.responses.GetHistoryResponseItem
import java.text.SimpleDateFormat
import java.util.*

class DetectDiseaseHistoryAdapter(
    private val detectDiseaseList: List<GetHistoryResponseItem>,
    private val listener: OnAdapterClickListener
) :
    RecyclerView.Adapter<DetectDiseaseHistoryAdapter.ViewHolder>() {

    // inner class ViewHolder
    class ViewHolder(private val binding: CardDetectionMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detectDisease: GetHistoryResponseItem) {
            // fungsi untuk mengubah format tanggal
            val dateString = detectDisease.detectionDate
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val date = inputFormat.parse(dateString)
            val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val formattedDate = outputFormat.format(date)

            binding.apply {
                tvItemTitle.text = detectDisease.detectionResult
                tvItemDate.text = formattedDate
                Glide.with(itemView.context)
                    .load(detectDisease.imageUrl)
                    .into(ivItemPhoto)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardDetectionMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return detectDiseaseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detectDisease = detectDiseaseList[position]
        holder.bind(detectDisease)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(detectDisease)
        }
    }

    // interface untuk listener
    interface OnAdapterClickListener {
        fun onItemClicked(detectDisease: GetHistoryResponseItem)
    }
}