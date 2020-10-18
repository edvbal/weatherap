package com.android.weatherapp.details

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.weatherapp.ImageLoader
import com.android.weatherapp.R
import javax.inject.Inject

class WeatherDetailsViewHolderFactory @Inject constructor(private val imageLoader: ImageLoader) {

    fun create(parent: ViewGroup): WeatherDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_weather_details, parent, false)
        return WeatherDetailsViewHolder(view, imageLoader)
    }
}