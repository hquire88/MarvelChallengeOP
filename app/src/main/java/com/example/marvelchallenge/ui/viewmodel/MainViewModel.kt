package com.example.marvelchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import com.example.marvelchallenge.domain.GetCharactersUseCase
import com.example.marvelchallenge.domain.GetComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getComicsUseCase: GetComicsUseCase
): ViewModel() {

    val resultCharacterModel = MutableLiveData<ResultModel<CharacterModel>>()
    val resultComicModel = MutableLiveData<ResultModel<ComicModel>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharactersUseCase()

            if (result != null){
                resultCharacterModel.postValue(result)
                isLoading.postValue(false)
            }
        }

        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getComicsUseCase()

            if (result != null){
                resultComicModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getCharacters(){
//        val characterResult: ResultModel = CharactersProvider.getResult()
//        resultModel.postValue(characterResult)
    }
}