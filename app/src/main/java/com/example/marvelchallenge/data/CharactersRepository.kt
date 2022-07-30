package com.example.marvelchallenge.data

import com.example.marvelchallenge.data.model.CharactersProvider
import com.example.marvelchallenge.data.model.ResultModel
import com.example.marvelchallenge.data.network.CharacterService
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api : CharacterService,
                                               private val charactersProvider : CharactersProvider){

    suspend fun getAllCharacters(): ResultModel?{
        val response = api.getCharacters()
        charactersProvider.characters = response?.data?.results
        return response
    }
}