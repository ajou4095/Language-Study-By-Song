package com.ray.language.common.util

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

fun Boolean?.orTrue(): Boolean {
    return this ?: true
}