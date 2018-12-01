package com.example.arispanayiotou.kotlin

import com.example.arispanayiotou.kotlin.utilities.MoviesInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


/**
 * Created by arispanayiotou on 29/11/2018
 */
class RetrofitClientInstance {

    companion object {

        private val BASE_URL = "http://www.omdbapi.com/"

        fun getRetrofitInstance(): Retrofit {


            val apiInterceptor = MoviesInterceptor("b0766a0b", 0)

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