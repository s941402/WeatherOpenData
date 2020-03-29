package com.example.airpollution.mainActivity

import android.util.Log
import com.example.airpollution.apiService.ApiService
import com.example.airpollution.apiService.AppClientManager
import com.example.airpollution.model.HttpResult
import io.reactivex.Single
import javax.security.auth.login.LoginException


class WeatherRepository {
    private val apiService = AppClientManager.client.create(ApiService::class.java)

    fun loadInfo(keywords:MutableList<String>, auth:String) : Single<HttpResult> {
        Log.i("asd","keywords:  $keywords")
        return apiService.getPosts(auth,keywords)
    }

}