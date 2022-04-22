package com.ray.language.data.model.musixmatch

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class LyricsResHeader(
    @Json(name = "execute_time")
    val executeTime: Double,

    @Json(name = "status_code")
    val statusCode: Int
) : Parcelable