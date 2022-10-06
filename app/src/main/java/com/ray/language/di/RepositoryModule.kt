package com.ray.language.di

import android.content.Context
import com.ray.language.data.network.api.MusixMatchApi
import com.ray.language.data.repository.LocalMusicRepository
import com.ray.language.data.repository.MusixMatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMusixMatchRepository(
        musixMatchApi: MusixMatchApi
    ): MusixMatchRepository {
        return MusixMatchRepository(musixMatchApi)
    }

    @Provides
    @Singleton
    fun provideLocalMusicRepository(
        @ApplicationContext context: Context
    ): LocalMusicRepository {
        return LocalMusicRepository(context.contentResolver)
    }
}