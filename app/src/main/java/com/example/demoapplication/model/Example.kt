package com.example.demoapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {
    @SerializedName("items")
    @Expose
    private var items: List<Item?>? = null

    fun getItems(): List<Item?>? {
        return items
    }

}