package com.ray.language.presentation.common.error

sealed interface ErrorDialogContent {
    val title: String
    val message: String

    object UnknownError : ErrorDialogContent {
        override val title: String = "에러 발생"
        override val message: String = "알 수 없는 에러가 발생했습니다."
    }
}
