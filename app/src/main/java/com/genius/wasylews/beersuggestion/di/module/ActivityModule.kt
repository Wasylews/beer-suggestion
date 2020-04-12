package com.genius.wasylews.beersuggestion.di.module

import com.genius.wasylews.beersuggestion.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity
}