package com.genius.wasylews.beersuggestion.data

import com.google.gson.annotations.SerializedName

data class BeerEntity(
    val name: String,
    @SerializedName("tagline") val tagLine: String,
    @SerializedName("image_url") val logo: String
)
