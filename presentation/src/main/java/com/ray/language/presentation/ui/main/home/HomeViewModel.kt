package com.ray.language.presentation.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableLiveData<Event<HomeState>>()
    val state: LiveData<Event<HomeState>>
        get() = _state

    private val _event = MutableLiveData<Event<HomeViewEvent>>()
    val event: LiveData<Event<HomeViewEvent>>
        get() = _event

    private val _tabPosition = MutableLiveData<Int>(0)
    val tabPosition: LiveData<Int>
        get() = _tabPosition

    init {
        _state.value = Event(HomeState.Init.Request)
    }

    fun initialize() {

    }

    fun onTabClick(position: Int) {
        _tabPosition.value = position
    }
}
