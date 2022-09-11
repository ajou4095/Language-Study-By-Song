package com.ray.language.presentation.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.ray.language.core.presentation.util.TAG

abstract class BaseActivity<B : ViewDataBinding>(
    private val inflater: (LayoutInflater) -> B
) : AppCompatActivity() {
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding.root)
        NavigationFlipperPlugin.getInstance().sendNavigationEvent(TAG, TAG, null)
    }

    protected open fun initView() = Unit

    protected open fun initObserver() = Unit

    protected fun bind(action: B.() -> Unit) {
        binding.action()
    }
}