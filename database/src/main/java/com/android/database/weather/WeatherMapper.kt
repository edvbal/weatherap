package com.android.database.weather

import com.android.usecase.weather.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun map(weather: Weather): WeatherEntity {
        return WeatherEntity(
            weather.id,
            weather.dt,
            weather.name,
            weather.base,
            weather.sys.toSysEntity(),
            weather.cod,
            weather.timezone,
            weather.wind.toWindEntity(),
            weather.visibility,
            weather.clouds.toCloudsEntity(),
            weather.coord.toCoordinatesEntity(),
            weather.main.toParametersEntity(),
            weather.weather.toDataEntity()
        )
    }

    fun map(entity: WeatherEntity): Weather {
        return Weather(
            entity.dt,
            entity.id,
            entity.name,
            entity.base,
            entity.sys.toSys(),
            entity.cod,
            entity.timezone,
            entity.wind.toWind(),
            entity.visibility,
            entity.clouds.toClouds(),
            entity.coord.toCoordinates(),
            entity.main.toParameters(),
            entity.weather.toData()
        )
    }

    private fun Weather.Sys.toSysEntity(): WeatherEntity.SysEntity {
        return WeatherEntity.SysEntity(id, type, sunset, sunrise, country)
    }

    private fun WeatherEntity.SysEntity.toSys(): Weather.Sys {
        return Weather.Sys(sysId, type, sunset, sunrise, country)
    }

    private fun Weather.Wind.toWindEntity(): WeatherEntity.WindEntity {
        return WeatherEntity.WindEntity(deg, speed)
    }

    private fun WeatherEntity.WindEntity.toWind(): Weather.Wind {
        return Weather.Wind(deg, speed)
    }

    private fun Weather.Clouds.toCloudsEntity(): WeatherEntity.CloudsEntity {
        return WeatherEntity.CloudsEntity(all)
    }

    private fun WeatherEntity.CloudsEntity.toClouds(): Weather.Clouds {
        return Weather.Clouds(all)
    }

    private fun Weather.Coordinates.toCoordinatesEntity(): WeatherEntity.CoordinatesEntity {
        return WeatherEntity.CoordinatesEntity(lon, lat)
    }

    private fun WeatherEntity.CoordinatesEntity.toCoordinates(): Weather.Coordinates {
        return Weather.Coordinates(lon, lat)
    }

    private fun Weather.MainParameters.toParametersEntity(): WeatherEntity.MainParametersEntity {
        return WeatherEntity.MainParametersEntity(
            temp,
            tempMin,
            tempMax,
            pressure,
            humidity,
            feelsLike
        )
    }

    private fun WeatherEntity.MainParametersEntity.toParameters(): Weather.MainParameters {
        return Weather.MainParameters(temp, tempMin, tempMax, pressure, humidity, feelsLike)
    }

    private fun List<Weather.WeatherData>.toDataEntity(): List<WeatherEntity.WeatherDataEntity> {
        return map { item ->
            WeatherEntity.WeatherDataEntity(item.id, item.main, item.icon, item.description)
        }
    }

    private fun List<WeatherEntity.WeatherDataEntity>.toData(): List<Weather.WeatherData> {
        return map { item ->
            Weather.WeatherData(item.dataId, item.main, item.icon, item.description)
        }
    }
}
