package com.example.arispanayiotou.kotlin.utilities

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by arispanayiotou on 30/11/2018
 */
class MoviesInterceptor (private val apiKey: String, private val cacheDuration: Int) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url().newBuilder()
            .addQueryParameter("api-key", apiKey)
//            .addQueryParameter("format", "json")
            .build()

        val newRequest = request.newBuilder()
            .url(url)
//            .addHeader("Cache-Control", "public, max-age=$cacheDuration") ///if you need cache
            .build()

        return chain.proceed(newRequest)
    }
}