package com.example.liked_screen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.common.models.likedModel.PhoneBookmark

class BookmarkDiffCallback : DiffUtil.ItemCallback<PhoneBookmark>() {

    override fun areItemsTheSame(oldItem: PhoneBookmark, newItem: PhoneBookmark): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhoneBookmark, newItem: PhoneBookmark): Boolean {
        return oldItem == newItem
    }
}