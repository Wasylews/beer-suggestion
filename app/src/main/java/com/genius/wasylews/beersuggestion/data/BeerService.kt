package com.genius.wasylews.beersuggestion.data

import retrofit2.http.GET

interface BeerService {

    @GET("beers")
    suspend fun getBeers(): List<BeerEntity>

    companion object {

        const val BASE_URL = "https://api.punkapi.com/v2/"
    }
}
