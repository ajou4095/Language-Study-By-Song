package com.ray.language.presentation.ui.study.select.local.folder

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ray.language.domain.model.music.MusicInformationDirectory

class LocalFolderAdapter : ListAdapter<MusicInformationDirectory, LocalFolderViewHolder>(LocalFolderComparator()) {
    var onItemClick: ((item: MusicInformationDirectory) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalFolderViewHolder {
        return LocalFolderViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LocalFolderViewHolder, position: Int) {
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