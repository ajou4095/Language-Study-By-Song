package com.ray.language.presentation.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.ray.language.core.presentation.util.getDisplayWidth
import com.ray.language.design.R

abstract class BaseDialogFragment<B : ViewDataBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> B
) : DialogFragment() {
    private var _binding: B? = null

    protected val binding
        get() = _binding!!

    var onCancel: (() -> Unit)? = null

    var onConfirm: (() -> Any)? = null

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
        initWidth()
        initObserver()
    }

    protected open fun initWidth() {
        val maxWidth = getDisplayWidth()
        val width = (maxWidth * 0.8).toInt()

        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_modal)
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
        if (this@BaseDialogFragment.activity?.isFinishing == false
            && this@BaseDialogFragment.activity?.isDestroyed == false
            && !this@BaseDialogFragment.childFragmentManager.isDestroyed
        ) {
            if (this@BaseDialogFragment.childFragmentManager.isStateSaved) {
                this@BaseDialogFragment.viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    this@show.show(this@BaseDialogFragment.childFragmentManager, this@show.javaClass.simpleName)
                }
            } else {
                this@show.show(this@BaseDialogFragment.childFragmentManager, this@show.javaClass.simpleName)
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