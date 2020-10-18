package com.android.database

import androidx.room.TypeConverter
import com.android.database.weather.WeatherEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DatabaseConverters {

    @JvmStatic
    @TypeConverter
    fun toDataEntity(value: List<WeatherEntity.WeatherDataEntity>): String {
        val type = object : TypeToken<List<WeatherEntity.WeatherDataEntity>>() {}.type
        return Gson().toJson(value, type)
    }

    @JvmStatic
    @TypeConverter
    fun fromDataEntity(value: String): List<WeatherEntity.WeatherDataEntity> {
        val type = object : TypeToken<List<WeatherEntity.WeatherDataEntity>>() {}.type
        return Gson().fromJson(value, type)
    }
}