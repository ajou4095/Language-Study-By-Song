package com.ray.language.design.window.modal.alert

internal sealed interface AlertDialogViewEvent {
    object OnCancel : AlertDialogViewEvent
    object OnConfirm : AlertDialogViewEvent
}