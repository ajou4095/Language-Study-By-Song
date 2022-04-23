package com.ray.language.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.ray.language.common.util.eventObserve
import com.ray.language.databinding.ActivityMainBinding
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
                MainViewEvent.Exam -> {

                }
                MainViewEvent.Settings -> {

                }
                MainViewEvent.Study -> {

                }
            }
        }
    }
}