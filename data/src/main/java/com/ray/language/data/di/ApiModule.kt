package com.ray.language.data.di

import com.ray.language.data.api.MusixMatchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideMusixMatchApi(
        retrofit: Retrofit
    ): MusixMatchApi {
        return retrofit.create(MusixMatchApi::class.java)
    }
}
