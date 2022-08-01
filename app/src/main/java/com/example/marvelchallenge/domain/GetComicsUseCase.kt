package com.example.marvelchallenge.domain

import com.example.marvelchallenge.data.ComicsRepository
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ResultModel
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val repository : ComicsRepository
) {

    suspend operator fun invoke(): ResultModel<ComicModel>? = repository.getAllComics()
}