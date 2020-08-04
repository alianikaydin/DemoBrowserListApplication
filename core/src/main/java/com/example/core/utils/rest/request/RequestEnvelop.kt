package com.example.core.layers.network.utils.rest.request

import com.google.gson.JsonObject

class RequestEnvelop<T : AnyRequest>(item: T) {

    private var mHeader: RequestHeaderBuilder<T> = RequestHeaderBuilder(item)
    private val mBody: RequestBodyJsonBuilder<T> = RequestBodyJsonBuilder(item)
    private var mPathBuilder: RequestPathBuilder<T> = RequestPathBuilder(item)
    var requestType: RequestTypeBuilder<T> = RequestTypeBuilder(item)

    val header: MutableMap<String, String>
        get() = mHeader.header

    val body: JsonObject
        get() = mBody.body

    val params: Map<String, String>
        get() = mPathBuilder.parameters

    val postUrl: String
        get() = mPathBuilder.path

}
