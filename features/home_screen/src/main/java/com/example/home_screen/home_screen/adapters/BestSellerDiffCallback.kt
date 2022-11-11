package com.example.home_screen.home_screen.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.common.models.BestSeller

class BestSellerDiffCallback : DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}