package com.ray.language.data.di

import android.content.Context
import com.ray.language.data.remote.network.api.MusixMatchApi
import com.ray.language.data.repository.LocalMusicRepositoryImpl
import com.ray.language.data.repository.MusixMatchRepositoryImpl
import com.ray.language.domain.repository.LocalMusicRepository
import com.ray.language.domain.repository.MusixMatchRepository
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
        return MusixMatchRepositoryImpl(musixMatchApi)
    }

    @Provides
    @Singleton
    fun provideLocalMusicRepository(
        @ApplicationContext context: Context
    ): LocalMusicRepository {
        return LocalMusicRepositoryImpl(context.contentResolver)
    }
}
