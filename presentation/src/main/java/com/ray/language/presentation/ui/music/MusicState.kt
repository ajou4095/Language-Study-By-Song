package com.ray.language.presentation.ui.music

sealed interface MusicState {
    sealed interface Init : MusicState {
        object Request : Init
        object Loading : Init
        object Success : Init
        object Fail : Init
    }
}
