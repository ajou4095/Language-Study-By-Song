package com.ray.language.presentation.ui.main.splash

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ray.language.common.eventObserve
import com.ray.language.presentation.R
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.common.error.ErrorDialogContent
import com.ray.language.presentation.databinding.FragmentSplashBinding
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    private val viewModel: SplashViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        fun initialize(state: SplashState.Init) {
            when (state) {
                SplashState.Init.Request -> {
                    viewModel.initialize()
                }
                SplashState.Init.Success -> {
                    hideLoading()

                    findNavController().navigate(R.id.action_to_home)
                }
                SplashState.Init.Fail -> {
                    hideLoading()

                    AlertDialogFragmentProvider.makeAlertDialog(
                        title = ErrorDialogContent.UnknownError.title,
                        message = ErrorDialogContent.UnknownError.message,
                        onConfirm = {
                            activity?.finish()
                        },
                    ).apply {
                        isCancelable = false
                    }.show()
                }
            }
        }

        viewModel.state.eventObserve(viewLifecycleOwner) { state ->
            when (state) {
                is SplashState.Init -> {
                    initialize(state)
                }
            }
        }
    }
}
