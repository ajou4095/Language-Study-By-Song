package com.ray.language.data.repository

import android.content.ContentResolver
import android.provider.MediaStore
import com.ray.language.domain.model.music.MusicInformation

class LocalMusicRepository(
    private val contentResolver: ContentResolver
) {
    fun getMusicsInformation(): List<MusicInformation> {
        val collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.DURATION
        )
        val selection = "${MediaStore.Audio.Media.DURATION} >= ?"
        val selectionArgs = arrayOf("60")
        val sortOrder = "${MediaStore.Audio.Media.TITLE} ASC"

        val result = mutableListOf<MusicInformation>()
        contentResolver.query(
            collection,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use { cursor ->
            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            while (cursor.moveToNext()) {
                val musicInformation = MusicInformation(
                    title = cursor.getString(titleColumn),
                    artist = cursor.getString(artistColumn),
                    path = cursor.getString(dataColumn)
                )
                result.add(musicInformation)
            }
        }
        return result
    }
}