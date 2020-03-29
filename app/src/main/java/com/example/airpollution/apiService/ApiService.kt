package com.example.airpollution.apiService

import com.example.airpollution.model.HttpResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v1/rest/datastore/F-C0032-001")
    fun getPosts(@Query("Authorization") authorization: String,@Query("locationName") locationNameList: MutableList<String>): Single<HttpResult>

}
