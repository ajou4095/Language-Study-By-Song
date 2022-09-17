package com.ray.language.presentation.studymethod.select.self

import android.view.inputmethod.EditorInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.core.common.util.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelfMusicSelectViewModel @Inject constructor() : ViewModel() {
    private val _event = MutableLiveData<Event<SelfMusicSelectViewEvent>>()
    val event: LiveData<Event<SelfMusicSelectViewEvent>>
        get() = _event

    val title: MutableLiveData<String> = MutableLiveData()

    private val _isTitleErrorEnabled = MutableLiveData<Boolean>()
    val isTitleErrorEnabled: LiveData<Boolean>
        get() = _isTitleErrorEnabled

    val artist: MutableLiveData<String> = MutableLiveData()

    init {
        title.value = ""
        artist.value = ""
        _isTitleErrorEnabled.value = false
    }

    fun onArtistEditorAction(actionId: Int): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            onConfirm()
        }
        return false
    }

    fun onConfirm() {
        when {
            title.value.isNullOrEmpty() -> {
                _isTitleErrorEnabled.value = true
                _event.value = Event(SelfMusicSelectViewEvent.EmptyTitle)
            }
            else -> {
                _event.value = Event(SelfMusicSelectViewEvent.Confirm)
            }
        }
    }
}