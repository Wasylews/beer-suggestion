package com.genius.wasylews.beersuggestion.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.genius.wasylews.beersuggestion.di.ViewModelFactory
import com.genius.wasylews.beersuggestion.di.ViewModelKey
import com.genius.wasylews.beersuggestion.view.list.BeerListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BeerListViewModel::class)
    fun provideBeerListViewModel(beerListViewModel: BeerListViewModel): ViewModel

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}