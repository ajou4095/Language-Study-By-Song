package com.ray.language.presentation.studymethod.select.local.file

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.ray.language.core.common.util.getBundle
import com.ray.language.domain.model.music.MusicInformationDirectory

object LocalMusicSelectFragmentHelper {
    private const val BUNDLE = "key_BUNDLE"
    private const val DIRECTORY = "key_DIRECTORY"

    fun newInstance(
        directory: MusicInformationDirectory? = null
    ): LocalMusicSelectFragment {
        val args = Bundle().apply {
            putParcelable(DIRECTORY, directory)
        }
        val fragment = LocalMusicSelectFragment().apply {
            arguments = Bundle().also {
                it.putBundle(BUNDLE, args)
            }
        }
        return fragment
    }

    fun getBundle(savedStateHandle: SavedStateHandle): Bundle? {
        return savedStateHandle.getBundle(BUNDLE)
    }

    fun getDirectory(bundle: Bundle?): MusicInformationDirectory {
        return bundle?.getParcelable(DIRECTORY) ?: MusicInformationDirectory.default
    }
}