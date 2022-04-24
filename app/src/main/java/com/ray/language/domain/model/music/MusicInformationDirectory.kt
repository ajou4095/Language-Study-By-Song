package com.ray.language.domain.model.music

import android.os.Parcelable
import com.ray.language.domain.model.music.information.MusicInformation
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicInformationDirectory(
    val directory: String,
    val musicInformationList: List<MusicInformation>
) : Parcelable {
    companion object {
        val default: MusicInformationDirectory = MusicInformationDirectory(
            directory = "",
            musicInformationList = listOf()
        )
    }
}