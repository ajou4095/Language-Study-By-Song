package com.ray.language.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.common.event.Event
import com.ray.language.presentation.ui.main.view.tab.MainTabContract
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _event = MutableLiveData<Event<MainViewEvent>>()
    val event: LiveData<Event<MainViewEvent>>
        get() = _event

    private var currentPosition: Int = -1

    fun onTabClick(newPosition: Int) {
        if (newPosition == currentPosition) return

        val leftToRight = newPosition > currentPosition
        currentPosition = newPosition

        when (newPosition) {
            MainTabContract.TAB_STUDY -> {
                _event.value = Event(MainViewEvent.Study(leftToRight))
            }
            MainTabContract.TAB_EXAM -> {
                _event.value = Event(MainViewEvent.Exam(leftToRight))
            }
            MainTabContract.TAB_SETTINGS -> {
                _event.value = Event(MainViewEvent.Settings(leftToRight))
            }
        }
    }
}
