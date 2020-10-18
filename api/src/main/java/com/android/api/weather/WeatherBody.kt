package com.android.api.weather

class WeatherBody {
    var dt: Long? = null
    var id: Long? = null
    var name: String? = null
    var base: String? = null
    var sys: SysBody? = null
    var cod: Int? = null
    var timezone: Int? = null
    var wind: WindBody? = null
    var visibility: Int? = null
    var clouds: CloudsBody? = null
    var coord: CoordinatesBody? = null
    var main: MainParametersBody? = null
    var weather: List<WeatherDataBody>? = null

    class CoordinatesBody {
        var lon: Float? = null
        var lat: Float? = null
    }

    class WeatherDataBody {
        var id: Int? = null
        var main: String? = null
        var icon: String? = null
        var description: String? = null
    }

    class MainParametersBody {
        var temp: Float? = null
        var tempMin: Float? = null
        var tempMax: Float? = null
        var pressure: Float? = null
        var humidity: Float? = null
        var feelsLike: Float? = null
    }

    class WindBody {
        var deg: Int? = null
        var speed: Float? = null
    }

    class CloudsBody {
        var all: Int? = null
    }

    class SysBody {
        var id: Int? = null
        var type: Int? = null
        var sunset: Long? = null
        var sunrise: Long? = null
        var country: String? = null
    }
}