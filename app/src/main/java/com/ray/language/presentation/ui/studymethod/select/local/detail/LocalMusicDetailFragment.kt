package com.ray.language.presentation.ui.studymethod.select.local.detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.ray.language.core.common.util.eventObserve
import com.ray.language.databinding.FragmentLocalMusicDetailBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import com.ray.language.presentation.ui.studymethod.select.local.LocalMusicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalMusicDetailFragment : BaseFragment<FragmentLocalMusicDetailBinding>(FragmentLocalMusicDetailBinding::inflate) {
    private val viewModel: LocalMusicDetailViewModel by viewModels()

    private val activityViewModel: LocalMusicViewModel by activityViewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                LocalMusicDetailViewEvent.Confirm -> {
                    activityViewModel.musicDetailCheckFinished(
                        viewModel.title.value ?: viewModel.musicInformation.title,
                        viewModel.artist.value ?: viewModel.musicInformation.artist
                    )
                }
            }
        }
    }
}