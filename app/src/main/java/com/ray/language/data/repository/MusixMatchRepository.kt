package com.ray.language.data.repository

import com.ray.language.BuildConfig
import com.ray.language.data.network.api.MusixMatchApi
import com.ray.language.domain.model.music.information.LyricsInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

// TODO : 추상화
class MusixMatchRepository(
    private val musixMatchApi: MusixMatchApi
) {
    private val apiKey = BuildConfig.MUSIX_MATCH_API_KEY

    fun getLyricsByMatcher(
        title: String,
        artist: String
    ): Flow<LyricsInformation> = flow {
        val response = musixMatchApi.getLyricsByMatcher(apiKey, title, artist)
        emit(response.body()?.toDomain() ?: LyricsInformation())
    }.flowOn(Dispatchers.IO)
}