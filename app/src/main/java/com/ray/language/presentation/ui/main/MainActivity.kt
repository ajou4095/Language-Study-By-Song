package com.ray.language.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.ray.language.common.util.eventObserve
import com.ray.language.core.presentation.util.slideFragment
import com.ray.language.databinding.ActivityMainBinding
import com.ray.language.presentation.helper.exam.LanguageExamSelectFragmentHelper
import com.ray.language.presentation.helper.settings.SettingsFragmentHelper
import com.ray.language.presentation.helper.studymethod.StudyMethodSelectFragmentHelper
import com.ray.language.presentation.ui.common.base.BaseActivity
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