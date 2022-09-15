package com.ray.language.presentation.ui.common.modal.alert

import androidx.fragment.app.viewModels
import com.ray.language.core.common.util.eventObserve
import com.ray.language.databinding.ViewAlertDialogBinding
import com.ray.language.presentation.ui.common.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlertDialogFragment : BaseDialogFragment<ViewAlertDialogBinding>(ViewAlertDialogBinding::inflate) {
    private val viewModel: AlertDialogViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                AlertDialogViewEvent.OnCancel -> {
                    onCancel?.invoke()
                    //dismiss()
                    dismissAllowingStateLoss()
                }
                AlertDialogViewEvent.OnConfirm -> {
                    onConfirm?.invoke()
                    //dismiss()
                    dismissAllowingStateLoss()
                }
            }
        }
    }
}