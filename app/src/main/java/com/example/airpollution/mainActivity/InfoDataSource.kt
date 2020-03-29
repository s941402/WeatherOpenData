package com.example.airpollution.mainActivity

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.airpollution.commonUtil.setLocation
import com.example.airpollution.config.Config.AUTHORIZATION
import com.example.airpollution.model.WeatherTime
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class InfoDataSource(
    private val repository: WeatherRepository,
    private val query: MutableList<String>
) : PageKeyedDataSource<Int, WeatherTime>() {

    private var retryQuery: (() -> Any)? = null //Keep the last query just in case it fails

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, WeatherTime>
    ) {
        retryQuery = { loadInitial(params, callback) }
        executeQuery {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, WeatherTime>) {
//        val page = params.key
//        retryQuery = { loadAfter(params, callback) }
//        executeQuery(page) {
//            callback.onResult(it, page + 1)
//        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, WeatherTime>
    ) {
        //Not implemented
    }

    private fun executeQuery(
        callback: (MutableList<WeatherTime>) -> Unit
    ) {
        repository.loadInfo(setLocation(), AUTHORIZATION)
            .map { result ->
                val newWeatherTimeList: MutableList<WeatherTime> = mutableListOf()
                val weatherTimeList = result.records?.location?.first {
                    it.locationName.equals("臺北市") || it.locationName.equals("台北市")
                }?.weatherElement?.first { weatherModel ->
                    weatherModel.elementName.equals("MinT")
                }?.time?.toMutableList() ?: mutableListOf()
                weatherTimeList.forEachIndexed { index, weatherTime ->
                    weatherTime.viewType = 2
                    newWeatherTimeList.add(weatherTime)
                    if (index != weatherTimeList.size - 1) {
                        newWeatherTimeList.add(WeatherTime(1))
                    }
                }
                newWeatherTimeList
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<MutableList<WeatherTime>>() {
                override fun onSuccess(response: MutableList<WeatherTime>) {
                    Log.i("asd", "response : ${Gson().toJson(response)}")
                    retryQuery = null
                    callback(response)
                }

                override fun onError(e: Throwable) {
                    // Error handle.
                    retryQuery = null
                }
            })

    }

    fun refresh() =
        this.invalidate()
}