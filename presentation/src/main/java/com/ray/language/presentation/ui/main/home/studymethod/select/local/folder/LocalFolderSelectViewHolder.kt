package com.ray.language.presentation.ui.main.home.studymethod.select.local.folder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ray.language.domain.music.MusicInformationDirectory
import com.ray.language.presentation.databinding.ItemLocalFolderBinding

class LocalFolderSelectViewHolder(
    private val binding: ItemLocalFolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        musicInformationDirectory: MusicInformationDirectory,
        onItemClick: ((item: MusicInformationDirectory) -> Unit)?
    ) {
        with(binding) {
            //TODO : thumbnail.setFolderThumbnailDrawable(musicInformationDirectory)
            title.text = musicInformationDirectory.title
            description.text =
                String.format(LocalFolderSelectContract.ITEM_DESCRIPTION, musicInformationDirectory.musicInformationList.size)
            root.setOnClickListener {
                onItemClick?.invoke(musicInformationDirectory)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): LocalFolderSelectViewHolder {
            val binding = ItemLocalFolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return LocalFolderSelectViewHolder(binding)
        }
    }
}
