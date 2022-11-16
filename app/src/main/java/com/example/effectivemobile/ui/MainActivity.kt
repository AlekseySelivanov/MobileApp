package com.example.effectivemobile.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cart_screen.di.CartInjectorHelper
import com.example.cart_screen.ui.MyCartFragment
import com.example.common.constants.Constants.MAIN_ACTIVITY_TAG
import com.example.common.constants.extensions.launchWhenStarted
import com.example.common.di.CoreInjectorHelper
import com.example.effectivemobile.R
import com.example.effectivemobile.databinding.ActivityMainBinding
import com.example.effectivemobile.di.mainActivity.DaggerMainActivityComponent
import com.example.home_screen.home_screen.di.HomeScreenInjectorHelper
import com.example.home_screen.home_screen.ui.HomeFragment
import com.example.liked_screen.di.LikedScreenInjectorHelper
import com.example.liked_screen.ui.LikedFragment
import com.example.map_screen.MapsFragment
import com.example.navigation.Destination
import com.example.navigation.setFragmentNavigationListener
import com.example.product_details_screen.di.ProductScreenInjectorHelper
import com.example.product_details_screen.ui.ProductDetailsFragment
import com.google.android.material.badge.BadgeDrawable
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val component =
            DaggerMainActivityComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .cartComponent(CartInjectorHelper.provideCartComponent(applicationContext))
                .homeScreenComponent(HomeScreenInjectorHelper.provideHomeScreenComponent(applicationContext))
                .likedScreenComponent(LikedScreenInjectorHelper.provideLikedScreenComponent(applicationContext))
                .productDetailsScreenComponent(ProductScreenInjectorHelper.provideProductDetailsScreenComponent(applicationContext))
                .build()
        component.provideMainActivityComponent(this)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentContainer.id, HomeFragment.newInstance())
                commit()

            }
        }
        setupBottomBarButtonsNavigation()
        setupListeners()
        fillCountOfElementsOnBottomBarButtons()
    }

    private fun fillCountOfElementsOnBottomBarButtons() {
        addBadge("2", R.id.cart_item)
        viewModel.bookmarksList.onEach {
            addBadge(it.size.toString(), R.id.liked_item)
        }.launchWhenStarted(lifecycleScope)
    }

    private fun addBadge(count: String, buttonId: Int) {
        val badge: BadgeDrawable = binding.bottomNavigationView.getOrCreateBadge(
            buttonId
        )
        badge.number = count.toInt()
        badge.isVisible = true
    }

    private fun setupListeners() {
        supportFragmentManager.setFragmentNavigationListener(this) { destination, isAddToBackstack ->
            when (destination) {
                Destination.ClearBackStack -> {
                    clearFragmentsFromContainer()
                }
                Destination.Back -> {
                    supportFragmentManager.popBackStack()
                }
                Destination.Home -> {
                    openNewFragment(HomeFragment.newInstance(), isAddToBackstack)
                }
                Destination.ProductDetails -> {
                    openNewFragment(ProductDetailsFragment.newInstance(), isAddToBackstack)
                }
                Destination.Cart -> {
                    openNewFragment(MyCartFragment.newInstance(), isAddToBackstack)
                }
                Destination.Maps -> {
                    openNewFragment(MapsFragment.newInstance(), isAddToBackstack)
                }
                Destination.Liked -> {
                    openNewFragment(LikedFragment.newInstance(), isAddToBackstack)
                }
                else -> {}
            }
        }
    }

    private fun clearFragmentsFromContainer() {
        val fragments = supportFragmentManager.fragments
        for (fragment in fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        supportFragmentManager.popBackStack(
            MAIN_ACTIVITY_TAG,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    private fun openNewFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, fragment)
            if (isAddToBackStack) {
                addToBackStack(MAIN_ACTIVITY_TAG)
            }
            commit()
        }
    }

    private fun setupBottomBarButtonsNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.explorer_item -> {
                    openNewFragment(HomeFragment.newInstance(), true)
                }
                R.id.cart_item -> {
                    openNewFragment(MyCartFragment.newInstance(), true)
                }
                R.id.liked_item -> {
                   openNewFragment(LikedFragment.newInstance(), true)
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}