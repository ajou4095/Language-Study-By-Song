package com.ray.language.data.model.musixmatch

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class LyricsResMessage(
    @Json(name = "body")
    val body: LyricsResBody,

    @Json(name = "header")
    val header: LyricsResHeader
) : Parcelable