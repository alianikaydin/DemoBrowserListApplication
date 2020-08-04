package com.example.core.layers.network.utils.rest.request


open class AnyRequest {

    // To add parameters to path. for example xyz.com/index?Key=Value&Key2=Value2
    var parameters: MutableMap<String, String> = mutableMapOf()

    // dynamic path
    // for example xyz.com/index/{API_KEY}/signup -> {API_KEY} will be replaced with dynamic value
    var dynamicPathValues: MutableMap<String, String> = mutableMapOf()

}