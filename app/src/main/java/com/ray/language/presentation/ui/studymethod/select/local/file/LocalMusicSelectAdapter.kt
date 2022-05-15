package com.ray.language.presentation.ui.studymethod.select.local.file

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ray.language.domain.model.music.information.MusicInformation

class LocalMusicSelectAdapter : ListAdapter<MusicInformation, LocalMusicSelectViewHolder>(LocalFolderComparator()) {
    var onItemClick: ((item: MusicInformation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalMusicSelectViewHolder {
        return LocalMusicSelectViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LocalMusicSelectViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClick)
    }
}

private class LocalFolderComparator : DiffUtil.ItemCallback<MusicInformation>() {
    override fun areContentsTheSame(
        oldItem: MusicInformation,
        newItem: MusicInformation
    ): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(
        oldItem: MusicInformation,
        newItem: MusicInformation
    ): Boolean {
        return oldItem == newItem
    }
}