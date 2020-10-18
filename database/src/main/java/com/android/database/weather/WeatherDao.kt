package com.android.database.weather

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrCreate(weatherDetails: WeatherEntity): Completable

    @Query("SELECT * FROM $WEATHER_DETAILS_TABLE_NAME ORDER by dateAdded DESC")
    fun getAll(): Single<List<WeatherEntity>>

    @Query("DELETE FROM $WEATHER_DETAILS_TABLE_NAME WHERE `id` == :id")
    fun remove(id: Long): Completable

    @Query("SELECT COUNT(id) FROM $WEATHER_DETAILS_TABLE_NAME")
    fun getCount(): Single<Int>

    companion object {
        const val WEATHER_DETAILS_TABLE_NAME = "weatherDetails"
    }
}