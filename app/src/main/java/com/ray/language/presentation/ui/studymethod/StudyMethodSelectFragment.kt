package com.ray.language.presentation.ui.studymethod

import androidx.fragment.app.viewModels
import com.ray.language.common.util.eventObserve
import com.ray.language.core.presentation.util.registerForActivityResult
import com.ray.language.databinding.FragmentStudyMethodSelectBinding
import com.ray.language.presentation.helper.studymethod.select.local.LocalMusicActivityHelper
import com.ray.language.presentation.ui.common.base.BaseFragment
import com.ray.language.presentation.ui.common.util.showDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyMethodSelectFragment : BaseFragment<FragmentStudyMethodSelectBinding>(FragmentStudyMethodSelectBinding::inflate) {
    private val viewModel: StudyMethodSelectViewModel by viewModels()

    private val localMusicResult = registerForActivityResult(
        LocalMusicActivityHelper::getTitleFromResult,
        LocalMusicActivityHelper::getArtistFromResult
    ) { title, artist ->
        // TODO
        showDialog(
            title = "선택한 노래",
            message = "${title}\n${artist}"
        )
    }

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
                    localMusicResult.launch(LocalMusicActivityHelper.getNavigationIntent(requireContext()))
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