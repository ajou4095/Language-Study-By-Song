package com.ray.language.presentation.ui.study.select.local.file

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ray.language.databinding.ItemLocalFolderBinding
import com.ray.language.domain.model.music.information.MusicInformation

class LocalMusicSelectViewHolder(
    private val binding: ItemLocalFolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        musicInformation: MusicInformation,
        onItemClick: ((item: MusicInformation) -> Unit)?
    ) {
        with(binding) {
            //TODO : thumbnail.setFolderThumbnailDrawable(musicInformationDirectory)
            title.text = musicInformation.title
            description.text = String.format(
                LocalMusicSelectContract.DURATION,
                musicInformation.duration / 1000 / 60,
                musicInformation.duration / 1000 % 60
            )
            root.setOnClickListener {
                onItemClick?.invoke(musicInformation)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): LocalMusicSelectViewHolder {
            val binding = ItemLocalFolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return LocalMusicSelectViewHolder(binding)
        }
    }
}