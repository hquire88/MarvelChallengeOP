package com.example.marvelchallenge.data.model

data class ResultModel<T> (val code: Int, val status: String, val data: DataModel<T>)