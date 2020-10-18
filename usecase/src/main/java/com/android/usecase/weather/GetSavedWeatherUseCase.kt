package com.android.usecase.weather

import io.reactivex.Single
import javax.inject.Inject

class GetSavedWeatherUseCase @Inject constructor(private val weatherStorage: WeatherStorage) {

    fun get(): Single<List<Weather>> {
        return weatherStorage.getAll()
            .flatMap { items ->
                if (items.count() > 5) {
                    weatherStorage.remove(items.last().id)
                        .andThen(weatherStorage.getAll())
                } else {
                    Single.just(items)
                }
            }
    }
}