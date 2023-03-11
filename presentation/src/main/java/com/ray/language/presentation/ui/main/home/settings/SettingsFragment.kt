package com.ray.language.presentation.ui.main.home.settings

import androidx.fragment.app.viewModels
import com.ray.language.common.eventObserve
import com.ray.language.presentation.databinding.FragmentSettingsBinding
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.common.error.ErrorDialogContent
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    private val viewModel: SettingsViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        fun initialize(state: SettingsState.Init) {
            when (state) {
                SettingsState.Init.Request -> {
                    viewModel.initialize()
                }
                SettingsState.Init.Loading -> {
                    showLoading()
                }
                SettingsState.Init.Success -> {
                    hideLoading()
                }
                SettingsState.Init.Fail -> {
                    hideLoading()

                    AlertDialogFragmentProvider.makeAlertDialog(
                        title = ErrorDialogContent.UnknownError.title,
                        message = ErrorDialogContent.UnknownError.message
                    ).show()
                }
            }
        }

        viewModel.state.eventObserve(viewLifecycleOwner) { state ->
            when (state) {
                is SettingsState.Init -> {
                    initialize(state)
                }
            }
        }

        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                is SettingsViewEvent.Confirm -> {

                }
            }
        }
    }
}
