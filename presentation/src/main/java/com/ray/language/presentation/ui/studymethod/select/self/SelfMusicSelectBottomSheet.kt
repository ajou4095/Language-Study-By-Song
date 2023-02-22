package com.ray.language.presentation.ui.studymethod.select.self

import androidx.fragment.app.viewModels
import com.ray.language.common.eventObserve
import com.ray.language.common.valueOrDefault
import com.ray.language.presentation.common.base.BaseBottomSheet
import com.ray.language.presentation.databinding.BottomsheetSelfMusicSelectBinding

class SelfMusicSelectBottomSheet : BaseBottomSheet<BottomsheetSelfMusicSelectBinding>(BottomsheetSelfMusicSelectBinding::inflate) {
    private val viewModel: SelfMusicSelectViewModel by viewModels()

    var onConfirm: ((title: String, artist: String) -> Unit)? = null

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                SelfMusicSelectViewEvent.Confirm -> {
                    onConfirm?.invoke(viewModel.title.valueOrDefault, viewModel.artist.valueOrDefault)
                    dismiss()
                }
                SelfMusicSelectViewEvent.EmptyTitle -> {
                    binding.inputTitleContainer.requestFocus()
                }
            }
        }
    }
}
