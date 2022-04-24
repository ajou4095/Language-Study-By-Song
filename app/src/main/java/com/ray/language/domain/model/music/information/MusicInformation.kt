package com.ray.language.domain.model.music.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicInformation(
    val title: String,
    val artist: String,
    val path: String,
    val albumId: Long
) : Parcelable {
    companion object {
        val default: MusicInformation = MusicInformation(
            title = "",
            artist = "",
            path = "",
            albumId = 0
        )
    }
}