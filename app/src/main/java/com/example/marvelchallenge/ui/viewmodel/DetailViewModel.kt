package com.example.marvelchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.domain.GetSelectedCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSelectedCharUseCase: GetSelectedCharactersUseCase,
): ViewModel() {

    val resultSelCharModel = MutableLiveData<ArrayList<CharacterModel>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getSelectedCharUseCase()

            if (result != null){
                resultSelCharModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}