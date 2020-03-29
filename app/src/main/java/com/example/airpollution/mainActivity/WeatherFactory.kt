package com.example.airpollution.mainActivity

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.airpollution.model.WeatherTime

class WeatherFactory(private var weatherRepository: WeatherRepository, private var query: MutableList<String> = mutableListOf()) : DataSource.Factory<Int, WeatherTime>() {

    private val sourceLiveData= MutableLiveData<InfoDataSource>()

    override fun create(): DataSource<Int, WeatherTime> {
        val source =
            InfoDataSource(
                weatherRepository,
                query
            )
        this.sourceLiveData.postValue(source)
        return source
    }

    private fun getSource() = sourceLiveData.value


    fun updateQuery(query: MutableList<String>) {
        this.query = query
        getSource()?.refresh()
    }
}