package com.android.usecase.weather

import io.reactivex.Single
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val api: WeatherApi,
    private val storage: WeatherStorage,
    private val locationFormatter: LocationFormatter
) {

    fun get(city: String): Single<Weather> {
        return api.getWeather(locationFormatter.format(city, "LT"))
            .flatMap { weather -> storage.insert(weather).toSingleDefault(weather) }
    }
}