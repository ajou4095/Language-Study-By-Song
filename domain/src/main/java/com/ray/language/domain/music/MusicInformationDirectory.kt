package com.ray.language.domain.music

import android.os.Parcelable
import com.ray.language.domain.music.information.MusicInformation
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicInformationDirectory(
    val title: String,
    val path: String,
    val musicInformationList: List<MusicInformation>
) : Parcelable {
    companion object {
        val default: MusicInformationDirectory = MusicInformationDirectory(
            title = "",
            path = "",
            musicInformationList = emptyList()
        )
    }
}
