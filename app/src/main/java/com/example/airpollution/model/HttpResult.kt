package com.example.airpollution.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HttpResult(
    @SerializedName("success")
    @Expose
    var success: Boolean? = null,

    @SerializedName("records")
    @Expose
    var records: RecordItems? = null
) : Serializable