package com.example.weatherapp.Networking

import com.example.weatherapp.Classes.Weather
import com.example.weatherapp.Classes.WeatherResponse
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInstance {

    @GET("onecall?exclude=daily,minutely,alerts")
    suspend fun getWeather(@Query("lat")lat: Double,
                           @Query("lon")lon: Double,
                           @Query("appid")appid: String): Response<WeatherResponse>
}