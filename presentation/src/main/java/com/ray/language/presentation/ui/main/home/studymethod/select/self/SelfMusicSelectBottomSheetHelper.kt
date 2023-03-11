package com.ray.language.presentation.ui.main.home.studymethod.select.self

object SelfMusicSelectBottomSheetHelper {
    fun newInstance(
        onConfirm: ((title: String, artist: String) -> Unit)? = null
    ): SelfMusicSelectBottomSheet {
        return SelfMusicSelectBottomSheet().apply {
            this.onConfirm = onConfirm
        }
    }
}
