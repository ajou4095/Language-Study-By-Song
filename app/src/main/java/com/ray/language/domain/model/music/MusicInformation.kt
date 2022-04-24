package com.ray.language.domain.model.music

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicInformation(
    val title: String,
    val artist: String,
    val path: String
) : Parcelable {
    companion object {
        val default: MusicInformation = MusicInformation(
            title = "",
            artist = "",
            path = ""
        )
    }
}