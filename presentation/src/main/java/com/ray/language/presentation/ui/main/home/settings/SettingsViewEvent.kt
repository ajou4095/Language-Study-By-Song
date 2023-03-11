package com.ray.language.presentation.ui.main.home.settings

sealed interface SettingsViewEvent {
    object Confirm : SettingsViewEvent
}
