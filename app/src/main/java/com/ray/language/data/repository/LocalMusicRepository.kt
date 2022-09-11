package com.ray.language.data.repository

import android.content.ContentResolver
import android.provider.MediaStore
import com.ray.language.domain.model.music.MusicInformationDirectory
import com.ray.language.domain.model.music.information.MusicInformation

// TODO : 추상화
class LocalMusicRepository(
    private val contentResolver: ContentResolver
) {
    fun getMusicInformationDirectoryList(): List<MusicInformationDirectory> {
        val collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.ALBUM_ID
        )
        val selection = "${MediaStore.Audio.Media.DURATION} >= ?"
        val selectionArgs = arrayOf("60000")
        val sortOrder = "REPLACE(${MediaStore.Audio.Media.DATA}, ${MediaStore.Audio.Media.DISPLAY_NAME}, '') ASC"

        val result = mutableListOf<MusicInformationDirectory>()
        contentResolver.query(
            collection,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use { cursor ->
            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            val albumIdColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)

            var directory: String? = null
            var musicInformationList = mutableListOf<MusicInformation>()
            while (cursor.moveToNext()) {
                val path = cursor.getString(dataColumn)
                val musicDirectory = path.substringBeforeLast('/')
                val musicInformation = MusicInformation(
                    title = cursor.getString(titleColumn),
                    artist = cursor.getString(artistColumn),
                    duration = cursor.getLong(durationColumn),
                    path = path,
                    albumId = cursor.getLong(albumIdColumn)
                )

                if (directory != musicDirectory) {
                    if (directory != null) {
                        result.add(
                            MusicInformationDirectory(
                                title = directory.substringAfterLast('/'),
                                path = directory,
                                musicInformationList = musicInformationList
                            )
                        )
                        musicInformationList = mutableListOf()
                    }
                    directory = musicDirectory
                }
                musicInformationList.add(musicInformation)
            }

            result.add(
                MusicInformationDirectory(
                    title = directory?.substringAfterLast('/') ?: "",
                    path = directory ?: "",
                    musicInformationList = musicInformationList
                )
            )
        }
        return result
    }
}