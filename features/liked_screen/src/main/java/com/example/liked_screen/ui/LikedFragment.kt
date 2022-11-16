package com.example.liked_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common.constants.extensions.launchWhenStarted
import com.example.liked_screen.databinding.FragmentBookmarksBinding
import com.example.liked_screen.di.LikedScreenInjectorHelper
import com.example.liked_screen.di.fragment.DaggerLikedComponent
import com.example.liked_screen.ui.adapter.BookmarkAdapter
import com.example.liked_screen.ui.viewModel.LikedViewModel
import com.example.navigation.Destination
import com.example.navigation.navigateToDestination
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LikedFragment : Fragment() {

    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<LikedViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerLikedComponent.builder()
                .likedScreenComponent(
                    LikedScreenInjectorHelper
                        .provideLikedScreenComponent(requireActivity().applicationContext)
                )
                .build()
        component.provideLikedFragmentComponent (this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViewAdapter()
        setupFloatingButton()

    }

    private fun setupRecyclerViewAdapter() {
        val adapterBookmark = BookmarkAdapter(
            {
                navigateToDestination(Destination.ProductDetails)

            }, { phoneBookmark ->
                viewModel.deleteBookmark(phoneBookmark)
            }
        )
        binding.recyclerViewBookmarks.apply {
            adapter = adapterBookmark
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        viewModel.bookmarksList.onEach {
            adapterBookmark.submitList(it)
        }.launchWhenStarted(lifecycleScope)
    }

    private fun setupFloatingButton() {
        binding.buttonDeleteAll.setOnClickListener {
            viewModel.deleteAllBooks()
        }
    }

    companion object {
        fun newInstance() = LikedFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}