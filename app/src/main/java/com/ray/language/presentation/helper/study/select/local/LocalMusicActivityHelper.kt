package com.ray.language.presentation.helper.study.select.local

import android.content.Context
import android.content.Intent
import com.ray.language.presentation.ui.study.select.local.LocalMusicActivity

object LocalMusicActivityHelper {
    fun getNavigationIntent(context: Context): Intent {
        return Intent(context, LocalMusicActivity::class.java)
    }
}