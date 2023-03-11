package com.ray.language.presentation.ui.main.home

sealed interface HomeState {
    sealed interface Init : HomeState {
        object Request : Init
        object Loading : Init
        object Success : Init
        object Fail : Init
    }
}
