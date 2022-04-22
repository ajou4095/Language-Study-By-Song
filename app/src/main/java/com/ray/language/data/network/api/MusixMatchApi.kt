package com.ray.language.data.network.api

import com.ray.language.data.model.musixmatch.LyricsRes
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MusixMatchApi {
    @GET("/ws/1.1/matcher.lyrics.get")
    suspend fun getLyricsByMatcher(
        @Query("apikey") apiKey: String,
        @Query("q_track") title: String,
        @Query("q_artist") artist: String
    ): ApiResponse<LyricsRes>
}