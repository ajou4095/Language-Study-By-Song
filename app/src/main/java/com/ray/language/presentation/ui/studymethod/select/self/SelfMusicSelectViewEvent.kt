package com.ray.language.presentation.ui.studymethod.select.self

sealed interface SelfMusicSelectViewEvent {
    object Confirm : SelfMusicSelectViewEvent
    object EmptyTitle : SelfMusicSelectViewEvent
}