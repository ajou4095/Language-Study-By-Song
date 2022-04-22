package com.ray.language.domain.model.music

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LyricsInformation(
    val lyricsId: Int,
    val lyricsBody: String
) : Parcelable {
    companion object {
        val default: LyricsInformation = LyricsInformation(
            lyricsId = 0,
            lyricsBody = ""
        )
    }
}