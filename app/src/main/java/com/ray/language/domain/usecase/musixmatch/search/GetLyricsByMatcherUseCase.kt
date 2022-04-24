package com.ray.language.domain.usecase.musixmatch.search

import com.ray.language.data.repository.MusixMatchRepository
import com.ray.language.domain.model.music.LyricsInformation
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@Reusable
class GetLyricsByMatcherUseCase @Inject constructor(
    private val musixMatchRepository: MusixMatchRepository
) {
    operator fun invoke(
        title: String,
        artist: String
    ) = flow {
        val lyricsResponse = musixMatchRepository.getLyricsByMatcher(title, artist)

        lyricsResponse.suspendOnSuccess {
            emit(
                LyricsInformation(
                    lyricsId = data.message.body.lyrics.lyricsId,
                    lyricsBody = data.message.body.lyrics.lyricsBody
                )
            )
        }.suspendOnFailure {
            emit(null)
        }
    }.flowOn(Dispatchers.IO)
}