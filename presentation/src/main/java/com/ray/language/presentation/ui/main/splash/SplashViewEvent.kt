package com.ray.language.presentation.ui.main.splash

sealed interface SplashViewEvent {
    object AnimationEnd : SplashViewEvent
}
