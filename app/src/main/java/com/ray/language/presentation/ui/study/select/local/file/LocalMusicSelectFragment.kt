package com.ray.language.presentation.ui.study.select.local.file

import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentLocalMusicSelectBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalMusicSelectFragment : BaseFragment<FragmentLocalMusicSelectBinding>(FragmentLocalMusicSelectBinding::inflate) {
    private val viewModel: LocalMusicSelectViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}