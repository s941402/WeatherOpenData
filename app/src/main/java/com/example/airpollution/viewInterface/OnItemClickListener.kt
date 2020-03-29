package com.example.airpollution.viewInterface

import com.example.airpollution.model.WeatherTime

interface WeatherItemClickListener {
    fun onItemClicked(weatherTime: WeatherTime?, data: String)
}