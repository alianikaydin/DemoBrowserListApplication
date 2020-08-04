package com.example.core.layers.network.utils.rest.request

import android.text.TextUtils
import com.example.core.layers.network.utils.scopes.RequestHeader
import kotlin.reflect.full.findAnnotation


class RequestHeaderBuilder<T: AnyRequest>(item: T) {

    var header : MutableMap<String, String> = mutableMapOf()

    init {
        setHeader(item)
    }

    private fun <T: AnyRequest>setHeader(request: T) {
        for (field in request::class.members) {
            val annotation = field.findAnnotation<RequestHeader>()
            if (annotation != null) {
                val value = field.call(request).toString()
                if (!TextUtils.isEmpty(value)) {
                    header.put(annotation.name, value)
                }
            }
        }
    }
}
