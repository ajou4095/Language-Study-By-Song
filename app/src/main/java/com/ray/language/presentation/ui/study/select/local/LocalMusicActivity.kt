package com.ray.language.presentation.ui.study.select.local

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.ray.language.databinding.ActivityLocalMusicBinding
import com.ray.language.presentation.helper.study.select.local.folder.LocalFolderSelectFragmentHelper
import com.ray.language.presentation.ui.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalMusicActivity : BaseActivity<ActivityLocalMusicBinding>(ActivityLocalMusicBinding::inflate) {
    private val viewModel: LocalMusicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
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
}