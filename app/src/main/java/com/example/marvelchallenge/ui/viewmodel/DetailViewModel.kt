package com.example.marvelchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.domain.GetComicsByCharacterUseCase
import com.example.marvelchallenge.domain.GetSelectedCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getComicsByCharacterUseCase: GetComicsByCharacterUseCase,
    private val getSelectedCharacterUseCase: GetSelectedCharacterUseCase
): ViewModel() {

    val resultComicsByCharacterModel = MutableLiveData<ArrayList<ComicModel>>()
    val resultSelectedCharModel = MutableLiveData<CharacterModel?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(idCharacter: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getSelectedCharacterUseCase.invoke(idCharacter)

            if (result != null){
                resultSelectedCharModel.postValue(result)
                isLoading.postValue(false)
            }
        }

        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getComicsByCharacterUseCase.invoke(idCharacter)

            if (result != null){
                resultComicsByCharacterModel.postValue(result.data.results)
                isLoading.postValue(false)
            }
        }
    }
}