package com.ray.language.presentation.common.util

import android.graphics.Color

fun Int.destructAsArgb(): List<Int> {
    return listOf(
        Color.alpha(this),
        Color.red(this),
        Color.green(this),
        Color.blue(this)
    )
}

fun interpolateColor(
    fromColor: Int,
    toColor: Int,
    percent: Float
): Int {
    val (alpha1, red1, green1, blue1) = fromColor.destructAsArgb()
    val (alpha2, red2, green2, blue2) = toColor.destructAsArgb()
    return Color.argb(
        alpha1 + ((alpha2 - alpha1) * percent).toInt(),
        red1 + ((red2 - red1) * percent).toInt(),
        green1 + ((green2 - green1) * percent).toInt(),
        blue1 + ((blue2 - blue1) * percent).toInt(),
    )
}
