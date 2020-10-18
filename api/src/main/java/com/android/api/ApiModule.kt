package com.android.api

import com.android.api.weather.WeatherApiService
import com.android.api.weather.WeatherService
import com.android.usecase.weather.WeatherApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@InstallIn(ApplicationComponent::class)
@Module
abstract class ApiModule {

    @Binds
    internal abstract fun bindWeatherApi(api: WeatherApiService): WeatherApi

    companion object {

        @Provides
        fun provideVaultListGson(): Gson {
            return GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        }

        @Provides
        fun provideWeatherService(retrofit: Retrofit): WeatherService {
            return retrofit.create(WeatherService::class.java)
        }
    }
}
