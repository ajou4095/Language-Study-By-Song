package com.ray.language.presentation.ui.main.home.studymethod

sealed interface StudyMethodViewEvent {
    object LocalMusic : StudyMethodViewEvent
    object YoutubeMusic : StudyMethodViewEvent
    object PopularMusic : StudyMethodViewEvent
    object SelfMusic : StudyMethodViewEvent
    object KanjiSearch : StudyMethodViewEvent
}
