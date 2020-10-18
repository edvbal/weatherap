package com.android.database.weather

import com.android.usecase.Io
import com.android.usecase.weather.Weather
import com.android.usecase.weather.WeatherStorage
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class RoomWeatherStorage @Inject constructor(
    private val dao: WeatherDao,
    private val mapper: WeatherMapper,
    @Io private val scheduler: Scheduler
) : WeatherStorage {

    override fun insert(item: Weather): Completable {
        return dao.updateOrCreate(mapper.map(item))
            .doOnError(Timber::e)
            .onErrorComplete()
            .subscribeOn(scheduler)
    }

    override fun getAll(): Single<List<Weather>> {
        return dao.getAll()
            .doOnError(Timber::e)
            .map { items -> items.map(mapper::map) }
            .onErrorReturnItem(emptyList())
            .subscribeOn(scheduler)
    }

    override fun remove(id: Long): Completable {
        return dao.remove(id)
            .doOnError { error -> Timber.e(error) }
            .onErrorComplete()
            .subscribeOn(scheduler)
    }
}