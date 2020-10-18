package com.android.usecase.weather

import io.reactivex.Single

interface WeatherApi {

    fun getWeather(location: String): Single<Weather>
}