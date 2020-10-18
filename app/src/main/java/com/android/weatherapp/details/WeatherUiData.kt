package com.android.weatherapp.details

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherUiData(
    val temp: Int,
    val tempMin: Int,
    val tempMax: Int,
    val city: String,
    val iconUrl: String,
    val dayOfWeek: String,
    val dayOfMonth: String,
    val description: String
) : Parcelable