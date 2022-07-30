package com.example.marvelchallenge.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersProvider @Inject constructor() {
        var characters: ArrayList<CharacterModel>? = arrayListOf()
}