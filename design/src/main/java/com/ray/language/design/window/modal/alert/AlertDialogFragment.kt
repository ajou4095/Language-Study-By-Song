package com.ray.language.design.window.modal.alert

import androidx.fragment.app.viewModels
import com.ray.language.core.common.util.eventObserve
import com.ray.language.design.common.base.BaseDialogFragment
import com.ray.language.design.databinding.ViewAlertDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class AlertDialogFragment : BaseDialogFragment<ViewAlertDialogBinding>(ViewAlertDialogBinding::inflate) {
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
                    dismiss()
                }
                AlertDialogViewEvent.OnConfirm -> {
                    onConfirm?.invoke()
                    dismiss()
                }
            }
        }
    }
}