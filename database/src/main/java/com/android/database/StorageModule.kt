package com.android.database

import com.android.database.weather.RoomWeatherStorage
import com.android.usecase.weather.WeatherStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class StorageModule {
    @Binds
    abstract fun bindWeatherStorage(storage: RoomWeatherStorage): WeatherStorage
}
