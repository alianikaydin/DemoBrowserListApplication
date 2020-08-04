package com.example.core.layers.network.utils.rest.request

import android.text.TextUtils
import com.example.core.layers.network.utils.scopes.RequestPath
import kotlin.reflect.full.findAnnotation

class RequestPathBuilder<T: AnyRequest> @Throws(Exception::class)
constructor(request: T) {

    var path: String = ""
    var parameters: Map<String, String> = mutableMapOf()

    init {
        setPath(request)
        setParameters(request)
    }

    private fun <T: AnyRequest> setPath(request: T) {
        val annotation = request::class.findAnnotation<RequestPath>()

        if (annotation?.path != null) {
            path = annotation.path
        }

        buildDynamicPath(request)
    }

    private fun buildDynamicPath(request : AnyRequest) {
        if (TextUtils.isEmpty(path)) {
            return
        }

        for (item in request.dynamicPathValues) {
            path = path.replace(item.key, item.value)
        }
    }

    private fun <T: AnyRequest> setParameters(request: T) {
        this.parameters = request.parameters
    }

}
