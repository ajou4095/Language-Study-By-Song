package com.ray.language.presentation.studymethod

sealed interface StudyMethodViewEvent {
    object LocalMusic : StudyMethodViewEvent
    object YoutubeMusic : StudyMethodViewEvent
    object PopularMusic : StudyMethodViewEvent
    object SelfMusic : StudyMethodViewEvent
    object KanjiSearch : StudyMethodViewEvent
}