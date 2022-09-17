package com.ray.language.presentation.studymethod.select.local.detail

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.ray.language.core.common.util.getBundle
import com.ray.language.domain.model.music.information.MusicInformation

object LocalMusicDetailFragmentHelper {
    private const val BUNDLE = "key_BUNDLE"
    private const val MUSIC_INFORMATION = "key_MUSIC_INFORMATION"

    fun newInstance(
        directory: MusicInformation? = null
    ): LocalMusicDetailFragment {
        val args = Bundle().apply {
            putParcelable(MUSIC_INFORMATION, directory)
        }
        val fragment = LocalMusicDetailFragment().apply {
            arguments = Bundle().also {
                it.putBundle(BUNDLE, args)
            }
        }
        return fragment
    }

    fun getBundle(savedStateHandle: SavedStateHandle): Bundle? {
        return savedStateHandle.getBundle(BUNDLE)
    }

    fun getMusicInformation(bundle: Bundle?): MusicInformation {
        return bundle?.getParcelable(MUSIC_INFORMATION) ?: MusicInformation.default
    }
}