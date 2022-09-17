package com.ray.language.presentation.exam

import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentLanguageExamSelectBinding
import com.ray.language.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LanguageExamSelectFragment : BaseFragment<FragmentLanguageExamSelectBinding>(FragmentLanguageExamSelectBinding::inflate) {
    private val viewModel: LanguageExamSelectViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}