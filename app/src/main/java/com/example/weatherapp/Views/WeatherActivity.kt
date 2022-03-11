package com.example.weatherapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.Networking.WeatherInstance
import com.example.weatherapp.Networking.WeatherService
import com.example.weatherapp.R
import com.example.weatherapp.Repositories.WeatherRepository
import com.example.weatherapp.ViewModels.WeatherViewModel
import com.example.weatherapp.ViewModels.WeatherViewModelFactory

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}