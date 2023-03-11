package com.ray.language.presentation.ui.main.home

import androidx.fragment.app.viewModels
import com.ray.language.common.orZero
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner

            pager.adapter = HomeTabAdapter(this@HomeFragment)
        }
    }

    override fun initObserver() {
        viewModel.tabPosition.observe(viewLifecycleOwner) {
            if (binding.pager.adapter?.itemCount.orZero() > it.orZero()) {
                binding.pager.setCurrentItem(it, true)
            }
        }
    }
}
