package com.ray.language.presentation.ui.study

sealed interface StudyMethodViewEvent {
    object LocalMusic : StudyMethodViewEvent
    object YoutubeMusic : StudyMethodViewEvent
    object PopularMusic : StudyMethodViewEvent
    object MusicSearch : StudyMethodViewEvent
    object KanjiSearch : StudyMethodViewEvent
}