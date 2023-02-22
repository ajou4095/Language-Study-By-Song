package com.ray.language.common

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}
