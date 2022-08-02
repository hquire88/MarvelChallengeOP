package com.example.marvelchallenge.domain

import com.example.marvelchallenge.data.CharactersRepository
import com.example.marvelchallenge.data.ComicsRepository
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import javax.inject.Inject

class GetSelectedCharacterUseCase @Inject constructor(
    private val repository : CharactersRepository
) {
    suspend operator fun invoke(idCharacter: Int): CharacterModel? = repository.getSelectedCharacter(idCharacter)
}