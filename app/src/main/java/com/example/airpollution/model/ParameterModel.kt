package com.example.airpollution.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ParameterModel {
    @SerializedName("parameterName")
    @Expose
    var parameterName: String? = null

    @SerializedName("parameterUnit")
    @Expose
    var parameterUnit: String? = null
}