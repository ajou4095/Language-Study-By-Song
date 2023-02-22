package com.ray.language.data.di

import android.content.Context
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ray.language.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val MUSIC_MATCH_BASE_URL = "https://api.musixmatch.com/"

    private val contentType = "application/json".toMediaType()

    private val json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun provideFlipperClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(
                FlipperOkhttpInterceptor(
                    AndroidFlipperClient.getInstance(context).getPlugin(NetworkFlipperPlugin.ID)
                )
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideMusixMatchRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(MUSIC_MATCH_BASE_URL).apply {
                if (BuildConfig.DEBUG) client(client)
            }.build()
    }
}
