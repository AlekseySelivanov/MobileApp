package com.example.home_screen.home_screen.ui.adapters

import com.example.home_screen.home_screen.domain.model.BestSeller

interface BookmarkClickListener {

    fun addBookmark(bestSeller: BestSeller)

    fun deleteBookmark(bestSeller: BestSeller)
}