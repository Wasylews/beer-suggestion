package com.genius.wasylews.beersuggestion.domain

import javax.inject.Inject

class GetBeerListUseCase @Inject constructor(
    private val beerRepository: BeerRepository
) {

    suspend fun getBeers(): List<Beer> {
        return beerRepository.getAll()
            .map {
                Beer(it.name, it.tagLine, it.logo)
            }
    }
}