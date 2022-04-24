package com.ray.language.presentation.ui.study

import androidx.fragment.app.viewModels
import com.ray.language.common.util.eventObserve
import com.ray.language.databinding.FragmentStudyMethodSelectBinding
import com.ray.language.presentation.helper.study.select.local.LocalMusicActivityHelper
import com.ray.language.presentation.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyMethodSelectFragment : BaseFragment<FragmentStudyMethodSelectBinding>(FragmentStudyMethodSelectBinding::inflate) {
    private val viewModel: StudyMethodSelectViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                StudyMethodViewEvent.LocalMusic -> {
                    startActivity(LocalMusicActivityHelper.getNavigationIntent(requireContext()))
                }
                StudyMethodViewEvent.YoutubeMusic -> {
                    TODO()
                }
                StudyMethodViewEvent.PopularMusic -> {
                    TODO()
                }
                StudyMethodViewEvent.MusicSearch -> {
                    TODO()
                }

                StudyMethodViewEvent.KanjiSearch -> {
                    TODO()
                }
            }
        }
    }
}