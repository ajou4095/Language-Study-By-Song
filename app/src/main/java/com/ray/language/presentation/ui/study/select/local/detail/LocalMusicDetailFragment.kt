package com.ray.language.presentation.ui.study.select.local.detail

import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentLocalMusicDetailBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalMusicDetailFragment : BaseFragment<FragmentLocalMusicDetailBinding>(FragmentLocalMusicDetailBinding::inflate) {
    private val viewModel: LocalMusicDetailViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}