package com.example.liked_screen.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.common.constants.extensions.setImageDrawableFromUrl
import com.example.liked_screen.databinding.BookmarkItemBinding
import com.example.liked_screen.domain.model.PhoneBookmark

class BookmarkViewHolder(private var binding: BookmarkItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val bookmark = binding.imageViewBookmarkAddButton
    @SuppressLint("SetTextI18n")
    fun bind(phoneBookmark: PhoneBookmark) {
        binding.apply {
            textViewMainTitle.text = phoneBookmark.title
            textViewDiscountPrice.text = "$${phoneBookmark.priceWithoutDiscount}"
            textViewPriceWithoutDiscount.text = "$${phoneBookmark.discountPrice}"
            textViewPriceWithoutDiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            imageViewBookmark.setImageDrawableFromUrl(
                phoneBookmark.picture,
                RADIUS_ROUNDED_CORNERS_30
            )
        }
    }
}