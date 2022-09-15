package com.ray.language.presentation.ui.studymethod

import androidx.fragment.app.viewModels
import com.ray.language.core.common.util.eventObserve
import com.ray.language.core.presentation.util.registerForActivityResult
import com.ray.language.databinding.FragmentStudyMethodSelectBinding
import com.ray.language.presentation.helper.studymethod.select.local.LocalMusicActivityHelper
import com.ray.language.presentation.helper.studymethod.select.self.SelfMusicSelectBottomSheetHelper
import com.ray.language.presentation.ui.common.base.BaseFragment
import com.ray.language.presentation.ui.common.util.showDialog
import com.ray.language.presentation.ui.studymethod.select.self.SelfMusicSelectBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import com.ray.language.core.presentation.util.TAG

@AndroidEntryPoint
class StudyMethodSelectFragment : BaseFragment<FragmentStudyMethodSelectBinding>(FragmentStudyMethodSelectBinding::inflate) {
    private val viewModel: StudyMethodSelectViewModel by viewModels()

    private val localMusicResult = registerForActivityResult(
        LocalMusicActivityHelper::getTitleFromResult,
        LocalMusicActivityHelper::getArtistFromResult,
    ) { title, artist ->
        navigateToSearchPage(title, artist)
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
                StudyMethodViewEvent.SelfMusic -> {
                    // TODO
                    SelfMusicSelectBottomSheetHelper.newInstance(
                        onConfirm = { title, artist ->
                            navigateToSearchPage(title, artist)
                        }
                    ).show(parentFragmentManager, "SelfMusicSelectBottomSheet")
                }

                StudyMethodViewEvent.KanjiSearch -> {
                    TODO()
                }
            }
        }
    }

    fun navigateToSearchPage(
        title: String,
        artist: String
    ) {
        // TODO
        showDialog(
            title = "선택한 노래",
            message = "${title}\n${artist}"
        )
    }
}