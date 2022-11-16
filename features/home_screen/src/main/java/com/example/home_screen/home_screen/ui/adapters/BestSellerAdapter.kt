package com.example.home_screen.home_screen.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.R
import com.example.home_screen.databinding.BestSellerItemBinding

class BestSellerAdapter(
    private val onItemClicked: (BestSeller) -> Unit,
    private val bookmarkClickListener: BookmarkClickListener
) :
    ListAdapter<BestSeller, BestSellerViewHolder>(BestSellerDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerViewHolder {
        return BestSellerViewHolder(
            BestSellerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val bestSeller = getItem(position)
        holder.bind(bestSeller)
        holder.itemView.setOnClickListener {
            onItemClicked(bestSeller)
        }
        holder.bookmark.setOnClickListener {
            if (bestSeller.pressed) {
                holder.bookmark.setImageResource(R.drawable.ic_bestseller_bookmark_empty)
                bookmarkClickListener.deleteBookmark(bestSeller)
                bestSeller.pressed = false
            } else {
                holder.bookmark.setImageResource(R.drawable.ic_bestseller_bookmark_full)
                bookmarkClickListener.addBookmark(bestSeller)
                bestSeller.pressed = true
            }
        }
    }
}