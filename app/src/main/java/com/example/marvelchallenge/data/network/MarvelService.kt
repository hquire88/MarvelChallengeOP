package com.example.marvelchallenge.data.network

import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarvelService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getAllCharacters(): ResultModel<CharacterModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllCharacters(20,0,"1", "ecdd665573e06b806a80273bf7d7a0d8", "18df2f6ea4b11c4f6c9b485ee1d129a4")
            response.body()
        }
    }

    suspend fun getCharacter(idCharacter: String): ResultModel<CharacterModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getCharacter("1", "ecdd665573e06b806a80273bf7d7a0d8", "18df2f6ea4b11c4f6c9b485ee1d129a4", idCharacter)
            response.body()
        }
    }

    suspend fun getAllComics(): ResultModel<ComicModel>? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllComics("1", "ecdd665573e06b806a80273bf7d7a0d8", "18df2f6ea4b11c4f6c9b485ee1d129a4")
            response.body()
        }
    }
}