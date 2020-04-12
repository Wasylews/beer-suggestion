package com.genius.wasylews.beersuggestion.domain

import com.genius.wasylews.beersuggestion.data.BeerEntity
import com.genius.wasylews.beersuggestion.data.BeerService
import javax.inject.Inject

class BeerRepository @Inject constructor(
    private val beerService: BeerService
) {

    suspend fun getAll(): List<BeerEntity> = beerService.getBeers()
}