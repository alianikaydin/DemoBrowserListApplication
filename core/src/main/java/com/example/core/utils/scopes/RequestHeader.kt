package com.example.core.layers.network.utils.scopes


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation class RequestHeader(val name : String)


