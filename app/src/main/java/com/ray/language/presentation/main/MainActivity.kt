package com.ray.language.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import com.ray.language.core.common.util.eventObserve
import com.ray.language.core.presentation.util.slideFragment
import com.ray.language.databinding.ActivityMainBinding
import com.ray.language.presentation.exam.LanguageExamSelectFragmentHelper
import com.ray.language.presentation.settings.SettingsFragmentHelper
import com.ray.language.presentation.studymethod.StudyMethodSelectFragmentHelper
import com.ray.language.presentation.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initObserver()
    }

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = this@MainActivity
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(this@MainActivity) { event ->
            when (event) {
                is MainViewEvent.Study -> {
                    slideFragment(
                        container = binding.container,
                        fragment = StudyMethodSelectFragmentHelper.newInstance(),
                        leftToRight = event.leftToRight,
                        addToBackStack = false
                    )
                }
                is MainViewEvent.Exam -> {
                    slideFragment(
                        container = binding.container,
                        fragment = LanguageExamSelectFragmentHelper.newInstance(),
                        leftToRight = event.leftToRight,
                        addToBackStack = false
                    )
                }
                is MainViewEvent.Settings -> {
                    slideFragment(
                        container = binding.container,
                        fragment = SettingsFragmentHelper.newInstance(),
                        leftToRight = event.leftToRight,
                        addToBackStack = false
                    )
                }
            }
        }
    }
}