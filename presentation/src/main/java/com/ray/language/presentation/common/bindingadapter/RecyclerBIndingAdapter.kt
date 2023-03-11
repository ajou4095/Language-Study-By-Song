package com.ray.language.presentation.common.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ray.language.presentation.common.design.view.group.list.decoration.SpaceItemDecoration

@BindingAdapter("itemDecoration_space")
fun RecyclerView.addSpaceItemDecoration(_space: Float?) {
    val space = _space ?: return
    val orientation = (layoutManager as? LinearLayoutManager)?.orientation ?: return

    for (i in 0 until itemDecorationCount) {
        if (getItemDecorationAt(i) is SpaceItemDecoration) return
    }
    addItemDecoration(
        SpaceItemDecoration(
            space = space.toInt(),
            orientation = orientation
        )
    )
}
