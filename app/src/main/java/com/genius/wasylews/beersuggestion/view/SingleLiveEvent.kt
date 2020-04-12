package com.genius.wasylews.beersuggestion.view

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


class SingleLiveEvent<T> : MutableLiveData<T?>() {

    private val liveDataToObserve: MediatorLiveData<T> = MediatorLiveData()
    private val pending = MutableLiveData<Boolean?>()

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T?>) {
        liveDataToObserve.observe(owner, Observer {
            if (pending.value != null) {
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        pending.value = true
        super.setValue(value)
    }

    @MainThread
    fun call() {
        value = null
    }

    init {
        liveDataToObserve.addSource(this) {
            liveDataToObserve.postValue(it)
            pending.postValue(null)
        }
    }
}