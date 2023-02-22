package com.ray.language.domain.repository

import com.ray.language.domain.music.MusicInformationDirectory

interface LocalMusicRepository {
    fun getMusicInformationDirectoryList(): List<MusicInformationDirectory>
}
