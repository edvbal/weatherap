package com.android.api.weather

import com.android.usecase.weather.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun map(body: WeatherBody): Weather {
        return Weather(
            body.dt ?: 0L,
            body.id ?: 0L,
            body.name ?: "",
            body.base ?: "",
            body.sys?.toSys() ?: Weather.Sys.empty(),
            body.cod ?: -1,
            body.timezone ?: -1,
            body.wind?.toWind() ?: Weather.Wind.empty(),
            body.visibility ?: -1,
            body.clouds?.toClouds() ?: Weather.Clouds.empty(),
            body.coord?.toCoordinates() ?: Weather.Coordinates.empty(),
            body.main?.toParameters() ?: Weather.MainParameters.empty(),
            body.weather?.toParameters() ?: emptyList()
        )
    }

    private fun WeatherBody.SysBody.toSys(): Weather.Sys {
        return Weather.Sys(id ?: -1, type ?: -1, sunset ?: -1L, sunrise ?: -1L, country ?: "")
    }

    private fun WeatherBody.WindBody.toWind(): Weather.Wind {
        return Weather.Wind(deg ?: -1, speed ?: -1f)
    }

    private fun WeatherBody.CloudsBody.toClouds(): Weather.Clouds {
        return Weather.Clouds(all ?: -1)
    }

    private fun WeatherBody.CoordinatesBody.toCoordinates(): Weather.Coordinates {
        return Weather.Coordinates(lon ?: -1f, lat ?: -1f)
    }

    private fun WeatherBody.MainParametersBody.toParameters(): Weather.MainParameters {
        return Weather.MainParameters(
            temp ?: -1f,
            tempMin ?: -1f,
            tempMax ?: -1f,
            pressure ?: -1f,
            humidity ?: -1f,
            feelsLike ?: -1f
        )
    }

    private fun List<WeatherBody.WeatherDataBody>.toParameters(): List<Weather.WeatherData> {
        return map { item ->
            Weather.WeatherData(
                item.id ?: -1,
                item.main ?: "",
                item.icon ?: "",
                item.description ?: ""
            )
        }
    }
}