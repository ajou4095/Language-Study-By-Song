package com.ray.language.presentation.ui.main

sealed interface MainViewEvent {
    object Study : MainViewEvent
    object Exam : MainViewEvent
    object Settings : MainViewEvent
}