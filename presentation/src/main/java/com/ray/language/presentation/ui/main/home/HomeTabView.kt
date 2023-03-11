package com.ray.language.presentation.ui.main.home

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ray.language.presentation.common.design.OnItemClickListener
import com.ray.language.presentation.databinding.ViewMainTabBinding
import com.ray.rds.util.dp

class HomeTabView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {
    private val binding = ViewMainTabBinding.inflate(LayoutInflater.from(context), this, true)

    var onItemClick: OnItemClickListener? = null
        set(value) {
            field = value
            value?.onClick(HomeContract.TAB_STUDY)
            animateAllIcons(HomeContract.TAB_STUDY)
        }

    init {
        minHeight = 52.dp.toInt()
        maxHeight = 52.dp.toInt()

        with(binding) {
            study.imageAlpha = HomeContract.DESELECTED_ALPHA
            backgroundStudy.setOnClickListener {
                onItemClick?.onClick(HomeContract.TAB_STUDY)
                animateAllIcons(HomeContract.TAB_STUDY)
            }
            exam.imageAlpha = HomeContract.DESELECTED_ALPHA
            backgroundExam.setOnClickListener {
                onItemClick?.onClick(HomeContract.TAB_EXAM)
                animateAllIcons(HomeContract.TAB_EXAM)
            }
            settings.imageAlpha = HomeContract.DESELECTED_ALPHA
            backgroundSettings.setOnClickListener {
                onItemClick?.onClick(HomeContract.TAB_SETTINGS)
                animateAllIcons(HomeContract.TAB_SETTINGS)
            }
        }
    }

    private fun animateAllIcons(position: Int) {
        with(binding) {
            when (position) {
                HomeContract.TAB_STUDY -> {
                    study.animateIcon(true)
                    exam.animateIcon(false)
                    settings.animateIcon(false)
                }
                HomeContract.TAB_EXAM -> {
                    study.animateIcon(false)
                    exam.animateIcon(true)
                    settings.animateIcon(false)
                }
                HomeContract.TAB_SETTINGS -> {
                    study.animateIcon(false)
                    exam.animateIcon(false)
                    settings.animateIcon(true)
                }
            }
        }
    }

    private fun ImageView.animateIcon(select: Boolean) {
        if (select) {
            ValueAnimator.ofInt(imageAlpha, HomeContract.SELECTED_ALPHA)
        } else {
            ValueAnimator.ofInt(imageAlpha, HomeContract.DESELECTED_ALPHA)
        }.run {
            addUpdateListener { animation ->
                this@animateIcon.imageAlpha = animation.animatedValue as Int
            }
            interpolator = DecelerateInterpolator()
            duration = resources.getInteger(com.ray.rds.R.integer.animation_duration).toLong()
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
            duration = resources.getInteger(com.ray.rds.R.integer.animation_duration).toLong()
            start()
        }
    }
}
