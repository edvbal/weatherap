package com.android.usecase.weather

data class Weather(
    val dt: Long,
    val id: Long,
    val name: String,
    val base: String,
    val sys: Sys,
    val cod: Int,
    val timezone: Int,
    val wind: Wind,
    val visibility: Int,
    val clouds: Clouds,
    val coord: Coordinates,
    val main: MainParameters,
    val weather: List<WeatherData>
) {

    data class Coordinates(val lon: Float, val lat: Float) {

        companion object {
            private val EMPTY = Coordinates(-1f, -1f)

            fun empty() = EMPTY
        }
    }

    data class WeatherData(
        val id: Int,
        val main: String,
        val icon: String,
        val description: String
    ) {

        companion object {
            private val EMPTY = WeatherData(-1, "", "", "")

            fun empty() = EMPTY
        }
    }

    data class MainParameters(
        val temp: Float,
        val tempMin: Float,
        val tempMax: Float,
        val pressure: Float,
        val humidity: Float,
        val feelsLike: Float,
    ) {

        companion object {
            private val EMPTY = MainParameters(-1f, -1f, -1f, -1f, -1f, -1f)

            fun empty() = EMPTY
        }
    }

    data class Wind(val deg: Int, val speed: Float) {

        companion object {
            private val EMPTY = Wind(-1, -1f)

            fun empty() = EMPTY
        }
    }

    data class Clouds(val all: Int) {

        companion object {
            private val EMPTY = Clouds(-1)

            fun empty() = EMPTY
        }
    }

    data class Sys(
        val id: Int,
        val type: Int,
        val sunset: Long,
        val sunrise: Long,
        val country: String,
    ) {

        companion object {
            private val EMPTY = Sys(-1, -1, -1L, -1L, "")

            fun empty(): Sys = EMPTY
        }
    }
}