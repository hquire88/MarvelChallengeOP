package com.example.marvelchallenge.data.model

data class ItemsModel(
    val available: Int,
    val collectionURI: String,
    val returned: Int,
    val items: ArrayList<SubItemsModel>
)