package com.ray.language.domain.music.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicInformation(
    val title: String,
    val artist: String,
    val duration: Long,
    val path: String,
    val albumId: Long
) : Parcelable {
    companion object {
        val default: MusicInformation = MusicInformation(
            title = "",
            artist = "",
            duration = 0L,
            path = "",
            albumId = 0
        )
    }
}
