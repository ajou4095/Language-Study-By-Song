package com.ray.language.presentation.ui.studymethod.select.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.core.common.util.event.Event
import com.ray.language.domain.model.music.MusicInformationDirectory
import com.ray.language.domain.model.music.information.MusicInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalMusicViewModel @Inject constructor() : ViewModel() {
    var selectedDirectory: MusicInformationDirectory? = null
        private set

    var selectedMusicInformation: MusicInformation? = null
        private set

    var selectedTitle: String = ""
        private set

    var selectedArtist: String = ""
        private set

    private val _event = MutableLiveData<Event<LocalMusicViewEvent>>()
    val event: LiveData<Event<LocalMusicViewEvent>>
        get() = _event

    fun selectDirectory(directory: MusicInformationDirectory) {
        selectedDirectory = directory
        _event.value = Event(LocalMusicViewEvent.FolderSelect)
    }

    fun selectMusic(musicInformation: MusicInformation) {
        selectedMusicInformation = musicInformation
        _event.value = Event(LocalMusicViewEvent.MusicSelect)
    }

    fun musicDetailCheckFinished(
        title: String,
        artist: String
    ) {
        selectedTitle = title
        selectedArtist = artist
        _event.value = Event(LocalMusicViewEvent.MusicDetailCheck)
    }
}