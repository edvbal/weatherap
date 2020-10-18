package com.android.weatherapp.entercity

import com.android.usecase.weather.Weather
import com.android.weatherapp.details.WeatherUiData
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset.ofTotalSeconds
import org.threeten.bp.format.TextStyle.SHORT
import java.util.*
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun map(item: Weather): WeatherUiData {
        return WeatherUiData(
            item.main.temp.toInt(),
            item.main.tempMin.toInt(),
            item.main.tempMax.toInt(),
            item.name,
            "http://openweathermap.org/img/wn/${item.weather.firstOrNull()?.icon}@2x.png",
            dayOfWeek(item.dt, item.timezone),
            dayOfMonth(item.dt, item.timezone),
            item.weather.firstOrNull()?.description ?: ""
        )
    }

    private fun dayOfWeek(dt: Long, timezone: Int): String {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ofTotalSeconds(timezone))
            .dayOfWeek
            .getDisplayName(SHORT, Locale.getDefault())
    }

    private fun dayOfMonth(dt: Long, timezone: Int): String {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ofTotalSeconds(timezone))
            .dayOfMonth
            .toString()
    }
}