package com.example.core.layers.network.utils.rest.request

import com.example.core.layers.network.utils.rest.item.RequestTypes
import com.example.core.layers.network.utils.scopes.RequestType
import kotlin.reflect.full.findAnnotation

class RequestTypeBuilder<T : Any>(item: T) {

    var requestType: Int = RequestTypes.GET

    init {
        setRequestType(item)
    }

    private fun <T: Any> setRequestType(item: T) {
        val annotation = item::class.findAnnotation<RequestType>()

        if (annotation?.type != null) {
            requestType = annotation.type
        }
    }
}
