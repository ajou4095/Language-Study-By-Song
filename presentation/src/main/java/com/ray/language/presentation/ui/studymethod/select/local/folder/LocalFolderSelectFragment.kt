package com.ray.language.presentation.ui.studymethod.select.local.folder

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.databinding.FragmentLocalFolderSelectBinding
import com.ray.language.presentation.ui.studymethod.select.local.LocalMusicViewModel
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
                    activityViewModel.selectDirectory(it)
                }
            }
        }
    }
}
