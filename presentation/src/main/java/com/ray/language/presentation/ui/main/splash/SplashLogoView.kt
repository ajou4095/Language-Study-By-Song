package com.ray.language.presentation.ui.main.splash

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.annotation.FloatRange
import androidx.core.animation.addListener
import com.ray.language.presentation.common.design.listener.OnEventListener
import com.ray.language.presentation.common.util.interpolateColor
import com.ray.rds.R
import com.ray.rds.util.dp

class SplashLogoView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attributeSet, defStyle) {

    private val paint: Paint = Paint().apply {
        style = Paint.Style.STROKE
    }

    private val rect = RectF()

    private val strokeGraphStep1
        get() = rect.width() / 4

    private val strokeGraphStep2
        get() = strokeGraphStep1 / 6

    private val strokeGraphStep3
        get() = rect.width() / 2

    var onAnimationEnd: OnEventListener? = null

    private val animator: ValueAnimator = ValueAnimator.ofFloat(0f, AnimateStep.size.toFloat()).apply {
        interpolator = LinearInterpolator()
        duration = 2000

        addUpdateListener {
            val step: AnimateStep = AnimateStep.getStep(it.animatedValue as Float) ?: return@addUpdateListener
            val value: Float = (it.animatedValue as Float) % 1f

            when (step) {
                AnimateStep.STEP1 -> {
                    appearAnimationTick = value
                }
                AnimateStep.STEP2 -> {
                    emphasisAnimationTick = value
                }
                AnimateStep.STEP3 -> {
                    logoAnimationTick = value
                }
                AnimateStep.STEP4 -> {
                    moveAnimationTick = value
                }
            }
            invalidate()
        }

        addListener(
            onEnd = {
                onAnimationEnd?.onEvent()
            }
        )
    }

    private val decelerateInterpolator = DecelerateInterpolator()

    @FloatRange(from = 0.0, to = 1.0)
    private var appearAnimationTick: Float = 0f

    private val interpolatedAppearTick
        get() = decelerateInterpolator.getInterpolation(appearAnimationTick)

    @FloatRange(from = 0.0, to = 1.0)
    private var emphasisAnimationTick: Float = 0f

    private val interpolatedEmphasisTick
        get() = decelerateInterpolator.getInterpolation(emphasisAnimationTick)

    @FloatRange(from = 0.0, to = 1.0)
    private var logoAnimationTick: Float = 0f

    private val interpolatedLogoTick
        get() = decelerateInterpolator.getInterpolation(logoAnimationTick)

    @FloatRange(from = 0.0, to = 1.0)
    private var moveAnimationTick: Float = 0f

    private val interpolatedMoveTick
        get() = decelerateInterpolator.getInterpolation(moveAnimationTick)

    init {
//        context.obtainStyledAttributes(attributeSet, R.styleable.LogoView).use { attributes ->
//
//        }
        if (isInEditMode) {
            appearAnimationTick = AnimateStep.size.toFloat()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        measureRect()
        canvas?.let {
            drawLogo(it)
        }
    }

    private fun drawLogo(canvas: Canvas) {
        paint.strokeWidth = strokeGraphStep1 + (strokeGraphStep3 - strokeGraphStep1) * interpolatedLogoTick
        paint.color = context.getColor(R.color.green_400)
        paint.alpha = (255 * (1f - interpolatedLogoTick)).toInt()
        canvas.drawArc(
            rect.left + strokeGraphStep1 - paint.strokeWidth / 2 - (strokeGraphStep3 - strokeGraphStep1) * interpolatedLogoTick,
            rect.top + strokeGraphStep1 - paint.strokeWidth / 2 - (strokeGraphStep3 - strokeGraphStep1) * interpolatedLogoTick,
            rect.right - strokeGraphStep1 + paint.strokeWidth / 2 + (strokeGraphStep3 - strokeGraphStep1) * interpolatedLogoTick,
            rect.bottom - strokeGraphStep1 + paint.strokeWidth / 2 + (strokeGraphStep3 - strokeGraphStep1) * interpolatedLogoTick,
            -90f,
            90f * interpolatedAppearTick,
            false,
            paint
        )

        paint.strokeWidth =
            strokeGraphStep1 + (strokeGraphStep2 - strokeGraphStep1) * interpolatedEmphasisTick + (strokeGraphStep3 - strokeGraphStep2) * interpolatedLogoTick
        paint.color = context.getColor(R.color.blue_400)
        paint.alpha = (255 * (1f - interpolatedLogoTick)).toInt()
        canvas.drawArc(
            rect.left + strokeGraphStep1 - paint.strokeWidth / 2 - (strokeGraphStep3 - strokeGraphStep2) * interpolatedLogoTick,
            rect.top + strokeGraphStep1 - paint.strokeWidth / 2 - (strokeGraphStep3 - strokeGraphStep2) * interpolatedLogoTick,
            rect.right - strokeGraphStep1 + paint.strokeWidth / 2 + (strokeGraphStep3 - strokeGraphStep2) * interpolatedLogoTick,
            rect.bottom - strokeGraphStep1 + paint.strokeWidth / 2 + (strokeGraphStep3 - strokeGraphStep2) * interpolatedLogoTick,
            -90f + 90f * interpolatedAppearTick,
            270f * interpolatedAppearTick,
            false,
            paint
        )

        if (interpolatedLogoTick == 0f) return
        paint.alpha = 255
        paint.color = interpolateColor(context.getColor(R.color.green_400), context.getColor(R.color.blue_400), 0.5f)
        paint.strokeWidth = STROKE_LOGO.dp
        val length1 = rect.centerY() - rect.top
        val length2 = strokeGraphStep1
        if (length1 / (length1 + length2) > interpolatedLogoTick) {
            canvas.drawRoundRect(
                rect.centerX() - STROKE_LOGO.dp / 2,
                rect.top - STROKE_LOGO.dp / 2,
                rect.centerX() + STROKE_LOGO.dp / 2,
//                rect.centerY() + STROKE_LOGO.dp / 2,
                rect.top + interpolatedLogoTick * (length1 + length2) + STROKE_LOGO.dp / 2,
                STROKE_LOGO.dp / 2,
                STROKE_LOGO.dp / 2,
                paint
            )
        } else {
            canvas.drawRoundRect(
                paddingLeft + STROKE_LOGO.dp / 2 + (rect.centerX() - STROKE_LOGO.dp - paddingLeft) * (1f - interpolatedMoveTick),
                rect.top - STROKE_LOGO.dp / 2,
                paddingLeft + STROKE_LOGO.dp * 3 / 2 + (rect.centerX() - STROKE_LOGO.dp - paddingLeft) * (1f - interpolatedMoveTick),
                rect.centerY() + STROKE_LOGO.dp / 2,
                STROKE_LOGO.dp / 2,
                STROKE_LOGO.dp / 2,
                paint
            )

            canvas.drawRoundRect(
                paddingLeft + STROKE_LOGO.dp / 2 + (rect.centerX() - STROKE_LOGO.dp - paddingLeft) * (1f - interpolatedMoveTick),
                rect.centerY() - STROKE_LOGO.dp / 2,
//                rect.centerX() + strokeGraphStep1 + STROKE_LOGO.dp / 2,
                paddingLeft + interpolatedLogoTick * (length1 + length2) - length1 + STROKE_LOGO.dp / 2 + (rect.centerX() - paddingLeft) * (1f - interpolatedMoveTick),
                rect.centerY() + STROKE_LOGO.dp / 2,
                STROKE_LOGO.dp / 2,
                STROKE_LOGO.dp / 2,
                paint
            )
        }
    }

    private fun measureRect() {
        val fixedWidth = width - paddingStart - paddingEnd - strokeGraphStep2 / 2
        val fixedHeight = height - paddingTop - paddingBottom - strokeGraphStep2 / 2
        val fixedSize = if (fixedWidth > fixedHeight) {
            fixedHeight
        } else {
            fixedWidth
        }
        rect.set(
            (width - fixedSize).div(2f),
            (height - fixedSize).div(2f),
            (width + fixedSize).div(2f),
            (height + fixedSize).div(2f)
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val fixedWidthMeasureSpec = if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED) {
            MeasureSpec.makeMeasureSpec(strokeGraphStep2.toInt(), MeasureSpec.EXACTLY)
        } else {
            widthMeasureSpec
        }

        val fixedHeightMeasureSpec = if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.UNSPECIFIED) {
            MeasureSpec.makeMeasureSpec(strokeGraphStep2.toInt(), MeasureSpec.EXACTLY)
        } else {
            heightMeasureSpec
        }

        super.onMeasure(fixedWidthMeasureSpec, fixedHeightMeasureSpec)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        animator.cancel()
        super.onDetachedFromWindow()
    }

    companion object {
        private const val STROKE_LOGO = 2
    }
}

private enum class AnimateStep {
    STEP1,
    STEP2,
    STEP3,
    STEP4;

    companion object {
        val size: Int
            get() = AnimateStep.values().size

        fun getStep(animatedValue: Number): AnimateStep? {
            return AnimateStep.values().getOrNull(animatedValue.toInt())
        }
    }
}

