package com.example.marvelchallenge.data.network

import com.example.marvelchallenge.data.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("characters")
    suspend fun getCharacters(@Query("ts") ts: String,
                              @Query("apikey") apikey: String,
                              @Query("hash") hash: String): Response<ResultModel>
}