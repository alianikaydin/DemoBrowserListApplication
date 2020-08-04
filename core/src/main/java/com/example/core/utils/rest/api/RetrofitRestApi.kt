package com.example.core.layers.network.utils.rest.api

import com.example.core.base.dialog.BaseLoadingDialogHandler
import com.example.core.layers.network.utils.rest.domain.ResponseDomain
import com.example.core.layers.network.utils.rest.item.RequestTypes
import com.example.core.layers.network.utils.rest.request.AnyRequest
import com.example.core.layers.network.utils.rest.request.RequestEnvelop
import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*


open class RetrofitRestApi(retrofit: Retrofit, private val loadingDialogHandler: BaseLoadingDialogHandler) {
    private val TAG = RetrofitRestApi::class.java.canonicalName

    companion object {
        const val HEADER_CONTENT_TYPE = "Content-Type: application/json; charset=utf-8"
        const val HEADER_ACCEPT_CHARSET = "Accept-Charset: utf-8"
    }

    private var mApi: RestApi

    init {
        mApi = retrofit.create(RestApi::class.java)
    }

    protected suspend fun <T : AnyRequest> performApiRequest(item: T): ResponseDomain {
        return performApiRequest(item, false)
    }

    protected suspend fun <T : AnyRequest> performApiRequest(
        item: T,
        showLoadingDialog: Boolean
    ): ResponseDomain {
        if (showLoadingDialog) {
            triggerDialog()
        }

        val payload: RequestEnvelop<AnyRequest> = envelopAuth(item)
        val it: Response<JsonObject> = getRetrofitApi(payload).await()
        val body: String = when(it.code()) {
            200 -> {
                it.body()!!.toString()
            }
            else -> {
                if (it.body() != null) {
                    it.body()!!.toString()
                } else {
                    it.errorBody()!!.toString()
                }
            }
        }

        if (showLoadingDialog) {
            dismissDialog()
        }

        return ResponseDomain(it.code(), body)
    }

    private fun getRetrofitApi(payload: RequestEnvelop<AnyRequest>): Deferred<Response<JsonObject>> {
        return when(payload.requestType.requestType) {
             RequestTypes.GET -> mApi.performRequestGet(payload.postUrl, payload.header, payload.params)
             else /*RequestTypes.POST*/ -> mApi.performRequestPost(payload.postUrl, payload.header, payload.params, payload.body
            )
        }
    }

    private fun triggerDialog() {
        loadingDialogHandler.triggerDialog()
    }

    private fun dismissDialog() {
        loadingDialogHandler.dismiss()
    }

    private fun <T : AnyRequest> envelopAuth(item: T): RequestEnvelop<T> {
        return RequestEnvelop(item)
    }

    private interface RestApi {
        @Headers(
            HEADER_CONTENT_TYPE,
            HEADER_ACCEPT_CHARSET
        )
        @POST("{PATH}")
        fun performRequestPost(
            @Path(value = "PATH", encoded = true) path: String,
            @HeaderMap header: Map<String, String>,
            @QueryMap params: Map<String, String>,
            @Body envelop: JsonObject
        ): Deferred<Response<JsonObject>>

        @Headers(
            HEADER_CONTENT_TYPE,
            HEADER_ACCEPT_CHARSET
        )
        @GET("{PATH}")
        fun performRequestGet(
            @Path(value = "PATH", encoded = true) path: String,
            @HeaderMap header: Map<String, String>,
            @QueryMap params: Map<String, String>
        ): Deferred<Response<JsonObject>>
    }
}
