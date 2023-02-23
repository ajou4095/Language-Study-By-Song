package com.ray.language.data.remote.network.model

import com.ray.language.data.mapper.DataMapper
import com.ray.language.domain.music.information.LyricsInformation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LyricsRes(
    @SerialName("message")
    val message: LyricsResMessage = LyricsResMessage()
) : DataMapper<LyricsInformation> {
    override fun toDomain(): LyricsInformation {
        return LyricsInformation(
            lyricsId = message.body.lyrics.lyricsId,
            lyricsBody = message.body.lyrics.lyricsBody
        )
    }
}

@Serializable
data class LyricsResMessage(
    @SerialName("body")
    val body: LyricsResBody = LyricsResBody()
)

@Serializable
data class LyricsResBody(
    @SerialName("lyrics")
    val lyrics: LyricsResLyrics = LyricsResLyrics()
)

@Serializable
data class LyricsResLyrics(
    @SerialName("lyrics_id")
    val lyricsId: Int = 0,

    @SerialName("lyrics_body")
    val lyricsBody: String = ""
)
