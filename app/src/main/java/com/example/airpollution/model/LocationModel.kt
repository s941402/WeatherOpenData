package com.example.airpollution.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LocationModel(

    @SerializedName("locationName")
    @Expose
    var locationName: String? = null,

    @SerializedName("weatherElement")
    @Expose
    var weatherElement: MutableList<WeatherElement>? = null
    ) : Serializable
