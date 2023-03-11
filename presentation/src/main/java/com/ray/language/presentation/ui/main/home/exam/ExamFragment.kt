package com.ray.language.presentation.ui.main.home.exam

import androidx.fragment.app.viewModels
import com.ray.language.common.eventObserve
import com.ray.language.presentation.databinding.FragmentExamBinding
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.common.error.ErrorDialogContent
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExamFragment : BaseFragment<FragmentExamBinding>(FragmentExamBinding::inflate) {
    private val viewModel: ExamViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        fun initialize(state: ExamState.Init) {
            when (state) {
                ExamState.Init.Request -> {
                    viewModel.initialize()
                }
                ExamState.Init.Loading -> {
                    showLoading()
                }
                ExamState.Init.Success -> {
                    hideLoading()
                }
                ExamState.Init.Fail -> {
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
                is ExamState.Init -> {
                    initialize(state)
                }
            }
        }

        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                is ExamViewEvent.Confirm -> {

                }
            }
        }
    }
}
