package com.ray.language.presentation.ui.settings

import androidx.fragment.app.viewModels
import com.ray.language.databinding.FragmentSettingsBinding
import com.ray.language.databinding.FragmentStudyMethodSelectBinding
import com.ray.language.presentation.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    private val viewModel: SettingsViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}