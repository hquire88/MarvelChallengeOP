package com.example.marvelchallenge.data

import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ComicsProvider
import com.example.marvelchallenge.data.model.ResultModel
import com.example.marvelchallenge.data.network.MarvelService
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val api : MarvelService,
                                           private val comicsProvider : ComicsProvider
){

    suspend fun getAllComics(): ResultModel<ComicModel>?{
        val response = api.getAllComics()
        comicsProvider.comics = response?.data?.results
        return response
    }
}