package com.ray.language.common.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.ray.language.common.util.livedata.Event
import com.ray.language.common.util.livedata.EventObserver

val LiveData<Boolean>.valueOrDefault: Boolean
    get() = value.orFalse()

val LiveData<Byte>.valueOrDefault: Byte
    get() = value.orZero()

val LiveData<Char>.valueOrDefault: Char
    get() = value.orEmpty()

val LiveData<Double>.valueOrDefault: Double
    get() = value.orZero()

val LiveData<Float>.valueOrDefault: Float
    get() = value.orZero()

val LiveData<Int>.valueOrDefault: Int
    get() = value.orZero()

val LiveData<Long>.valueOrDefault: Long
    get() = value.orZero()

val LiveData<Short>.valueOrDefault: Short
    get() = value.orZero()

val LiveData<String>.valueOrDefault: String
    get() = value.orEmpty()

fun <T> LiveData<Event<T>>.eventObserve(owner: LifecycleOwner, onEventUnhandledContent: (T) -> Unit) {
    this.observe(owner, EventObserver(onEventUnhandledContent))
}