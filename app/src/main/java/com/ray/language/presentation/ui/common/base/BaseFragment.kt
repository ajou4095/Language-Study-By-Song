package com.ray.language.presentation.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin

abstract class BaseFragment<B : ViewDataBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> B
) : Fragment() {
    private var _binding: B? = null

    protected val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        NavigationFlipperPlugin.getInstance().sendNavigationEvent(tag, tag, null)
    }

    protected open fun initView() = Unit

    protected open fun initObserver() = Unit

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun bind(action: B.() -> Unit) {
        binding.action()
    }

    fun DialogFragment.show() {
        if (this@BaseFragment.activity?.isFinishing == false
            && this@BaseFragment.activity?.isDestroyed == false
            && !this@BaseFragment.childFragmentManager.isDestroyed
        ) {
            if (this@BaseFragment.childFragmentManager.isStateSaved) {
                this@BaseFragment.viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    this@show.show(this@BaseFragment.childFragmentManager, this@show.javaClass.simpleName)
                }
            } else {
                this@show.show(this@BaseFragment.childFragmentManager, this@show.javaClass.simpleName)
            }
        }
    }
}