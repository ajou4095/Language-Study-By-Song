package com.ray.language.presentation.helper.study.select.local.file

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.ray.language.domain.model.music.MusicInformationDirectory
import com.ray.language.presentation.ui.study.select.local.file.LocalMusicSelectFragment

object LocalMusicSelectFragmentHelper {
    private const val DIRECTORY = "key_DIRECTORY"

    fun newInstance(
        directory: MusicInformationDirectory? = null
    ): LocalMusicSelectFragment {
        val args = Bundle().apply {
            putParcelable(DIRECTORY, directory)
        }
        val fragment = LocalMusicSelectFragment().apply {
            arguments = args
        }
        return fragment
    }

    fun getDirectory(savedStateHandle: SavedStateHandle): MusicInformationDirectory {
        return savedStateHandle.get<MusicInformationDirectory>(DIRECTORY) ?: MusicInformationDirectory.default
    }
}