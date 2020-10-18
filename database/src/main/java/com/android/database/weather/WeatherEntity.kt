package com.android.database.weather

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.Instant

@Entity(tableName = WeatherDao.WEATHER_DETAILS_TABLE_NAME)
class WeatherEntity(
    @PrimaryKey()
    val id: Long,
    val dt: Long,
    val name: String,
    val base: String,
    @Embedded val sys: SysEntity,
    val cod: Int,
    val timezone: Int,
    @Embedded val wind: WindEntity,
    val visibility: Int,
    @Embedded val clouds: CloudsEntity,
    @Embedded val coord: CoordinatesEntity,
    @Embedded val main: MainParametersEntity,
    val weather: List<WeatherDataEntity>,
    val dateAdded: Long = Instant.now().toEpochMilli()
) {

    data class CoordinatesEntity(val lon: Float, val lat: Float)

    data class WeatherDataEntity(
        val dataId: Int,
        val main: String,
        val icon: String,
        val description: String
    )

    data class MainParametersEntity(
        val temp: Float,
        val tempMin: Float,
        val tempMax: Float,
        val pressure: Float,
        val humidity: Float,
        val feelsLike: Float,
    )

    data class WindEntity(val deg: Int, val speed: Float)

    data class CloudsEntity(val all: Int)

    data class SysEntity(
        val sysId: Int,
        val type: Int,
        val sunset: Long,
        val sunrise: Long,
        val country: String,
    )
}
