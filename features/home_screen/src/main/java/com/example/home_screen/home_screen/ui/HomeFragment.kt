package com.example.home_screen.home_screen.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.constants.extensions.launchWhenStarted
import com.example.common.di.CoreInjectorHelper
import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.R
import com.example.home_screen.databinding.FragmentHomeBinding
import com.example.home_screen.home_screen.di.HomeScreenInjectorHelper
import com.example.home_screen.home_screen.di.fragment.DaggerHomeComponent
import com.example.home_screen.home_screen.ui.adapters.BestSellerAdapter
import com.example.home_screen.home_screen.ui.adapters.BookmarkClickListener
import com.example.home_screen.home_screen.ui.adapters.HomeStorePageAdapter
import com.example.home_screen.home_screen.domain.model.CategoryModel
import com.example.home_screen.home_screen.ui.recycler_view.categoryRecyclerView.CategoryRecyclerViewAdapter
import com.example.home_screen.home_screen.ui.state.MainScreenStatus
import com.example.navigation.Destination
import com.example.navigation.navigateToDestination
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = checkNotNull(_binding)
    private var categoriesList: MutableList<CategoryModel> = mutableListOf()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerHomeComponent.builder()
                .homeScreenComponent(
                    HomeScreenInjectorHelper
                        .provideHomeScreenComponent(requireActivity().applicationContext)
                )

                .build()
        component.provideHomeFragmentComponent  (this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategoriesAdapter()
        setupHotSalesAdapter()
        setupBottomFragment()
        setupMainScreenStatus()
        setupBestSellerAdapter()
        setupMapsButton()

    }

    private fun setupMapsButton() {
        binding.location.setOnClickListener{
            navigateToDestination(Destination.Maps)
        }
    }

    private fun setupHotSalesAdapter() {
        viewModel.homeStoreListSize.onEach {
            val adapterRV = HomeStorePageAdapter(
                requireActivity(),
                listSize = it
            )
            binding.viewPagerHomeStore.adapter = adapterRV
        }.launchWhenStarted(lifecycleScope)
    }

    private fun setupBottomFragment() {
        binding.filter.setOnClickListener {
                val filterBottomSheetDialogFragment =
                    BottomSheetFragment.newInstance()
                filterBottomSheetDialogFragment.show(
                    childFragmentManager,
                    BottomSheetFragment::class.java.canonicalName
                )
            }
    }

    private fun setupMainScreenStatus() {
        viewModel.status.onEach {
            when (it) {
                is MainScreenStatus.ERROR -> {
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

    private fun setupCategoriesAdapter() {
        val categoriesAdapter = CategoryRecyclerViewAdapter {
            CategoryModel()
        }

        categoriesList = listOf(
            CategoryModel(
                id = 1,
                "Phones",
                R.drawable.ellipse_activate,
                R.drawable.ic_baseline_phone_iphone_24
            ),
            CategoryModel(
                id = 2,
                "Computer",
                R.drawable.ellipse_not_activate,
                R.drawable.ic_baseline_computer_24
            ),
            CategoryModel(
                id = 3,
                "Health",
                R.drawable.ellipse_not_activate,
                R.drawable.ic_baseline_medical_services_24
            ),
            CategoryModel(
                id = 3,
                "Books",
                R.drawable.ellipse_not_activate,
                R.drawable.ic_baseline_library_books_24
            ),
            CategoryModel(
                id = 4,
                "Android phones",
                R.drawable.ellipse_not_activate,
                R.drawable.ic_baseline_phone_android_24
            )
        ) as MutableList<CategoryModel>

        categoriesAdapter.setData(categoriesList)
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.apply {
            rvCategory.layoutManager = linearLayoutManager
            rvCategory.adapter = categoriesAdapter
        }
    }

    private fun setupBestSellerAdapter() {
        val adapterBS = BestSellerAdapter({
            navigateToDestination(Destination.ProductDetails)
        },
            object : BookmarkClickListener {
                override fun addBookmark(bestSeller: BestSeller) {
                    viewModel.addBookmark(bestSeller)
                }

                override fun deleteBookmark(bestSeller: BestSeller) {
                    viewModel.deleteBookmark(bestSeller)
                }

            }
        )
        binding.rvBestSeller.apply {
            adapter = adapterBS
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        viewModel.bestSellerPhonesList.onEach {
            adapterBS.submitList(it)
        }.launchWhenStarted(lifecycleScope)
    }



    private fun showToast(toastText: String) {
        Toast.makeText(
            requireContext(),
            toastText,
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}