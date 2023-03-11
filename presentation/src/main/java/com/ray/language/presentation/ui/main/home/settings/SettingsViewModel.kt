package com.ray.language.presentation.ui.main.home.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableLiveData<Event<SettingsState>>()
    val state: LiveData<Event<SettingsState>>
        get() = _state

    private val _event = MutableLiveData<Event<SettingsViewEvent>>()
    val event: LiveData<Event<SettingsViewEvent>>
        get() = _event

    init {
        _state.value = Event(SettingsState.Init.Request)
    }

    fun initialize() {

    }

    fun onConfirm() {

    }
}
