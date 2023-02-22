package com.ray.language.presentation.ui.studymethod.select.local.file

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ray.language.domain.music.information.MusicInformation
import com.ray.language.presentation.databinding.ItemLocalMusicBinding

class LocalMusicSelectViewHolder(
    private val binding: ItemLocalMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        musicInformation: MusicInformation,
        onItemClick: ((item: MusicInformation) -> Unit)?
    ) {
        with(binding) {
            //TODO : thumbnail.setFolderThumbnailDrawable(musicInformationDirectory)
            title.text = musicInformation.title
            artist.text = musicInformation.artist
            duration.text = String.format(
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
            val binding = ItemLocalMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return LocalMusicSelectViewHolder(binding)
        }
    }
}
