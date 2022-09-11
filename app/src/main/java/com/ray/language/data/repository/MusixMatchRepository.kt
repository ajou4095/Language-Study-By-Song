package com.ray.language.data.repository

import com.ray.language.BuildConfig
import com.ray.language.data.model.musixmatch.LyricsRes
import com.ray.language.data.network.api.MusixMatchApi
import com.skydoves.sandwich.ApiResponse

// TODO : 추상화
class MusixMatchRepository(
    private val musixMatchApi: MusixMatchApi
) {
    private val apiKey = BuildConfig.MUSIX_MATCH_API_KEY

    suspend fun getLyricsByMatcher(
        title: String,
        artist: String
    ): ApiResponse<LyricsRes> {
        return musixMatchApi.getLyricsByMatcher(apiKey, title, artist)
    }
}