package com.ray.language.domain.usecase.music.list

import com.ray.language.data.repository.LocalMusicRepository
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@Reusable
class GetMusicListUseCase @Inject constructor(
    private val localMusicRepository: LocalMusicRepository
) {
    operator fun invoke() = flow {
        emit(localMusicRepository.getMusicsInformation())
    }.flowOn(Dispatchers.IO)
}