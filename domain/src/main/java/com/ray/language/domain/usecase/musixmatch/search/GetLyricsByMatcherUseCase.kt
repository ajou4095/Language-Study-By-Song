package com.ray.language.domain.usecase.musixmatch.search

import com.ray.language.domain.music.information.LyricsInformation
import com.ray.language.domain.repository.MusixMatchRepository
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
