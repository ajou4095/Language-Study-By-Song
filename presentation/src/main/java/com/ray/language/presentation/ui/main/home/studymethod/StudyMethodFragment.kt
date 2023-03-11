package com.ray.language.presentation.ui.main.home.studymethod

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ray.language.common.eventObserve
import com.ray.language.domain.usecase.musixmatch.search.GetLyricsByMatcherUseCase
import com.ray.language.presentation.common.base.BaseFragment
import com.ray.language.presentation.common.util.registerForActivityResult
import com.ray.language.presentation.databinding.FragmentStudyMethodBinding
import com.ray.language.presentation.ui.main.home.studymethod.select.local.LocalMusicActivityHelper
import com.ray.language.presentation.ui.main.home.studymethod.select.self.SelfMusicSelectBottomSheetHelper
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StudyMethodFragment : BaseFragment<FragmentStudyMethodBinding>(FragmentStudyMethodBinding::inflate) {
    private val viewModel: StudyMethodViewModel by viewModels()

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
                AlertDialogFragmentProvider.makeAlertDialog(
                    title = "에러 발생",
                    message = exception.message
                ).show()
            }.collect { lyricsInformation ->
                AlertDialogFragmentProvider.makeAlertDialog(
                    title = title,
                    message = lyricsInformation.lyricsBody
                ).show()
            }
        }
    }
}
