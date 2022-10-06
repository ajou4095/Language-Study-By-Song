package com.ray.language.data.mapper

interface DataMapper<D> {
    fun toDomain(): D
}