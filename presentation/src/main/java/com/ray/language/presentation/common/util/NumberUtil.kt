package com.ray.language.presentation.common.util

import kotlin.math.PI

fun Double.normalizeRadians(): Double {
    return (this % (2 * PI)).let {
        if (it < 0) {
            it + 2 * PI
        } else it
    }
}

fun Float.normalizeRadians(): Float {
    return (this % (2 * PI)).let {
        if (it < 0) {
            it + 2 * PI
        } else it
    }.toFloat()
}
