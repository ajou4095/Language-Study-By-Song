package com.ray.language.presentation.ui.main.home.studymethod.select.local.folder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ray.language.domain.music.MusicInformationDirectory
import com.ray.language.domain.usecase.music.list.GetMusicInformationDirectoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LocalFolderSelectViewModel @Inject constructor(
    getMusicInformationDirectoryListUseCase: GetMusicInformationDirectoryListUseCase
) : ViewModel() {

    private val _musicInformationDirectoryList = MutableLiveData<List<MusicInformationDirectory>>()
    val musicInformationDirectoryList: LiveData<List<MusicInformationDirectory>>
        get() = _musicInformationDirectoryList

    init {
        viewModelScope.launch {
            getMusicInformationDirectoryListUseCase().collect {
                _musicInformationDirectoryList.value = it
            }
        }
    }
}
