package com.example.marvelchallenge.data.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailModel,
    val resourceURI: String,
    val comics: ItemsModel,
    val series: ItemsModel,
    val stories: ItemsModel,
    val events: ItemsModel
)