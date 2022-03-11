package com.example.weatherapp.ViewModels

import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.Classes.Weather
import com.example.weatherapp.Classes.WeatherResponse
import com.example.weatherapp.Repositories.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.jar.Manifest

class WeatherViewModel(private val repository: WeatherRepository): ViewModel() {
    val weatherLiveData : MutableLiveData<List<Weather>> = MutableLiveData()
    val weatherList = mutableListOf<Weather>()

    val scope = CoroutineScope(Dispatchers.IO)

    fun getWeather(lat: Double, lon: Double, appid: String){
        scope.launch {
            val response = repository.getWeather(lat,lon,appid)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    for(current in response.body()?.hourly!!)
                    {
                        weatherList.add(
                            Weather(current.dt,current.temp,current.humidity,current.wind_speed)
                        )
                    }
                    weatherLiveData.value = weatherList
                } else {
                    Log.d("Error", response.message())
                }
            }
        }
    }
}