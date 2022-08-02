package com.example.marvelchallenge.domain

import com.example.marvelchallenge.data.ComicsRepository
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import javax.inject.Inject

class GetComicsByCharacterUseCase @Inject constructor(
    private val repository : ComicsRepository
) {
    suspend operator fun invoke(idCharacter: Int): ResultModel<ComicModel>? = repository.getComicsByCharacter(idCharacter)
}