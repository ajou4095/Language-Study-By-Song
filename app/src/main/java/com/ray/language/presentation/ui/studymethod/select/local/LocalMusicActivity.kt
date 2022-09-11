package com.ray.language.presentation.ui.studymethod.select.local

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.ray.language.common.util.eventObserve
import com.ray.language.core.presentation.util.slideFragment
import com.ray.language.databinding.ActivityLocalMusicBinding
import com.ray.language.presentation.helper.studymethod.select.local.LocalMusicActivityHelper
import com.ray.language.presentation.helper.studymethod.select.local.detail.LocalMusicDetailFragmentHelper
import com.ray.language.presentation.helper.studymethod.select.local.file.LocalMusicSelectFragmentHelper
import com.ray.language.presentation.helper.studymethod.select.local.folder.LocalFolderSelectFragmentHelper
import com.ray.language.presentation.ui.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalMusicActivity : BaseActivity<ActivityLocalMusicBinding>(ActivityLocalMusicBinding::inflate) {
    private val viewModel: LocalMusicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initObserver()
    }

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = this@LocalMusicActivity
            supportFragmentManager.commit {
                val fragment = LocalFolderSelectFragmentHelper.newInstance()
                replace(container.id, fragment, fragment::class.simpleName)
            }
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(this@LocalMusicActivity) { event ->
            when (event) {
                LocalMusicViewEvent.FolderSelect -> {
                    val fragment = LocalMusicSelectFragmentHelper.newInstance(viewModel.selectedDirectory)
                    slideFragment(
                        container = binding.container,
                        fragment = fragment,
                        leftToRight = true,
                        addToBackStack = true
                    )
                }
                LocalMusicViewEvent.MusicSelect -> {
                    // TODO : 권한 요청
                    val fragment = LocalMusicDetailFragmentHelper.newInstance(viewModel.selectedMusicInformation)
                    slideFragment(
                        container = binding.container,
                        fragment = fragment,
                        leftToRight = true,
                        addToBackStack = true
                    )
                }
                LocalMusicViewEvent.MusicDetailCheck -> {
                    val result = LocalMusicActivityHelper.getResultIntent(
                        viewModel.selectedTitle,
                        viewModel.selectedArtist
                    )
                    setResult(RESULT_OK, result)
                    finish()
                }
            }
        }
    }
}