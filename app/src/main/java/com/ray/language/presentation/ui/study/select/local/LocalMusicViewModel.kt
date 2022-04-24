package com.ray.language.presentation.ui.study.select.local

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.language.domain.model.music.MusicInformationDirectory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalMusicViewModel @Inject constructor() : ViewModel() {
    var selectedDirectory = MutableLiveData<MusicInformationDirectory>()
}