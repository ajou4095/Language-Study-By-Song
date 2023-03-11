package com.ray.language.presentation.ui.main.home.studymethod.select.self

sealed interface SelfMusicSelectViewEvent {
    object Confirm : SelfMusicSelectViewEvent
    object EmptyTitle : SelfMusicSelectViewEvent
}
