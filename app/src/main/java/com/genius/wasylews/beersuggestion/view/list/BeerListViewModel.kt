package com.genius.wasylews.beersuggestion.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genius.wasylews.beersuggestion.domain.Beer
import com.genius.wasylews.beersuggestion.domain.GetBeerListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class BeerListViewModel @Inject constructor(
    private val getBeerListUseCase: GetBeerListUseCase
): ViewModel() {

    val beers = MutableLiveData<List<Beer>>()

    fun loadData() {
        viewModelScope.launch {
            beers.postValue(getBeerListUseCase.getBeers())
        }
    }

    fun suggestBeer() {
        if (beers.value != null) {
            val randomBeer = beers.value!!.random()
            beers.postValue(listOf(randomBeer))
        }
    }
}