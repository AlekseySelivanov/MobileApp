package com.example.cart_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cart_screen.databinding.FragmentMyCartBinding
import com.example.cart_screen.di.DaggerCartComponent
import com.example.cart_screen.viewModel.MyCartViewModel
import com.example.common.constants.extensions.launchWhenStarted
import com.example.common.constants.extensions.setImageDrawableFromUrl
import com.example.common.di.CoreInjectorHelper
import com.example.navigation.Destination
import com.example.navigation.navigateToDestination
import kotlinx.coroutines.flow.onEach
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

class MyCartFragment : Fragment() {

    private var _binding: FragmentMyCartBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MyCartViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerCartComponent.builder()
                .coreComponent(
                    CoreInjectorHelper
                        .provideCoreComponent(requireActivity().applicationContext)
                )
                .build()
        component.provideMyCartFragmentComponent  (this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillProductsWithInfo()
        setupState()
        setupBtnBack()
    }

    private fun setupBtnBack() {
        binding.imageButtonBack.setOnClickListener{
            navigateToDestination(Destination.Home)
        }
    }

    private fun setupState() {
    viewModel.status
        .onEach { event ->
            when (event) {
                is MyCartApiStatus.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        event.error,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                else -> {}
            }
        }.launchWhenStarted(lifecycleScope)
}

    private fun fillProductsWithInfo() {
        viewModel.myCart.onEach { basketMain ->
            binding.apply {
                textViewDelivery.text = basketMain.delivery
                val total = NumberFormat.getCurrencyInstance(Locale.US).format(basketMain.total)
                textViewTotal.text = "$total us"
            }
            val basketProductsList = basketMain.basket
            val basketProduct1 = basketProductsList?.get(0)
            val basketProduct2 = basketProductsList?.get(1)
            binding.apply {
                if (basketProduct1 != null) {
                    imageViewItem1.setImageDrawableFromUrl(basketProduct1.images)
                }
                if (basketProduct1 != null) {
                    textViewItem1Name.text = basketProduct1.title
                }
                if (basketProduct1 != null) {
                    textViewItem1Price.text =
                        NumberFormat.getCurrencyInstance(Locale.US).format(basketProduct1.price)
                }
                val image2Url = (basketProduct2?.images)?.substringBefore('?')
                if (image2Url != null) {
                    imageViewItem2.setImageDrawableFromUrl(image2Url)
                }
                if (basketProduct2 != null) {
                    textViewItem2Name.text = basketProduct2.title
                }
                if (basketProduct2 != null) {
                    textViewItem2Price.text =
                        NumberFormat.getCurrencyInstance(Locale.US).format(basketProduct2.price)
                }
            }
        }.launchWhenStarted(lifecycleScope)
    }

    companion object {
        fun newInstance() = MyCartFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}