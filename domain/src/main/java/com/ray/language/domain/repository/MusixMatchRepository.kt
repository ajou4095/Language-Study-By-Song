package com.ray.language.domain.repository

import com.ray.language.domain.music.information.LyricsInformation
import kotlinx.coroutines.flow.Flow

interface MusixMatchRepository {
    fun getLyricsByMatcher(
        title: String,
        artist: String
    ): Flow<LyricsInformation>
}
