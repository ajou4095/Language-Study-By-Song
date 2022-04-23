package com.ray.language.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.common.util.livedata.Event
import com.ray.language.presentation.ui.main.view.tab.MainTabContract
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _event = MutableLiveData<Event<MainViewEvent>>()
    val event: LiveData<Event<MainViewEvent>>
        get() = _event

    fun onTabClick(position: Int) {
        when (position) {
            MainTabContract.TAB_STUDY -> {
                _event.value = Event(MainViewEvent.Study)
            }
            MainTabContract.TAB_EXAM -> {
                _event.value = Event(MainViewEvent.Exam)
            }
            MainTabContract.TAB_SETTINGS -> {
                _event.value = Event(MainViewEvent.Settings)
            }
        }
    }
}