package com.example.home_screen.home_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.common.constants.Constants.HOME_STORE_ITEM_IMAGE_POSITION
import com.example.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.common.constants.extensions.launchWhenStarted
import com.example.common.constants.extensions.setImageDrawableFromUrl
import com.example.home_screen.databinding.HomeStoreItemBinding
import com.example.home_screen.home_screen.di.HomeScreenInjectorHelper
import com.example.home_screen.home_screen.di.fragment.DaggerHotSalesComponent
import com.example.navigation.Destination
import com.example.navigation.navigateToDestination
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HotSalesFragment : Fragment() {

    private var _binding: HomeStoreItemBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerHotSalesComponent.builder()
                .homeScreenComponent(
                    HomeScreenInjectorHelper
                        .provideHomeScreenComponent(requireActivity().applicationContext)
                )
                .build()
        component.provideHotSalesFragmentComponent  (this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeStoreItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPagerItemNavigation()
        fillViewPagerItem()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillViewPagerItem() {
        arguments?.takeIf {
            it.containsKey(HOME_STORE_ITEM_IMAGE_POSITION)
        }?.apply {
            val position = getInt(HOME_STORE_ITEM_IMAGE_POSITION)
            viewModel.homeStorePhonesList.onEach {
                val listSize = it.size
                for (i in 0 until listSize) {
                    when (position) {
                        i -> {
                            val phone = it[i]
                            binding.apply {
                                textViewMainTitle.text = phone.title
                                textViewSubtitle.text = phone.subtitle
                                imageView.setImageDrawableFromUrl(
                                    phone.picture,
                                    RADIUS_ROUNDED_CORNERS_30
                                )
                            }
                        }
                    }
                }
            }.launchWhenStarted(lifecycleScope)
        }
    }

    private fun setupViewPagerItemNavigation() {
        binding.bestSellerLayout.setOnClickListener {
            navigateToDestination(Destination.ProductDetails)
        }
    }
}