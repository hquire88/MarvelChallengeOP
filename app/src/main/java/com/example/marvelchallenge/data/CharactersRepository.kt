package com.example.marvelchallenge.data

import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.CharactersProvider
import com.example.marvelchallenge.data.model.ResultModel
import com.example.marvelchallenge.data.network.MarvelService
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api : MarvelService,
                                               private val charactersProvider : CharactersProvider){

    suspend fun getAllCharacters(): ResultModel<CharacterModel>?{
        val response = api.getAllCharacters()
        charactersProvider.characters = response?.data?.results
        return response
    }

    suspend fun getSelectedCharacter(idCharacter: Int): CharacterModel?{
        val response = api.getCharacter(idCharacter)
        charactersProvider.selectedCharacter = response?.data?.results!![0]
        return charactersProvider.selectedCharacter
    }
}