package com.example.weatherapp.Repositories

import com.example.weatherapp.Networking.WeatherInstance
import retrofit2.http.Query

class WeatherRepository(private val instance: WeatherInstance) {
    suspend fun getWeather(lat: Double, lon: Double)
        = instance.getWeather(lat,lon,"1e435a7fa348fd9a5957af355bf8e27e")
}