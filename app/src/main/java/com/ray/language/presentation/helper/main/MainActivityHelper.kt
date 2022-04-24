package com.ray.language.presentation.helper.main

import android.content.Context
import android.content.Intent
import com.ray.language.presentation.ui.main.MainActivity

object MainActivityHelper {
    fun getNavigationIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }
}