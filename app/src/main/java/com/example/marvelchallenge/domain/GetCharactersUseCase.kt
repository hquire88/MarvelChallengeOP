package com.example.marvelchallenge.domain

import com.example.marvelchallenge.data.CharactersRepository
import com.example.marvelchallenge.data.model.ResultModel
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository : CharactersRepository
) {

    suspend operator fun invoke(): ResultModel? = repository.getAllCharacters()
}