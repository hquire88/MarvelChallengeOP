package com.example.marvelchallenge.data.network

import com.example.marvelchallenge.data.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getCharacters(): ResultModel? {
        return withContext(Dispatchers.IO){
            val response = apiClient.getCharacters("1", "ecdd665573e06b806a80273bf7d7a0d8", "18df2f6ea4b11c4f6c9b485ee1d129a4")
            response.body()
        }
    }
}