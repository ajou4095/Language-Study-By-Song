package com.ray.language.presentation.ui.studymethod

sealed interface StudyMethodViewEvent {
    object LocalMusic : StudyMethodViewEvent
    object YoutubeMusic : StudyMethodViewEvent
    object PopularMusic : StudyMethodViewEvent
    object SelfMusic : StudyMethodViewEvent
    object KanjiSearch : StudyMethodViewEvent
}