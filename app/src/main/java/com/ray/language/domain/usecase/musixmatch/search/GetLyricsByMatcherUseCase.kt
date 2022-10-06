package com.ray.language.domain.usecase.musixmatch.search

import com.ray.language.data.repository.MusixMatchRepository
import com.ray.language.domain.model.music.information.LyricsInformation
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetLyricsByMatcherUseCase @Inject constructor(
    private val musixMatchRepository: MusixMatchRepository
) {
    operator fun invoke(
        title: String,
        artist: String
    ): Flow<LyricsInformation> {
        return musixMatchRepository.getLyricsByMatcher(title, artist)
    }
}