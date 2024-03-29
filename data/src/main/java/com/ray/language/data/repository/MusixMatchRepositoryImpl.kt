package com.ray.language.data.repository

import com.ray.language.data.BuildConfig
import com.ray.language.data.remote.network.api.MusixMatchApi
import com.ray.language.data.remote.network.util.convertResponseToDomain
import com.ray.language.domain.music.information.LyricsInformation
import com.ray.language.domain.repository.MusixMatchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MusixMatchRepositoryImpl(
    private val musixMatchApi: MusixMatchApi
) : MusixMatchRepository {
    private val apiKey = BuildConfig.MUSIX_MATCH_API_KEY

    override fun getLyricsByMatcher(
        title: String,
        artist: String
    ): Flow<LyricsInformation> {
        return flow {
            emit(musixMatchApi.getLyricsByMatcher(apiKey, title, artist))
        }
            .convertResponseToDomain()
            .flowOn(Dispatchers.IO)
    }
}
