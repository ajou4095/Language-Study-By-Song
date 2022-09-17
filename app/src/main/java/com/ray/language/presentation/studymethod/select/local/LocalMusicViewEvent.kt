package com.ray.language.presentation.studymethod.select.local

sealed interface LocalMusicViewEvent {
    object FolderSelect : LocalMusicViewEvent
    object MusicSelect : LocalMusicViewEvent
    object MusicDetailCheck : LocalMusicViewEvent
}