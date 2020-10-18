package com.android.usecase.weather

import javax.inject.Inject

class LocationFormatter @Inject constructor() {

    fun format(city: String, country: String): String {
        return "$city,$country"
    }
}