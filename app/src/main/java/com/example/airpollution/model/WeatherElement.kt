package com.example.airpollution.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherElement(
    @SerializedName("elementName")
    @Expose
    var elementName: String? = null,

    @SerializedName("time")
    @Expose
    var time: MutableList<WeatherTime>? = null) : Serializable