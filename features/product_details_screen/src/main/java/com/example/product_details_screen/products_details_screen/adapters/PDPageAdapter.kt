package com.example.product_details_screen.products_details_screen.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.common.constants.Constants.PD_IMAGE_POSITION
import com.example.product_details_screen.products_details_screen.PDItemFragment

class PDPageAdapter(fragment: FragmentActivity, private val listSize: Int) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = listSize

    override fun createFragment(position: Int): Fragment {
        val imageFragment = PDItemFragment()
        imageFragment.arguments = Bundle().apply {
            putInt(PD_IMAGE_POSITION, position)
        }
        return imageFragment
    }
}