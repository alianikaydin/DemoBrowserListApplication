package com.example.demoapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Item {
    @SerializedName("browser")
    @Expose
    private var browser: Browser? = null

    @SerializedName("geo")
    @Expose
    private var geo: Geo? = null

    @SerializedName("labels")
    @Expose
    private var labels: List<String?>? = null

    @SerializedName("rating")
    @Expose
    private var rating: Int? = null

    fun getBrowser(): Browser? {
        return browser
    }

    fun getGeo(): Geo? {
        return geo
    }

    fun getLabels(): List<String?>? {
        return labels
    }

    fun getRating(): Int? {
        return rating
    }


}