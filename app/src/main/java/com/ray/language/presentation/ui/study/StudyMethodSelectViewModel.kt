package com.ray.language.presentation.ui.study

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.common.util.livedata.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudyMethodSelectViewModel @Inject constructor() : ViewModel() {

    private val _event = MutableLiveData<Event<StudyMethodViewEvent>>()
    val event: LiveData<Event<StudyMethodViewEvent>>
        get() = _event

    fun selectMusicFromLocal() {
        _event.value = Event(StudyMethodViewEvent.LocalMusic)
    }

    fun selectMusicFromYoutube() {
        _event.value = Event(StudyMethodViewEvent.YoutubeMusic)
    }

    fun selectMusicFromPopularList() {
        _event.value = Event(StudyMethodViewEvent.PopularMusic)
    }

    fun selectMusicBySearch() {
        _event.value = Event(StudyMethodViewEvent.MusicSearch)
    }

    fun selectKanjiBySearch() {
        _event.value = Event(StudyMethodViewEvent.MusicSearch)
    }
}