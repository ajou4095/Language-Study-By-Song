package com.ray.language.design.common.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ray.language.core.presentation.util.TAG
import com.ray.language.design.window.modal.alert.AlertDialogFragmentContract
import com.ray.language.design.window.modal.alert.AlertDialogFragmentHelper

fun AppCompatActivity.showDialog(
    title: String? = null,
    message: String? = null,
    isTwoButton: Boolean = false,
    cancelMessage: String? = AlertDialogFragmentContract.STRING_CANCEL,
    confirmMessage: String? = AlertDialogFragmentContract.STRING_CONFIRM,
    onCancel: (() -> Unit)? = null,
    onConfirm: (() -> Any)? = null
) {
    AlertDialogFragmentHelper.newInstance(
        title = title,
        message = message,
        isTwoButton = isTwoButton,
        cancelMessage = cancelMessage,
        confirmMessage = confirmMessage,
        onCancel = onCancel,
        onConfirm = onConfirm
    ).show(supportFragmentManager, TAG)
}

fun Fragment.showDialog(
    title: String? = null,
    message: String? = null,
    isTwoButton: Boolean = false,
    cancelMessage: String? = AlertDialogFragmentContract.STRING_CANCEL,
    confirmMessage: String? = AlertDialogFragmentContract.STRING_CONFIRM,
    onCancel: (() -> Unit)? = null,
    onConfirm: (() -> Any)? = null
) {
    AlertDialogFragmentHelper.newInstance(
        title = title,
        message = message,
        isTwoButton = isTwoButton,
        cancelMessage = cancelMessage,
        confirmMessage = confirmMessage,
        onCancel = onCancel,
        onConfirm = onConfirm
    ).show(parentFragmentManager, tag)
}