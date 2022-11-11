package com.example.home_screen.home_screen.adapters

import com.example.common.models.BestSeller

interface BookmarkClickListener {

    fun addBookmark(bestSeller: BestSeller)

    fun deleteBookmark(bestSeller: BestSeller)
}