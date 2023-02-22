package com.ray.language.presentation.ui.studymethod.select.local.detail

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.common.event.Event
import com.ray.language.domain.music.information.MusicInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalMusicDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val bundle: Bundle? by lazy {
        LocalMusicDetailFragmentHelper.getBundle(savedStateHandle)
    }

    val musicInformation: MusicInformation by lazy {
        LocalMusicDetailFragmentHelper.getMusicInformation(bundle)
    }

    private val _event = MutableLiveData<Event<LocalMusicDetailViewEvent>>()
    val event: LiveData<Event<LocalMusicDetailViewEvent>>
        get() = _event

    val title: MutableLiveData<String> = MutableLiveData()

    val artist: MutableLiveData<String> = MutableLiveData()

    init {
        title.value = musicInformation.title
        artist.value = musicInformation.artist
    }

    fun onArtistEditorAction(actionId: Int): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            onConfirmClick()
            return true
        }
        return false
    }

    fun onConfirmClick() {
        _event.value = Event(LocalMusicDetailViewEvent.Confirm)
    }
}
