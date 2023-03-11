package com.ray.language.presentation.ui.music

import androidx.fragment.app.viewModels
import com.ray.language.common.eventObserve
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.common.error.ErrorDialogContent
import com.ray.language.presentation.databinding.FragmentMusicBinding
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicFragment : BaseFragment<FragmentMusicBinding>(FragmentMusicBinding::inflate) {
    private val viewModel: MusicViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner

            lyrics.adapter = MusicListAdapter()
        }
    }

    override fun initObserver() {
        fun initialize(state: MusicState.Init) {
            when (state) {
                MusicState.Init.Request -> {
                    viewModel.initialize()
                }
                MusicState.Init.Loading -> {
                    showLoading()
                }
                MusicState.Init.Success -> {
                    hideLoading()
                }
                MusicState.Init.Fail -> {
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
                is MusicState.Init -> {
                    initialize(state)
                }
            }
        }

        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                is MusicViewEvent.Confirm -> {

                }
            }
        }
    }
}
