package com.genius.wasylews.beersuggestion.di.module

import android.content.Context
import com.genius.wasylews.beersuggestion.App
import dagger.Binds
import dagger.Module

@Module(includes = [
    DataModule::class,
    ActivityModule::class,
    FragmentModule::class,
    ViewModelModule::class
])
interface AppModule {

    @Binds
    fun provideContext(app: App): Context
}