package com.ray.language.presentation.ui.study

sealed interface StudyMethodViewEvent {
    object MUSIC_LOCAL: StudyMethodViewEvent
    object MUSIC_YOUTUBE: StudyMethodViewEvent
    object MUSIC_POPULAR: StudyMethodViewEvent
    object MUSIC_SEARCH: StudyMethodViewEvent
    object KANJI_SEARCH: StudyMethodViewEvent
}