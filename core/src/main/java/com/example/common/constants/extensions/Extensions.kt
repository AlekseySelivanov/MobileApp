package com.example.common.constants.extensions

import android.widget.ImageView
import androidx.lifecycle.LifecycleCoroutineScope
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.common.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun ImageView.setImageDrawableFromUrl(imgUrl: String, radiusRoundedCorners: Float = 0f) {
    imgUrl.let {
        this.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(radiusRoundedCorners))
        }
    }
}

fun <T> Flow<T>.launchWhenStarted(lifeCycleScope: LifecycleCoroutineScope) = lifeCycleScope
    .launchWhenStarted {
        this@launchWhenStarted.collect()
    }