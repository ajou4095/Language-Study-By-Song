package com.ray.language.presentation.ui.music

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ray.language.domain.music.MusicLyricSentence
import com.ray.language.presentation.databinding.ItemMusicBinding

class MusicViewHolder(
    private val binding: ItemMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: MusicLyricSentence
    ) {
        with(binding) {
            lyrics.text = item.lyricsBody
            // TODO : matchedWords 기반 색칠 및 onClickListener 달기
        }
    }

    companion object {
        fun create(parent: ViewGroup): MusicViewHolder {
            val binding = ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return MusicViewHolder(binding)
        }
    }
}
