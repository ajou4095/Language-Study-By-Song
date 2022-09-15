package com.ray.language.presentation.ui.studymethod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.core.common.util.event.Event
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

    fun selectMusicBySelf() {
        _event.value = Event(StudyMethodViewEvent.SelfMusic)
    }

    fun selectKanjiBySearch() {
        _event.value = Event(StudyMethodViewEvent.SelfMusic)
    }
}