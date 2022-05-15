package com.ray.language.common.util

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}