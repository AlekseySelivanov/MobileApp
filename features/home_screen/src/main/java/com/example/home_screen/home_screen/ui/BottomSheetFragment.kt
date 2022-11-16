package com.example.home_screen.home_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.home_screen.R
import com.example.home_screen.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSize()
        initPrice()
        initBrand()
        initcloseBtn()

    }

    private fun initcloseBtn() {
        binding.closeBTn.setOnClickListener {
            this.dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    private fun initBrand() {
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(), R.array.brand, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        binding.spinBrand.adapter = adapter
    }

    private fun initPrice() {
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(), R.array.price, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        binding.spinPrice.adapter = adapter
    }

    private fun initSize() {
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(), R.array.size, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        binding.spinSize.adapter = adapter
    }


    companion object {
        fun newInstance(): BottomSheetFragment =
            BottomSheetFragment()
    }
}