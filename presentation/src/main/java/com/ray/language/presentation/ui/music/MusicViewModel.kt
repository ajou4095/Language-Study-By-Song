package com.ray.language.presentation.ui.music

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.common.event.Event
import com.ray.language.domain.music.Music
import com.ray.language.domain.music.MusicLyricSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableLiveData<Event<MusicState>>()
    val state: LiveData<Event<MusicState>>
        get() = _state

    private val _event = MutableLiveData<Event<MusicViewEvent>>()
    val event: LiveData<Event<MusicViewEvent>>
        get() = _event

    private val _isPlaying = MutableLiveData<Boolean>(false)
    val isPlaying: LiveData<Boolean>
        get() = _isPlaying

    val music: Music = Music(
        id = 0,
        title = "イエスタデイ",
        artist = "오피셜히게단디즘",
        thumbnailUri = "https://lh3.googleusercontent.com/D0He9E2VSSqj-0waH0t1jHhaG4NBM3UAn32JsHmOBoO5WN1uhRbF9Z493ShfBAhiaErtO7L2g3CrdkQ=w544-h544-l90-rj",
        musicUri = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
        duration = 0,
        lyrics = listOf(
            MusicLyricSentence(
                lyricsBody = "何度失ったって 取り返してみせるよ",
                matchedWords = listOf(
                    "何度",
                    "失う",
                    "取り返す",
                    "みせる"
                )
            ),
            MusicLyricSentence(
                lyricsBody = "雨上がり 虹がかかった空みたいな君の笑みを",
                matchedWords = listOf(
                    "雨上がり",
                    "虹",
                    "空",
                    "君",
                    "笑み"
                )
            ),
            MusicLyricSentence(
                lyricsBody = "例えばその代償に 誰かの表情を",
                matchedWords = listOf(
                    "例えば",
                    "代償",
                    "誰か",
                    "表情"
                )
            ),
            MusicLyricSentence(
                lyricsBody = "曇らせてしまったっていい",
                matchedWords = listOf(
                    "曇らせる ",
                    "しまう"
                )
            ),
            MusicLyricSentence(
                lyricsBody = "悪者は僕だけでいい",
                matchedWords = listOf(
                    "悪者",
                    "僕"
                )
            )
        )
    )

    init {
        _state.value = Event(MusicState.Init.Request)
    }

    fun initialize() {

    }

    fun onPlay() {
        _isPlaying.value = isPlaying.value == false
    }

    fun onSkipLyricsNext() {

    }

    fun onSkipLyricsPrevious() {

    }

    fun onSkipSongNext() {

    }

    fun onSkipSongPrevious() {

    }
}
