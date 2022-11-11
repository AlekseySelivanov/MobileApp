package com.example.navigation

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

private const val REQ_KEY_MAIN_DESTINATION = "mainNavigationResult"

private const val PARAM_DATA = "bundleData"
private const val ADD_TO_BACKSTACK_DATA = "addToBackStackBoolean"

fun Fragment.navigateToDestination(destination: Destination, isAddToBackstack: Boolean = true) {
    requireActivity().supportFragmentManager.setFragmentResult(
        REQ_KEY_MAIN_DESTINATION,
        bundleOf(PARAM_DATA to destination, ADD_TO_BACKSTACK_DATA to isAddToBackstack)
    )
}

fun FragmentManager.setFragmentNavigationListener(
    lifecycleOwner: LifecycleOwner,
    listener: (destination: Destination, isAddToBackstack: Boolean) -> Any
) {
    setFragmentResultListener(REQ_KEY_MAIN_DESTINATION, lifecycleOwner) { _, bundle ->
        val destination = bundle.getParcelable<Destination>(PARAM_DATA)!!
        val isAddToBackstack = bundle.getBoolean(ADD_TO_BACKSTACK_DATA)
        listener.invoke(destination, isAddToBackstack)
    }
}