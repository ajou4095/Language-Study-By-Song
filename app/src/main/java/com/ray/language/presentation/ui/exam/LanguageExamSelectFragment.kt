package com.ray.language.presentation.ui.exam

import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentLanguageExamSelectBinding
import com.ray.language.databinding.FragmentStudyMethodSelectBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import com.ray.language.presentation.ui.study.StudyMethodSelectViewModel
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