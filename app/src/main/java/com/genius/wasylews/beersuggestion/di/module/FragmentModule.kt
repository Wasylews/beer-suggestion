package com.genius.wasylews.beersuggestion.di.module

import com.genius.wasylews.beersuggestion.view.details.BeerDetailsFragment
import com.genius.wasylews.beersuggestion.view.list.BeerListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun provideBeerListFragment(): BeerListFragment

    @ContributesAndroidInjector
    fun provideBeerDetailsFragment(): BeerDetailsFragment
}