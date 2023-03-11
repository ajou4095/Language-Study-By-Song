package com.ray.language.presentation.ui.main.home.exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableLiveData<Event<ExamState>>()
    val state: LiveData<Event<ExamState>>
        get() = _state

    private val _event = MutableLiveData<Event<ExamViewEvent>>()
    val event: LiveData<Event<ExamViewEvent>>
        get() = _event

    init {
        _state.value = Event(ExamState.Init.Request)
    }

    fun initialize() {

    }

    fun onConfirm() {

    }
}
