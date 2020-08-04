package com.example.core.layers.network.utils.scopes


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class RequestPath(val path : String)


