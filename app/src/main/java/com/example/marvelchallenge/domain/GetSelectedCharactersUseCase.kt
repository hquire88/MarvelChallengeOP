package com.example.marvelchallenge.domain

import com.example.marvelchallenge.data.CharactersRepository
import com.example.marvelchallenge.data.model.CharacterModel
import javax.inject.Inject

class GetSelectedCharactersUseCase @Inject constructor(
    private val repository : CharactersRepository
) {

    suspend operator fun invoke(): ArrayList<CharacterModel>? = repository.getSelectedCharacter()
}