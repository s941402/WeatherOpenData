package com.example.airpollution.mainActivity

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import com.example.airpollution.config.pagedListConfig

class WeatherViewModel(weatherRepository: WeatherRepository) : ViewModel() {
    private val weatherSource =
        WeatherFactory(weatherRepository = weatherRepository)

    val weatherLiveData = LivePagedListBuilder(weatherSource,
        pagedListConfig()
    ).build()

    fun fetchUserInfoByKeyword(query: MutableList<String>) {
        weatherSource.updateQuery(query)
    }
}