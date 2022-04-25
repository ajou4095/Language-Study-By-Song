package com.ray.language.presentation.helper.study.select.local.detail

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.ray.language.domain.model.music.information.MusicInformation
import com.ray.language.presentation.ui.study.select.local.detail.LocalMusicDetailFragment

object LocalMusicDetailFragmentHelper {
    private const val MUSIC_INFORMATION = "key_MUSIC_INFORMATION"

    fun newInstance(
        directory: MusicInformation? = null
    ): LocalMusicDetailFragment {
        val args = Bundle().apply {
            putParcelable(MUSIC_INFORMATION, directory)
        }
        val fragment = LocalMusicDetailFragment().apply {
            arguments = args
        }
        return fragment
    }

    fun getMusicInformation(savedStateHandle: SavedStateHandle): MusicInformation {
        return savedStateHandle.get<MusicInformation>(MUSIC_INFORMATION) ?: MusicInformation.default
    }
}