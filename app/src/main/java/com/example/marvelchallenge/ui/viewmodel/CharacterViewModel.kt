package com.example.marvelchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelchallenge.data.model.ResultModel
import com.example.marvelchallenge.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    val resultModel = MutableLiveData<ResultModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharactersUseCase()

            if (result != null){
                resultModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getCharacters(){
//        val characterResult: ResultModel = CharactersProvider.getResult()
//        resultModel.postValue(characterResult)
    }
}