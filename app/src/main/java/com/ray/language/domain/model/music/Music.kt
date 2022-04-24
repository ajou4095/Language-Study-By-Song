package com.ray.language.domain.model.music

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val lyricsInformation: LyricsInformation,
    val musicInformation: MusicInformation
) : Parcelable {
    companion object {
        val default: Music = Music(
            lyricsInformation = LyricsInformation.default,
            musicInformation = MusicInformation.default
        )
    }
}