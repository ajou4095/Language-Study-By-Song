package com.ray.language.presentation.ui.main.home.exam

sealed interface ExamState {
    sealed interface Init : ExamState {
        object Request : Init
        object Loading : Init
        object Success : Init
        object Fail : Init
    }
}
