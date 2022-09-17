package com.ray.language.design.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

internal abstract class BaseBottomSheet<B : ViewDataBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BottomSheetDialogFragment() {
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
        if (this@BaseBottomSheet.activity?.isFinishing == false
            && this@BaseBottomSheet.activity?.isDestroyed == false
            && !this@BaseBottomSheet.childFragmentManager.isDestroyed
        ) {
            if (this@BaseBottomSheet.childFragmentManager.isStateSaved) {
                this@BaseBottomSheet.viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    this@show.show(this@BaseBottomSheet.childFragmentManager, this@show.javaClass.simpleName)
                }
            } else {
                this@show.show(this@BaseBottomSheet.childFragmentManager, this@show.javaClass.simpleName)
            }
        }
    }

    override fun dismiss() {
        if (activity?.isFinishing == false
            && activity?.isDestroyed == false
            && !parentFragmentManager.isDestroyed
        ) {
            if (!parentFragmentManager.isDestroyed) {
                if (parentFragmentManager.isStateSaved) {
                    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                        super.dismiss()
                    }
                } else {
                    super.dismiss()
                }
            }
        }
    }
}