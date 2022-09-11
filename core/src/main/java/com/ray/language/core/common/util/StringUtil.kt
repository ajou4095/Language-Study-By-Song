package com.ray.language.core.common.util

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}