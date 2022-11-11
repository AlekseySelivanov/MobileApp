package com.example.product_details_screen.products_details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.common.constants.extensions.launchWhenStarted
import com.example.common.di.CoreInjectorHelper
import com.example.navigation.Destination
import com.example.navigation.navigateToDestination
import com.example.product_details_screen.databinding.FragmentProductDetailsBinding
import com.example.product_details_screen.di.DaggerProductDetailsComponent
import com.example.product_details_screen.products_details_screen.viewModel.ProductDetailsViewModel
import com.example.product_details_screen.products_details_screen.adapters.PDPageAdapter
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ProductDetailsViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerProductDetailsComponent.builder()
                .coreComponent(
                    CoreInjectorHelper
                        .provideCoreComponent(requireActivity().applicationContext)
                )
                .build()
        component.provideProductDetailsFragmentComponent(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.phoneDetailsList.onEach {
            it.let {
                binding.apply {
                    textViewPDPhoneTitle.text = it.title
                    textViewCpu.text = it.cpu
                    textViewCamera.text = it.camera
                    textViewRam.text = it.ssd
                    textViewStorage.text = it.sd
                    textView128GB.text = it.capacity?.get(0)
                    textView256GB.text = it.capacity?.get(1)
                }
            }
            val adapterPD = it.images?.let { it1 ->
                PDPageAdapter(
                    requireActivity(),
                    it1.size
                )
            }
            binding.viewPagerPD.adapter = adapterPD
        }.launchWhenStarted(lifecycleScope)

        setupButtonMyCart()
        setupPDScreenState()
    }

    private fun setupPDScreenState() {
        viewModel.status.onEach {
            when (it) {
                is DetailsApiStatus.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        it.error,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                else -> {}
            }
        }.launchWhenStarted(lifecycleScope)
    }

    private fun setupButtonMyCart() {
        binding.apply {
            buttonMyCart.setOnClickListener {
                navigateToDestination(Destination.Cart)
            }
        }
    }

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}