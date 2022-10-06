package com.ray.language.presentation.studymethod

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ray.language.core.common.util.eventObserve
import com.ray.language.core.presentation.util.registerForActivityResult
import com.ray.language.databinding.FragmentStudyMethodSelectBinding
import com.ray.language.design.window.modal.alert.AlertDialogFragmentHelper
import com.ray.language.domain.usecase.musixmatch.search.GetLyricsByMatcherUseCase
import com.ray.language.presentation.studymethod.select.local.LocalMusicActivityHelper
import com.ray.language.presentation.studymethod.select.self.SelfMusicSelectBottomSheetHelper
import com.ray.language.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StudyMethodSelectFragment : BaseFragment<FragmentStudyMethodSelectBinding>(FragmentStudyMethodSelectBinding::inflate) {
    private val viewModel: StudyMethodSelectViewModel by viewModels()

    @Inject
    lateinit var usecase: GetLyricsByMatcherUseCase

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
                    ).show()
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

        lifecycleScope.launch {
            usecase.invoke(title, artist).catch { exception ->
                AlertDialogFragmentHelper.newInstance(
                    title = "에러 발생",
                    message = exception.message
                ).show()
            }.collect { lyricsInformation ->
                AlertDialogFragmentHelper.newInstance(
                    title = title,
                    message = lyricsInformation.lyricsBody
                ).show()
            }
        }
    }
}