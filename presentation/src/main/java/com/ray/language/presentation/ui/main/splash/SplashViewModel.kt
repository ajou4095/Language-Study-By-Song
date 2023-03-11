package com.ray.language.presentation.ui.main.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ray.language.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableLiveData<Event<SplashState>>()
    val state: LiveData<Event<SplashState>>
        get() = _state

    private val _event = MutableLiveData<Event<SplashViewEvent>>()
    val event: LiveData<Event<SplashViewEvent>>
        get() = _event

    init {
        _state.value = Event(SplashState.Init.Request)
    }

    fun initialize() {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                delay(2500L)
            }
            _state.value = Event(SplashState.Init.Success)
        }
    }

    fun onAnimationEnd() {
        _event.value = Event(SplashViewEvent.AnimationEnd)
    }
}
