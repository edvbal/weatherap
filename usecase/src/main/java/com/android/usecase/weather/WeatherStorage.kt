package com.android.usecase.weather

import io.reactivex.Completable
import io.reactivex.Single

interface WeatherStorage {

    fun insert(item: Weather): Completable

    fun getAll(): Single<List<Weather>>

    fun remove(id: Long): Completable
}