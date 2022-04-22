package com.ray.language.data.model.musixmatch

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class LyricsResLyrics(
    @Json(name = "lyrics_id")
    val lyricsId: Int,

    @Json(name = "lyrics_body")
    val lyricsBody: String
) : Parcelable