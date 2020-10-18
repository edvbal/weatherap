package com.android.database

import com.android.database.weather.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class DaoModule {

    companion object {

        @Singleton
        @Provides
        fun provideOrganizationDao(database: AppDatabase): WeatherDao {
            return database.weatherDao()
        }
    }
}
