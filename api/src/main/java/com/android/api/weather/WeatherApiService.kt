package com.android.api.weather

import com.android.usecase.weather.Weather
import com.android.usecase.weather.WeatherApi
import io.reactivex.Single
import javax.inject.Inject

class WeatherApiService @Inject constructor(
    private val service: WeatherService,
    private val mapper: WeatherMapper
) : WeatherApi {

    override fun getWeather(location: String): Single<Weather> {
        return service.getWeather(location)
            .map(mapper::map)
    }
}