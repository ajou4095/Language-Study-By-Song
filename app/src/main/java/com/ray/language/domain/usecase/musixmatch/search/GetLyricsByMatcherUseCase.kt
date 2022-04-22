package com.ray.language.domain.usecase.musixmatch.search

import com.ray.language.data.network.api.MusixMatchApi
import com.ray.language.domain.model.music.LyricsInformation
import com.ray.language.domain.usecase.musixmatch.GetMusixMatchApiUseCase
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetLyricsByMatcherUseCase @Inject constructor(
    private val musixMatchApi: MusixMatchApi,
    private val getMusixMatchApiUseCase: GetMusixMatchApiUseCase
) {
    suspend operator fun invoke(
        title: String,
        artist: String
    ): LyricsInformation {
        val data = musixMatchApi.getLyricsByMatcher(getMusixMatchApiUseCase(), title, artist)

        return LyricsInformation(
            lyricsId = data.message.body.lyrics.lyricsId,
            lyricsBody = data.message.body.lyrics.lyricsBody
        )
    }
}