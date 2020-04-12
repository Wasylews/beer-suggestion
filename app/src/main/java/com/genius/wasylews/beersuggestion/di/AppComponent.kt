package com.genius.wasylews.beersuggestion.di

import com.genius.wasylews.beersuggestion.App
import com.genius.wasylews.beersuggestion.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent: AndroidInjector<App> {

    @Component.Factory
    interface Factory: AndroidInjector.Factory<App> {
        override fun create(@BindsInstance instance: App): AppComponent
    }
}