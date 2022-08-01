package com.example.marvelchallenge.data.model

data class ThumbnailModel (val path: String, val extension: String){
    companion object {
        const val SIZE_MEDIUM = "standard_medium"
        const val SIZE_LARGE = "standard_xlarge"
        const val SIZE_FANTASTIC = "standard_fantastic"

    }

    fun getImgUrlBySize(size: String = SIZE_MEDIUM) = when (size) {
        SIZE_MEDIUM, SIZE_LARGE, SIZE_FANTASTIC -> "$path/$size.$extension"
        else -> throw IllegalArgumentException("invalid size")
    }
}