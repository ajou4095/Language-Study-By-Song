package com.ray.language.presentation.studymethod.select.local.folder

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ray.language.domain.model.music.MusicInformationDirectory

class LocalFolderAdapter : ListAdapter<MusicInformationDirectory, LocalFolderSelectViewHolder>(LocalFolderComparator()) {
    var onItemClick: ((item: MusicInformationDirectory) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalFolderSelectViewHolder {
        return LocalFolderSelectViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LocalFolderSelectViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClick)
    }
}

private class LocalFolderComparator : DiffUtil.ItemCallback<MusicInformationDirectory>() {
    override fun areContentsTheSame(
        oldItem: MusicInformationDirectory,
        newItem: MusicInformationDirectory
    ): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(
        oldItem: MusicInformationDirectory,
        newItem: MusicInformationDirectory
    ): Boolean {
        return oldItem == newItem
    }
}