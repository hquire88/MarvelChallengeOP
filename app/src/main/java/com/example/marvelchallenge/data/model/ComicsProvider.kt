package com.example.marvelchallenge.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicsProvider @Inject constructor() {
        var comics: ArrayList<ComicModel>? = arrayListOf()
}