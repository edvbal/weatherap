package com.android.api.weather

import com.android.api.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("http://api.openweathermap.org/data/2.5/weather")
    fun getWeather(
        @Query("q") location: String,
        @Query("appid") appId: String = BuildConfig.API_ID,
        @Query("units") units: String = "metric"
    ): Single<WeatherBody>
}