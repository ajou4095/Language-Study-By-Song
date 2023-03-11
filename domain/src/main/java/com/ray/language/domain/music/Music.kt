package com.ray.language.domain.music

data class Music(
    val id: Long,
    val title: String,
    val artist: String,
    val thumbnailUri: String,
    val musicUri: String,
    val duration: Long,
    val lyrics: List<MusicLyricSentence>
)

data class MusicLyricSentence(
    val lyricsBody: String,
    val matchedWords: List<String>
)
