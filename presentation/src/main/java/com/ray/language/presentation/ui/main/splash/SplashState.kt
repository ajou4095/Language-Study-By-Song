package com.ray.language.presentation.ui.main.splash

sealed interface SplashState {
    sealed interface Init : SplashState {
        object Request : Init
        object Success : Init
        object Fail : Init
    }
}
