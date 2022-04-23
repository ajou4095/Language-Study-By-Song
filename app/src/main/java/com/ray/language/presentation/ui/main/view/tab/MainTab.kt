package com.ray.language.presentation.ui.main.view.tab

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ray.language.R
import com.ray.language.common.util.dp
import com.ray.language.databinding.ViewMainTabBinding
import com.ray.language.presentation.ui.common.view.OnItemClickListener

class MainTab @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {
    private val binding = ViewMainTabBinding.inflate(LayoutInflater.from(context), this, true)

    var onItemClick: OnItemClickListener? = null

    init {
        minHeight = 52.dp.toInt()
        maxHeight = 52.dp.toInt()

        with(binding) {
            study.imageAlpha = MainTabContract.SELECTED_ALPHA
            study.scaleX = 1.2f
            study.scaleY = 1.2f
            backgroundStudy.setOnClickListener {
                onItemClick?.onClick(MainTabContract.TAB_STUDY)
                animateAllIcons(MainTabContract.TAB_STUDY)
            }
            exam.imageAlpha = MainTabContract.DESELECTED_ALPHA
            backgroundExam.setOnClickListener {
                onItemClick?.onClick(MainTabContract.TAB_EXAM)
                animateAllIcons(MainTabContract.TAB_EXAM)
            }
            settings.imageAlpha = MainTabContract.DESELECTED_ALPHA
            backgroundSettings.setOnClickListener {
                onItemClick?.onClick(MainTabContract.TAB_SETTINGS)
                animateAllIcons(MainTabContract.TAB_SETTINGS)
            }
        }
    }

    private fun animateAllIcons(position: Int) {
        with(binding) {
            when (position) {
                MainTabContract.TAB_STUDY -> {
                    study.animateIcon(true)
                    exam.animateIcon(false)
                    settings.animateIcon(false)
                }
                MainTabContract.TAB_EXAM -> {
                    study.animateIcon(false)
                    exam.animateIcon(true)
                    settings.animateIcon(false)
                }
                MainTabContract.TAB_SETTINGS -> {
                    study.animateIcon(false)
                    exam.animateIcon(false)
                    settings.animateIcon(true)
                }
            }
        }
    }

    private fun ImageView.animateIcon(select: Boolean) {
        if (select) {
            ValueAnimator.ofInt(imageAlpha, MainTabContract.SELECTED_ALPHA)
        } else {
            ValueAnimator.ofInt(imageAlpha, MainTabContract.DESELECTED_ALPHA)
        }.run {
            addUpdateListener { animation ->
                this@animateIcon.imageAlpha = animation.animatedValue as Int
            }
            interpolator = DecelerateInterpolator()
            duration = resources.getInteger(R.integer.animation_duration).toLong()
            start()
        }

        if (select) {
            ValueAnimator.ofFloat(scaleX, 1.2f)
        } else {
            ValueAnimator.ofFloat(scaleX, 1f)
        }.run {
            addUpdateListener { animation ->
                this@animateIcon.scaleX = animation.animatedValue as Float
                this@animateIcon.scaleY = animation.animatedValue as Float
            }
            interpolator = DecelerateInterpolator()
            duration = resources.getInteger(R.integer.animation_duration).toLong()
            start()
        }
    }
}