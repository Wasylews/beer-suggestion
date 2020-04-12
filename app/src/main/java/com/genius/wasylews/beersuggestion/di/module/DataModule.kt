package com.genius.wasylews.beersuggestion.di.module

import com.genius.wasylews.beersuggestion.domain.BeerRepository
import dagger.Binds
import dagger.Module

@Module(includes = [
    NetworkModule::class
])
interface DataModule {

}