package com.android.weatherapp.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class RxViewModel : ViewModel() {

    protected val subscription = CompositeDisposable()

    @CallSuper
    override fun onCleared() = subscription.clear()
}