package com.example.liked_screen.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.liked_screen.domain.model.PhoneBookmark

class BookmarkDiffCallback : DiffUtil.ItemCallback<PhoneBookmark>() {

    override fun areItemsTheSame(oldItem: PhoneBookmark, newItem: PhoneBookmark): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhoneBookmark, newItem: PhoneBookmark): Boolean {
        return oldItem == newItem
    }
}