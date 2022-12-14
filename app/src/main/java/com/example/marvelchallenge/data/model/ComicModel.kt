package com.example.marvelchallenge.data.model

data class ComicModel(
    val id: Int,
    val title: String,
    val description: String,
    val pageCount: Int,
    val thumbnail: ThumbnailModel,
    val resourceURI: String
)