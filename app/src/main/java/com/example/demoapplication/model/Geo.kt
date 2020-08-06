package com.example.demoapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geo {
    @SerializedName("lat")
    @Expose
    private var lat: Double? = null

    @SerializedName("lon")
    @Expose
    private var lon: Double? = null

    fun getLat(): Double? {
        return lat
    }

    fun getLon(): Double? {
        return lon
    }
}