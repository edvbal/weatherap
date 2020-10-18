package com.android.weatherapp.details

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class WeatherDetailsAdapter @Inject constructor(
    private val factory: WeatherDetailsViewHolderFactory
) : RecyclerView.Adapter<WeatherDetailsViewHolder>() {

    private val items: ArrayList<WeatherUiData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDetailsViewHolder {
        return factory.create(parent)
    }

    override fun onBindViewHolder(holder: WeatherDetailsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<WeatherUiData>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}