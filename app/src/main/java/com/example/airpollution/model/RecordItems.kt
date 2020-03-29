package com.example.airpollution.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RecordItems(

    @SerializedName("datasetDescription")
    @Expose
    var datasetDescription: String? = null,

    @SerializedName("location")
    @Expose
    var location: MutableList<LocationModel>? = null

) : Serializable