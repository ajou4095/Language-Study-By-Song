package com.ray.language.data.model.musixmatch

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class LyricsRes(
    @Json(name = "message")
    val message: LyricsResMessage
) : Parcelable