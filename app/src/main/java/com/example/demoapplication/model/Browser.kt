package com.example.demoapplication.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Browser {
    @SerializedName("appCodeName")
    @Expose
    private var appCodeName: String? = null

    @SerializedName("platform")
    @Expose
    private var platform: String? = null

    @SerializedName("appVersion")
    @Expose
    private var appVersion: String? = null


    fun getAppCodeName(): String? {
        return appCodeName
    }

    fun getPlatform(): String? {
        return platform
    }

    fun getAppVersion(): String? {
        return appVersion
    }
}