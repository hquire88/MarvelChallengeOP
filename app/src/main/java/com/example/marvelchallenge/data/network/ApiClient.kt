package com.example.marvelchallenge.data.network

import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    // Characters Services
    @GET("characters")
    suspend fun getAllCharacters(@Query("limit") limit: Int,
                                 @Query("offset") offset: Int,
                                 @Query("ts") ts: String,
                                 @Query("apikey") apikey: String,
                                 @Query("hash") hash: String): Response<ResultModel<CharacterModel>>

    @GET("characters/{idCharacter}")
    suspend fun getCharacter(@Query("ts") ts: String,
                             @Query("apikey") apikey: String,
                             @Query("hash") hash: String,
                             @Path("idCharacter") idCharacter: String): Response<ResultModel<CharacterModel>>

    // Comics Services
    @GET("comics")
    suspend fun getAllComics(@Query("ts") ts: String,
                                 @Query("apikey") apikey: String,
                                 @Query("hash") hash: String): Response<ResultModel<ComicModel>>

    @GET("comics/{idComic}")
    suspend fun getComic(@Query("ts") ts: String,
                             @Query("apikey") apikey: String,
                             @Query("hash") hash: String,
                             @Path("idComic") idComic: String): Response<ResultModel<ComicModel>>
}