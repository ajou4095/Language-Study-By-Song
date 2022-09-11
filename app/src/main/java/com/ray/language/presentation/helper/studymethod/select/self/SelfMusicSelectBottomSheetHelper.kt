package com.ray.language.presentation.helper.studymethod.select.self

import com.ray.language.presentation.ui.studymethod.select.self.SelfMusicSelectBottomSheet

object SelfMusicSelectBottomSheetHelper {
    fun newInstance(
        onConfirm: ((title: String, artist: String) -> Unit)? = null
    ): SelfMusicSelectBottomSheet {
        return SelfMusicSelectBottomSheet().apply {
            this.onConfirm = onConfirm
        }
    }
}