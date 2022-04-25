package com.ray.language.presentation.ui.study.select.local.file

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.domain.model.music.MusicInformationDirectory
import com.ray.language.presentation.helper.study.select.local.file.LocalMusicSelectFragmentHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalMusicSelectViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val directory: MusicInformationDirectory by lazy {
        LocalMusicSelectFragmentHelper.getDirectory(savedStateHandle)
    }
}