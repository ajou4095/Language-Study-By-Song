package com.ray.language.presentation.ui.common.util

import com.ray.language.core.presentation.util.TAG
import com.ray.language.presentation.helper.common.modal.alert.AlertDialogFragmentHelper
import com.ray.language.presentation.ui.common.base.BaseActivity
import com.ray.language.presentation.ui.common.base.BaseFragment
import com.ray.language.presentation.ui.common.modal.alert.AlertDialogFragmentContract

fun BaseActivity<*>.showDialog(
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

fun BaseFragment<*>.showDialog(
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