package com.ray.language.presentation.ui.study.select.local.folder

import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentLocalFolderSelectBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalFolderSelectFragment : BaseFragment<FragmentLocalFolderSelectBinding>(FragmentLocalFolderSelectBinding::inflate) {
    private val viewModel: LocalFolderSelectViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}