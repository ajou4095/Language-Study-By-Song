package com.ray.language.presentation.main

sealed interface MainViewEvent {
    data class Study(val leftToRight: Boolean) : MainViewEvent
    data class Exam(val leftToRight: Boolean) : MainViewEvent
    data class Settings(val leftToRight: Boolean) : MainViewEvent
}