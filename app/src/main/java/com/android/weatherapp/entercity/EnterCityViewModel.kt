package com.android.weatherapp.entercity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.usecase.weather.GetSavedWeatherUseCase
import com.android.usecase.weather.GetWeatherUseCase
import com.android.weatherapp.base.RxViewModel
import com.android.weatherapp.details.WeatherUiData
import io.reactivex.rxkotlin.addTo
import timber.log.Timber


class EnterCityViewModel @ViewModelInject constructor(
    private val getSavedWeatherUseCase: GetSavedWeatherUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val mapper: WeatherMapper
) : RxViewModel() {

    private val showDetailsEvent: MutableLiveData<Array<WeatherUiData>> = MutableLiveData()

    fun observeShowDetailsEvent() = showDetailsEvent as LiveData<Array<WeatherUiData>>

    fun onViewHistoryClick() {
        getSavedWeatherUseCase.get()
            .map { items -> items.map(mapper::map) }
            .subscribe(
                { weather -> showDetailsEvent.postValue(weather.toTypedArray()) },
                { error -> Timber.e(error) }
            ).addTo(subscription)
    }

    fun onCityEnteredClick(city: String) {
        getWeatherUseCase.get(city)
            .map(mapper::map)
            .subscribe(
                { weather -> showDetailsEvent.postValue(arrayOf(weather)) },
                { error -> Timber.e(error) }
            ).addTo(subscription)
    }
}