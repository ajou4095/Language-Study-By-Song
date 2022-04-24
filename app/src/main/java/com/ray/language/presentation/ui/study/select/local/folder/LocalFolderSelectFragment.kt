package com.ray.language.presentation.ui.study.select.local.folder

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentLocalFolderSelectBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import com.ray.language.presentation.ui.study.select.local.LocalMusicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalFolderSelectFragment : BaseFragment<FragmentLocalFolderSelectBinding>(FragmentLocalFolderSelectBinding::inflate) {
    private val viewModel: LocalFolderSelectViewModel by viewModels()

    private val activityViewModel: LocalMusicViewModel by activityViewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner

            list.adapter = LocalFolderAdapter().apply {
                onItemClick = {
                    activityViewModel.selectedDirectory.value = it
                }
            }
        }
    }
}