package com.ray.language.presentation.ui.common.view.item

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.use
import androidx.core.view.isVisible
import com.ray.language.R
import com.ray.language.common.util.delayOnLifecycle
import com.ray.language.core.presentation.util.dp
import com.ray.language.databinding.ViewSelectItemBinding
import com.ray.language.presentation.ui.common.UiCommonContract

class SelectItem @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {
    private val binding = ViewSelectItemBinding.inflate(LayoutInflater.from(context), this, true)

    var onIntervalClick: OnClickListener? = null
        set(value) {
            field = value
            this.setOnClickListener {
                if (isClickable) {
                    isClickable = false
                    delayOnLifecycle(UiCommonContract.INTERVAL_CLICK_DURATION) {
                        isClickable = true
                    }
                    value?.onClick(it)
                }
            }
        }

    init {
        context.obtainStyledAttributes(attributeSet, R.styleable.SelectItem).use { attributes ->
            setText(attributes.getText(R.styleable.SelectItem_android_text) ?: "")
            setImageResource(attributes.getResourceId(R.styleable.SelectItem_android_src, ResourcesCompat.ID_NULL))
        }

        val background = TypedValue().apply {
            context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
        }
        setBackgroundResource(background.resourceId)
        minHeight = 50.dp.toInt()
        maxHeight = 50.dp.toInt()
        isClickable = true
    }

    fun setText(text: CharSequence) {
        binding.text.text = text
    }

    fun setImageResource(@DrawableRes resId: Int) {
        binding.icon.isVisible = (resId != ResourcesCompat.ID_NULL)
        if (binding.icon.isVisible) {
            binding.icon.setImageResource(resId)
        }
    }
}