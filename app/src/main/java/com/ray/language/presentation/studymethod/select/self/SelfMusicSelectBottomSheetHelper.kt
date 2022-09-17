package com.ray.language.presentation.studymethod.select.self

object SelfMusicSelectBottomSheetHelper {
    fun newInstance(
        onConfirm: ((title: String, artist: String) -> Unit)? = null
    ): SelfMusicSelectBottomSheet {
        return SelfMusicSelectBottomSheet().apply {
            this.onConfirm = onConfirm
        }
    }
}