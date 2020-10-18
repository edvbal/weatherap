package com.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.database.weather.WeatherDao
import com.android.database.weather.WeatherEntity

@Database(
    version = 1,
    entities = [WeatherEntity::class]
)
@TypeConverters(DatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        const val DATABASE_NAME = "database"
    }
}