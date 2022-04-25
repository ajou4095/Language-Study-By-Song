package com.ray.language.presentation.ui.study.select.local

sealed interface LocalMusicViewEvent {
    object FolderSelect : LocalMusicViewEvent
    object MusicSelect : LocalMusicViewEvent
    object MusicDetailCheck : LocalMusicViewEvent
}