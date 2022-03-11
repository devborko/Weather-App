package com.example.weatherapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Classes.Weather
import com.example.weatherapp.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter: RecyclerView.Adapter<WeatherHolder>() {
    var currentResults: ArrayList<Weather> = ArrayList<Weather>()

    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.item_weather, parent, false)
        return WeatherHolder(cardItem)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        var page = currentResults[position]
        holder?.updateWithPage(page)
    }
}

public class WeatherHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvHour: TextView = itemView.findViewById<TextView>(R.id.tvHour)
    val tvTemperature: TextView = itemView.findViewById<TextView>(R.id.tvTemperature)
    val tvHumidity: TextView = itemView.findViewById<TextView>(R.id.tvHumidity)
    val tvWindSpeed: TextView = itemView.findViewById<TextView>(R.id.tvWindSpeed)


    fun updateWithPage(weather: Weather) {
        val sdf = SimpleDateFormat("HH:mm")
        val netDate = Date(weather.hour * 1000)
        tvHour.text = sdf.format(netDate)
        tvHumidity.text = "Humidity: ${weather.humidity.toString()}"
        tvTemperature.text ="Temperature: ${weather.temperature.toString()}C"
        tvWindSpeed.text = "Wind Speed: ${weather.wind_speed.toString()} km/h"
    }
}
