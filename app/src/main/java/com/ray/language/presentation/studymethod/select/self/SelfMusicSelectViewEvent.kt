package com.ray.language.presentation.studymethod.select.self

sealed interface SelfMusicSelectViewEvent {
    object Confirm : SelfMusicSelectViewEvent
    object EmptyTitle : SelfMusicSelectViewEvent
}