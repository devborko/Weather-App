package com.example.weatherapp.Views

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Adapters.RecyclerViewAdapter
import com.example.weatherapp.Classes.Weather
import com.example.weatherapp.Networking.WeatherService
import com.example.weatherapp.R
import com.example.weatherapp.Repositories.WeatherRepository
import com.example.weatherapp.ViewModels.WeatherViewModel
import com.example.weatherapp.ViewModels.WeatherViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.jar.Manifest

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = RecyclerViewAdapter()

        rvWeather.adapter = adapter
        rvWeather.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)

        val weatherInstance = WeatherService.getInstance()
        val repository = WeatherRepository(weatherInstance)
        val viewModel = ViewModelProvider(this, WeatherViewModelFactory(repository)).get(WeatherViewModel::class.java)
        viewModel.getWeather(44.787197,20.457273)
        viewModel.getData().observe(this, Observer { weather ->
            val list= mutableListOf<Weather>()
            weather.forEach { w ->
                list.add(w)
            }
            adapter.currentResults = list as ArrayList<Weather>
            adapter.notifyDataSetChanged()
        })


    }

}