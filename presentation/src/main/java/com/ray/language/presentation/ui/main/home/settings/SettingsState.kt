package com.ray.language.presentation.ui.main.home.settings

sealed interface SettingsState {
    sealed interface Init : SettingsState {
        object Request : Init
        object Loading : Init
        object Success : Init
        object Fail : Init
    }
}
