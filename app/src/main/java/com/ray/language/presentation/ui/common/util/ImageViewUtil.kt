package com.ray.language.presentation.ui.common.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.ThumbnailUtils
import android.os.Build
import android.util.Size
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.ray.language.domain.model.music.MusicInformationDirectory
import com.ray.language.domain.model.music.information.MusicInformation
import java.io.File

fun ImageView.setFolderThumbnailDrawable(
    musicInformationDirectory: MusicInformationDirectory
) {
    val musicInformation = musicInformationDirectory.musicInformationList.getOrNull(0) ?: return
    setMusicThumbnailDrawable(musicInformation)
}

fun ImageView.setMusicThumbnailDrawable(
    musicInformation: MusicInformation
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val thumbnail = getMusicThumbnailBitmap(musicInformation, width, height)
        setImageBitmap(thumbnail)
    } else {
        val thumbnail = getMusicThumbnailDrawable(musicInformation)
        setImageDrawable(thumbnail)
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
private fun getMusicThumbnailBitmap(
    musicInformation: MusicInformation,
    width: Int,
    height: Int
): Bitmap {
    return ThumbnailUtils.createAudioThumbnail(File(musicInformation.path), Size(width, height), null)
}

private fun getMusicThumbnailDrawable(
    musicInformation: MusicInformation
): Drawable? {
    return Drawable.createFromPath(musicInformation.thumbnailPath)
}