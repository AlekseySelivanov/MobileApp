package com.example.home_screen.home_screen.adapters

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.common.constants.extensions.setImageDrawableFromUrl
import com.example.common.models.BestSeller
import com.example.home_screen.databinding.BestSellerItemBinding

class BestSellerViewHolder(private var binding: BestSellerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmark = binding.imageViewBSLikes

    fun bind(bestSeller: BestSeller) {
        binding.apply {
            textViewMainTitle.text = bestSeller.title
            textViewDiscountPrice.text = "$${bestSeller.priceWithoutDiscount}"
            textViewPriceWithourDiscount.text = "$${bestSeller.discountPrice}"
            textViewPriceWithourDiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            imageViewBestSeller.setImageDrawableFromUrl(
                bestSeller.picture,
                RADIUS_ROUNDED_CORNERS_30
            )
        }
    }
}