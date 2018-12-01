package com.example.arispanayiotou.kotlin

import com.example.arispanayiotou.kotlin.models.MovieObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by arispanayiotou on 29/11/2018
 */
interface GetMovies {

    @GET(".")
    fun getMovie(@Query("t") movie: String): Call<MovieObject>
//    fun getMovie(@Query("t") movie: String): Call<MutableList<MovieObject>>

}