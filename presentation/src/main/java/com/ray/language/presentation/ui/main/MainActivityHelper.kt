package com.ray.language.presentation.ui.main

import android.content.Context
import android.content.Intent

object MainActivityHelper {
    fun getNavigationIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }
}
