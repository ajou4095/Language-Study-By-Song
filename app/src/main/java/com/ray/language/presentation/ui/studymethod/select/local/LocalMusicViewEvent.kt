package com.ray.language.presentation.ui.studymethod.select.local

sealed interface LocalMusicViewEvent {
    object FolderSelect : LocalMusicViewEvent
    object MusicSelect : LocalMusicViewEvent
    object MusicDetailCheck : LocalMusicViewEvent
}