package com.ray.language.presentation.ui.main.home.studymethod.select.local

sealed interface LocalMusicViewEvent {
    object FolderSelect : LocalMusicViewEvent
    object MusicSelect : LocalMusicViewEvent
    object MusicDetailCheck : LocalMusicViewEvent
}
