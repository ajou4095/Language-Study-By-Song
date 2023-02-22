package com.ray.language.data.api

import com.ray.language.data.musixmatch.LyricsRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusixMatchApi {
    @GET("/ws/1.1/matcher.lyrics.get")
    suspend fun getLyricsByMatcher(
        @Query("apikey") apiKey: String,
        @Query("q_track") title: String,
        @Query("q_artist") artist: String
    ): Response<LyricsRes>
}
