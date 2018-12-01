package com.example.arispanayiotou.kotlin.utilities

import com.example.arispanayiotou.kotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


/**
 * Created by arispanayiotou on 29/11/2018
 */
class RetrofitClientInstance {

    companion object {

        private val BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/"

        fun getRetrofitInstance(): Retrofit {


            val apiInterceptor = MoviesInterceptor("8faac71fe7d3460081c278c3ab69c0a5", 0)

            val client: OkHttpClient =  OkHttpClient().newBuilder()
                .addInterceptor(apiInterceptor)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()


            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()


        }
    }


}