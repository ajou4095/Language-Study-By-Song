package com.ray.language.di

import com.ray.language.data.network.api.MusixMatchApi
import com.ray.language.data.repository.MusixMatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMusixMatchRepository(
        musixMatchApi: MusixMatchApi
    ): MusixMatchRepository {
        return MusixMatchRepository(musixMatchApi)
    }
}