package com.ray.language.presentation.ui.music

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ray.language.domain.music.MusicLyricSentence

class MusicListAdapter : ListAdapter<MusicLyricSentence, MusicViewHolder>(MusicListComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(
            item = getItem(position)
        )
    }
}

private class MusicListComparator : DiffUtil.ItemCallback<MusicLyricSentence>() {
    override fun areItemsTheSame(oldItem: MusicLyricSentence, newItem: MusicLyricSentence): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MusicLyricSentence, newItem: MusicLyricSentence): Boolean {
        return oldItem == newItem
    }
}
