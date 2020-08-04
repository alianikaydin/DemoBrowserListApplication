package com.example.core.layers.network.utils.rest.request

import com.google.gson.*
import com.google.gson.annotations.SerializedName

class RequestBodyJsonBuilder<T>(item: T) {

    lateinit var body: JsonObject

    init {
        setBody(item)
    }

    private fun setBody(item: T) {
        val gson = GsonBuilder()
            .setExclusionStrategies(OnlySerialized())
            .setLenient()
            .create()

        body = JsonParser().parse(gson.toJson(item)) as JsonObject
    }

    class OnlySerialized : ExclusionStrategy{
        override fun shouldSkipField(f: FieldAttributes?): Boolean {
            f?.annotations?.forEach {
                if (it is SerializedName) {
                    return false
                }
            }
            return true
        }

        override fun shouldSkipClass(clazz: Class<*>?): Boolean {
            return false
        }

    }
}
