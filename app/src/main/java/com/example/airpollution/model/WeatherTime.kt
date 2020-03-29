package com.example.airpollution.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherTime(

    var viewType: Int = 0,

    @SerializedName("startTime")
    @Expose
    var startTime: String? = null,

    @SerializedName("endTime")
    @Expose
    var endTime: String? = null,

    @SerializedName("parameter")
    @Expose
    var parameter: ParameterModel? = null
) : Serializable