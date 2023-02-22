package com.ray.language.common

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

fun Boolean?.orTrue(): Boolean {
    return this ?: true
}
