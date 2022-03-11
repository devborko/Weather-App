package com.example.weatherapp.Classes

data class WeatherResponse(
    val lat: String,
    val lon: String,
    val timezone: String,
    val timezone_offset: Int,
    val current: CurrentWeather,
    val hourly: MutableList<CurrentWeather>
)

data class CurrentWeather(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Double,
    val feels_like: Double,
    val pressure: Double,
    val humidity: Double,
    val dew_point: Double,
    val uvi: Double,
    val clouds: Double,
    val visibility: Double,
    val wind_speed: Double,
    val wind_deg: Double,
    val wind_gust: Double,
    val weather: MutableList<WeatherDescription>
)

data class WeatherDescription(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)