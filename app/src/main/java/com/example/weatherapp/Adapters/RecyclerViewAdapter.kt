package com.example.weatherapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Classes.Weather
import com.example.weatherapp.R

class RecyclerViewAdapter: RecyclerView.Adapter<WeatherHolder>() {
    val currentResults: ArrayList<Weather> = ArrayList<Weather>()

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
        tvHour.text = weather.hour.toString()
        tvHumidity.text = weather.humidity.toString()
        tvTemperature.text = weather.temperature.toString()
        tvWindSpeed.text = weather.wind_speed.toString()
    }
}
