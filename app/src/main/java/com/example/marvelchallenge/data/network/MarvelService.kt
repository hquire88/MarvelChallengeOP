package com.example.marvelchallenge.data.network

import com.example.marvelchallenge.data.Constants.API_KEY
import com.example.marvelchallenge.data.Constants.HASH
import com.example.marvelchallenge.data.Constants.TS
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarvelService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getAllCharacters(): ResultModel<CharacterModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllCharacters(20,0,TS, API_KEY, HASH)
            response.body()
        }
    }

    suspend fun getCharacter(idCharacter: Int): ResultModel<CharacterModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getCharacter(idCharacter, TS, API_KEY, HASH)
            response.body()
        }
    }

    suspend fun getAllComics(): ResultModel<ComicModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllComics(TS, API_KEY, HASH)
            response.body()
        }
    }

    suspend fun getComicsByCharacter(idCharacter: Int): ResultModel<ComicModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getComicsByCharacter(idCharacter,TS, API_KEY, HASH)
            response.body()
        }
    }
}