package com.example.weatherapp.Repositories

import com.example.weatherapp.Networking.WeatherInstance
import retrofit2.http.Query

class WeatherRepository(private val instance: WeatherInstance) {
    suspend fun getWeather(lat: Double, lon: Double, appid: String)
        = instance.getWeather(lat,lon,appid)
}