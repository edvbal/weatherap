package com.android.weatherapp.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.weatherapp.ImageLoader
import kotlinx.android.synthetic.main.item_weather_details.view.*

class WeatherDetailsViewHolder(
    val view: View,
    val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(view) {

    fun bind(item: WeatherUiData) {
        view.descriptionTextView.text = item.description
        view.tempTextView.text = item.temp.toString()
        view.cityTextView.text = item.city
        view.dayOfWeekTextView.text = item.dayOfWeek
        view.dayOfMonthTextView.text = item.dayOfMonth
        imageLoader.loadImageFromUrl(view.iconImageView, item.iconUrl)
    }
}