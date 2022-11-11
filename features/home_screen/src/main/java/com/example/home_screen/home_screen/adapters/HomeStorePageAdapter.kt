package com.example.home_screen.home_screen.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.common.constants.Constants.HOME_STORE_ITEM_IMAGE_POSITION
import com.example.home_screen.home_screen.HotSalesFragment

class HomeStorePageAdapter(
    fragment: FragmentActivity, private val listSize: Int
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = listSize

    override fun createFragment(position: Int): Fragment {
        val imageFragment = HotSalesFragment()
        imageFragment.arguments = Bundle().apply {
            putInt(HOME_STORE_ITEM_IMAGE_POSITION, position)
        }
        return imageFragment
    }
}