package com.ray.language.presentation.ui.main.home.studymethod.select.local.file

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.language.domain.music.MusicInformationDirectory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalMusicSelectViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val bundle: Bundle? by lazy {
        LocalMusicSelectFragmentHelper.getBundle(savedStateHandle)
    }

    val directory: MusicInformationDirectory by lazy {
        LocalMusicSelectFragmentHelper.getDirectory(bundle)
    }
}
