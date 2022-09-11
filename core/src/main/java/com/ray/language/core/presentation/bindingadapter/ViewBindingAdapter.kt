package com.ray.language.core.presentation.bindingadapter

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.ray.language.core.common.util.delayOnLifecycle
import com.ray.language.core.presentation.UiCommonContract.INTERVAL_CLICK_DURATION

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(isVisible: Boolean?) {
    this.isVisible = (isVisible == true)
}

@BindingAdapter(
    value = ["onIntervalClick", "intervalDuration"],
    requireAll = false
)
fun View.setOnIntervalClick(
    listener: View.OnClickListener?,
    duration: Long? = INTERVAL_CLICK_DURATION
) {
    isClickable = true
    this.setOnClickListener {
        if (isClickable) {
            isClickable = false
            delayOnLifecycle(duration ?: INTERVAL_CLICK_DURATION) {
                isClickable = true
            }
            listener?.onClick(it)
        }
    }
}