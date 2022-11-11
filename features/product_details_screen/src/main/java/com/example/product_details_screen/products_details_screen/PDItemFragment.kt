package com.example.product_details_screen.products_details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.common.constants.Constants.PD_IMAGE_POSITION
import com.example.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.common.constants.extensions.launchWhenStarted
import com.example.common.constants.extensions.setImageDrawableFromUrl
import com.example.common.di.CoreInjectorHelper
import com.example.product_details_screen.databinding.FragmentPDItemBinding
import com.example.product_details_screen.di.DaggerPDItemComponent
import com.example.product_details_screen.products_details_screen.viewModel.ProductDetailsViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PDItemFragment : Fragment() {

    private var _binding: FragmentPDItemBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ProductDetailsViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerPDItemComponent.builder()
                .coreComponent(
                    CoreInjectorHelper
                        .provideCoreComponent(requireActivity().applicationContext)
                )
                .build()
        component.providePDItemFragmentComponent (this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPDItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillViewPagerItem()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillViewPagerItem() {
        arguments?.takeIf {
            it.containsKey(PD_IMAGE_POSITION)
        }?.apply {
            val position = getInt(PD_IMAGE_POSITION)
            viewModel.phoneDetailsList.onEach {
                val listImages = it.images
                val listSize = listImages.size
                for (i in 0 until listSize) {
                    when (position) {
                        i -> {
                            binding.apply {
                                imageViewPD.setImageDrawableFromUrl(
                                    listImages[i],
                                    RADIUS_ROUNDED_CORNERS_30
                                )
                            }
                        }
                    }
                }
            }.launchWhenStarted(lifecycleScope)
        }
    }
}