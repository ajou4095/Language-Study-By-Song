package com.ray.language.common.util

val CharSequence?.isNotEmpty: Boolean
    get() = !isNullOrEmpty()
